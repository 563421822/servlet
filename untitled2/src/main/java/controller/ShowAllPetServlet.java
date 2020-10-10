package controller;

import entity.PetEntity;
import lombok.SneakyThrows;
import service.IShowAllPetService;
import service.impl.ShowAllPetServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@WebServlet("/ShowAllPetServlet")
public class ShowAllPetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        IShowAllPetService service = new ShowAllPetServiceImpl();
        ArrayList<PetEntity> list = service.show();
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
