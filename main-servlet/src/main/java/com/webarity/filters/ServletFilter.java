package com.webarity.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 */
public class ServletFilter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain fc) throws IOException, ServletException {
        if (rq instanceof HttpServletRequest) {
            HttpServletRequest temp = (HttpServletRequest)rq;

            String rqPath = temp.getRequestURI().substring(temp.getContextPath().length());

            if (!rqPath.startsWith("/media")) {
                rq.setAttribute("rqPath", rqPath);
                rq.getRequestDispatcher("/pages").forward(rq, rs);
            } else {
                //TODO: return media
                rq.getRequestDispatcher("/").forward(rq, rs);
            }
        }
    }

    @Override
    public void destroy() {
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }
    
}