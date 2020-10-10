package utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonUtils<T> {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    /**
     * 获得连接的方法
     *
     * @param
     * @throws ClassNotFoundException
     * @throws SQLException
     */

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "");
        }
        return connection;
    }

    /**
     * 返回对象集合
     *
     * @param
     * @param sql
     * @param args
     * @param <T>
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
//    如果类的属性名称与结果集中的表的字段名称一致
    public static <T> List<T> query(Class<T> clazz, String sql, Object... args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        ArrayList<T> list = new ArrayList<T>();
        preparedStatement = getConnection().prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            //        获得新的类的反射对象
            T t = clazz.getDeclaredConstructor().newInstance();
            //        获取结果集中的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
//        通过元数据获得结果集中列的个数
            int columnCount = metaData.getColumnCount();
//            获得属性对象的数组
            for (int i = 0; i < columnCount; i++) {
                //            遍历列数获取当前列名
                String columnName = metaData.getColumnName(i);
                //            结果集通过列名获取值
                Object value = resultSet.getObject(columnName);
//                通过列名一致得到类中的属性的反射对象
                Field field = clazz.getDeclaredField(columnName);
//                设置访问权限
                field.setAccessible(true);
//                给属性复制,相当于setMethod()方法
                field.set(t, value);
            }
//            将类的反射对象存到集合中
            list.add(t);
        }
        return list;
    }

    //    如果表字段的类属性名称不一致的情况
    public <T> List<T> queryList(String sql, Class<T> clazz, Object... params) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        List<T> list = new ArrayList<T>();
        preparedStatement = getConnection().prepareStatement(sql);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        resultSet = preparedStatement.executeQuery();
//        获得类已声明的属性的数组
        Field[] fields = clazz.getDeclaredFields();
//        遍历结果集
        while (resultSet.next()) {
//            每循环一次,创建一个对象来存放这一行的数据
            Object value;
//             获得构造器对象
            T t = clazz.getDeclaredConstructor().newInstance();
//            遍历类的属性的数组
            for (int i = 0; i < fields.length; i++) {
//                获得第i个属性的名字
                String name = fields[i].getName();
//                将属性名字放入结果集进行提取(原以为类的属性和结果集中表的字段名一致)
                try {
                    value = resultSet.getObject(name);
                } catch (SQLException e) {
                    //用属性名字提取结果集中列的表名失败(不一致)的话出现异常跳入catch块,
//                    读取mapper.properties文件
                    Properties properties = new Properties();
                    properties.load(this.getClass().getClassLoader().getResourceAsStream("mapper.properties"));
                    value = resultSet.getObject(properties.getProperty(name));
                }
//                设置访问权限
                fields[i].setAccessible(true);
//                给对象属性复制
                fields[i].set(t, value);
            }
//            把对象循环地添加到集合中
            list.add(t);
        }
        return list;
    }
}
