package controller;

import entity.FinanceEntity;
import lombok.SneakyThrows;
import service.IShowALLService;
import service.impl.ShowAllServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IShowALLService service = new ShowAllServiceImpl();
        ArrayList<FinanceEntity> list = service.queryAll();
        if (list != null) {
            String message = req.getParameter("message");
            if ("success".equals(message)) {
                req.setAttribute("message", "添加成功!");
            }
            req.setAttribute("list", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
