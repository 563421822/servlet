package controller;

import entity.RainEntity;
import lombok.SneakyThrows;
import service.IShowAllService;
import service.impl.ShowAllServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        IShowAllService service = new ShowAllServiceImpl();
        ArrayList<RainEntity> list = service.show();
        System.out.println(list);
        String mess = req.getParameter("mess");
//        判断是否有参数传过来
        if (mess != null) {
            try {
                //            输入的时间
                long early = Long.parseLong(req.getParameter("mess"));
                //现在的时间
                long current = new Date().getTime();
                if (current - early < 80) {
                    req.setAttribute("success", "操作成功");
                }
            } catch (Exception ignored) {
            }
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
