package controller;

import lombok.SneakyThrows;
import service.IAddProductService;
import service.impl.AddProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String riskLevel = req.getParameter("riskLevel");
        String prospectiveEarning = req.getParameter("prospectiveEarning");
        String startSale = req.getParameter("startSale");
        String endSale = req.getParameter("endSale");
        String expire = req.getParameter("expire");
        IAddProductService service = new AddProductServiceImpl();
        int result = service.add(id, riskLevel, prospectiveEarning, startSale, endSale, expire);
        if (result > 0) {
            resp.sendRedirect("ShowAllServlet?message=success");
        }
    }
}

