package servlets;

import common.DBService;
import common.Deal;
import common.Global;
import dao.ClientDao;
import dao.DealDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ClientPageServlet extends HttpServlet {
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBService.createСonnection();
        getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String address = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
        String number = new String(request.getParameter("number").getBytes("ISO-8859-1"),"UTF-8");
        String passport = new String(request.getParameter("passport").getBytes("ISO-8859-1"),"UTF-8");
        if (!name.equals("") && !address.equals("") && !passport.equals("")) {
            ClientDao.createClient(name, address, number, passport);
            ArrayList<Deal> deals = DealDao.getDeals(0, 999999, -1, Global.NONE, Global.NONE);
            request.setAttribute("deals", deals);
            getServletContext().getRequestDispatcher("/deal.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
        }
    }
}
