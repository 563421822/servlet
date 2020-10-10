package controller;

import lombok.SneakyThrows;
import service.IAddService;
import service.impl.AddServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String districtName = req.getParameter("districtName");
        String monitorTime = req.getParameter("monitorTime");
        String rain = req.getParameter("rain");
        String monitoringStation = req.getParameter("monitoringStation");
        String monitoringAddress = req.getParameter("monitoringAddress");
        IAddService service = new AddServiceImpl();
        int result = service.add(districtName, monitorTime, rain, monitoringStation, monitoringAddress);
        if (result > 0) {
            resp.sendRedirect("ShowAllServlet?mess=" + new Date().getTime());
        }
    }
}
