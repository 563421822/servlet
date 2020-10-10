package controller;

import lombok.SneakyThrows;
import service.IAddPetService;
import service.impl.AddPetServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        String breed = req.getParameter("breed");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        String description = req.getParameter("description");
        IAddPetService service = new AddPetServiceImpl();
        int result = service.add(nickname, breed, gender, birthday, description);
        if (result > 0) {
            resp.sendRedirect("ShowAllPetServlet?message=success");
        }
    }
}
