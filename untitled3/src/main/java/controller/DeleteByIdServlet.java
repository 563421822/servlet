package controller;

import lombok.SneakyThrows;
import service.IDeleteByIdService;
import service.impl.DeleteByIdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/DeleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        IDeleteByIdService service = new DeleteByIdServiceImpl();
        int result = service.deleteById(id);
        if (result > 0) {
            resp.sendRedirect("ShowAllServlet?mess=" + new Date().getTime());
        }
    }
}
