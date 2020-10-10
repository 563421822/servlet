package controller;

import entity.PetEntity;
import lombok.SneakyThrows;
import service.IByBreedService;
import service.impl.ByBreedServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ByInfoServlet")
public class ByBreedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String breed = req.getParameter("breed");
        IByBreedService service = new ByBreedServiceImpl();
        ArrayList<PetEntity> list = service.queryByBreed(breed);
        if (list != null) {
            req.setAttribute("list", list);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
