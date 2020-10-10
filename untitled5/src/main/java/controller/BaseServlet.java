package controller;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author chenzetao
 * @Date 2020/8/17
 */
public class BaseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    /**
     * 接收所有请求的方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取到method的值
        String action = req.getParameter("method");
        //得到method对象
        Method method = getMethodByName(action);
        if (method != null) {
            //做一些方法调用前的准备工作
            executeOper(method, req, resp);

        } else {
            System.out.println("此方法不存在!!" + action);
        }
    }

    /**
     * 方法名存在执行操作的方法
     * @param method
     * @param req
     * @param resp
     */
    private void executeOper(Method method, HttpServletRequest req, HttpServletResponse resp) {//把方法对象带过来了

        //得到方法参数个数
        int parameterCount = method.getParameterCount();
        //定义一个数组来装方法参数的值
        Object[] paramValueArray = new Object[parameterCount];
        //给paramValueArray放方法参数的值
        setParamArrayValue(method, paramValueArray, req, resp);
        try {
            //调用方法
            Object result = method.invoke(this, paramValueArray);
            if (result != null) {
                //跳转页面
                reponseView(result.toString(), req, resp);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void reponseView(String result, HttpServletRequest req, HttpServletResponse resp) {
        Map<String, String> viewMap = spilt(result);
        String type = viewMap.get("type");
        String view = viewMap.get("view");
        if ("forward".equals(type)) {
            //转发
            try {
                req.getRequestDispatcher(view).forward(req, resp);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else if ("redirect".equals(type)) {
            //重定向
            try {
                resp.sendRedirect(view);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Map<String, String> spilt(String result) {
        String[] strings = result.split(":");
        Map<String, String> viewMap = new HashMap<>();
        viewMap.put("type", strings[0]);
        viewMap.put("view", strings[1]);
        return viewMap;
    }

    private void setParamArrayValue(Method method, Object[] paramValueArray, HttpServletRequest req, HttpServletResponse resp) {
        //得到方法的参数信息
        Parameter[] parameters = method.getParameters();
        //得到方法形参的名称
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        for (int i = 0; i < parameters.length; i++) {
            //得到方法参数的类型
            String simpleName = parameters[i].getType().getSimpleName();
            if ("HttpServletRequest".equals(simpleName)) {
                paramValueArray[i] = req;
            } else if ("HttpServletResponse".equals(simpleName)) {
                paramValueArray[i] = resp;
            } else if ("Integer".equals(simpleName)) {
                String parameterName = parameterNames[i];
                String value = req.getParameter(parameterName);
                paramValueArray[i] = Integer.parseInt(value);
            } else if ("String".equals(simpleName)) {
                String parameterName = parameterNames[i];
                String value = req.getParameter(parameterName);
                paramValueArray[i] = value;
            } else {
                try {
                    //对象的情况
                    //创建对象
                    Object instance = parameters[i].getType().getDeclaredConstructor().newInstance();
                    //给对象的属性赋值
                    Map<String, String[]> parameterMap = req.getParameterMap();
                    //赋值
                    //如果map中的key跟对象中的属性名称是一样的话，就会把key对应的value赋值地象的属性
                    BeanUtils.populate(instance, parameterMap);
                    //把对象放到数组中
                    paramValueArray[i] = instance;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Method getMethodByName(String action) {
        //得到所有的public方法
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(action)) {
                return method;
            }
        }
        return null;
    }
}
