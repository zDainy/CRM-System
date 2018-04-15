package servlets;

import common.*;
import dao.ClientDao;
import dao.DealDao;
import dao.ProductDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class NewDealPageServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBService.createСonnection();

        ArrayList<Product> products = ProductDao.getProducts();
        request.setAttribute("products", products);
        ArrayList<Client> clients = ClientDao.getClients();
        request.setAttribute("clients", clients);
        ArrayList<Status> statuses = DealDao.getStatuses();
        request.setAttribute("statuses", statuses);

        getServletContext().getRequestDispatcher("/newDeal.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int clientId = 0;
        int productId = 0;
        int statusId = 0;
        String comment = "";

        if (request.getParameter("clientSelect") != null) {
            clientId = Integer.parseInt(request.getParameter("clientSelect"));
        }
        if (request.getParameter("productSelect") != null) {
            productId = Integer.parseInt(request.getParameter("productSelect"));
        }
        if (request.getParameter("statusSelect") != null) {
            statusId = Integer.parseInt(request.getParameter("statusSelect"));
        }
        if (request.getParameter("comment") != null) {
            comment = new String(request.getParameter("comment").getBytes("ISO-8859-1"),"UTF-8");
        }
        if (clientId != 0 && productId != 0 && statusId != 0) {
            DealDao.createDeal(statusId, clientId, productId, comment);
            ArrayList<Deal> deals = DealDao.getDeals(0, 999999, -1, Global.NONE, Global.NONE);
            request.setAttribute("deals", deals);
            getServletContext().getRequestDispatcher("/deal.jsp").forward(request, response);
        }
    }
}
