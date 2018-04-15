package servlets;

import common.DBService;
import common.Deal;
import common.Global;
import dao.DealDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DealPageServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int minPrice = 0;
        int maxPrice = 99999;
        String clientName = Global.NONE;
        String productName = Global.NONE;

        DBService.createСonnection();

        if (request.getParameter("min") != null && !request.getParameter("min").equals("")) {
            minPrice = Integer.parseInt(request.getParameter("min"));
        }
        if (request.getParameter("max") != null && !request.getParameter("max").equals("")) {
            maxPrice = Integer.parseInt(request.getParameter("max"));
        }
        if (request.getParameter("clientName") != null) {
            clientName = request.getParameter("clientName");
        }
        if (request.getParameter("productName") != null) {
            productName = request.getParameter("productName");
        }
        ArrayList<Deal> deals = DealDao.getDeals(minPrice, maxPrice, -1, clientName, productName);
        request.setAttribute("deals", deals);
        getServletContext().getRequestDispatcher("/deal.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dealId;
        if (request.getParameter("dealId") != null) {
            dealId = Integer.parseInt(request.getParameter("dealId"));
            DealDao.changeDealStatus(dealId);
        }
        processRequest(request, response);
    }
}
