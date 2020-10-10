package controller;

import entity.FinanceEntity;
import lombok.SneakyThrows;
import service.IFiltrateService;
import service.impl.FiltrateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/FiltrateServlet")
public class FiltrateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String riskLevel = req.getParameter("riskLevel");
        IFiltrateService service = new FiltrateServiceImpl();
        ArrayList<FinanceEntity> list = service.filtrate(id, riskLevel);
        if (list != null) {
            req.setAttribute("list", list);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
