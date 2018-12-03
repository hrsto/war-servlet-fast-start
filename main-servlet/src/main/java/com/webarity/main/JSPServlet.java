package com.webarity.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JSPServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        
        String rqPath = rq.getAttribute("rqPath").toString();

        try {
            if (rqPath == null || rqPath.compareTo("/") == 0) {
                getServletContext().getRequestDispatcher("/pages/index.jsp").include(rq, rs);
            } else {
                getServletContext().getRequestDispatcher(String.format("/pages%s.jsp", rqPath)).include(rq, rs);
            }
            
        } catch (ServletException | IOException ex) {
            ex.printStackTrace();
            try {
                rs.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("%s not found.", rqPath));
            } catch (Exception e) {}
        }
    }
}