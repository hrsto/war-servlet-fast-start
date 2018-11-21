package com.webarity.controllers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;

// @Controller
// @RequestMapping("/thing")
public class TestCtrl implements HttpRequestHandler, ServletContextAware {

    private String someString;
    private ServletContext ctx;

    // @GetMapping(path="/test", produces="text/plain;charset=UTF-8")
    // @ResponseBody
    public String testt() {
        
        org.springframework.web.HttpRequestHandler rh;
        org.springframework.web.context.support.HttpRequestHandlerServlet rhs;
        return someString;
    }

    public void setSomeString(String s) {
        this.someString = s;
    }

	@Override
	public void handleRequest(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        // rs.getWriter().write(testt() + ctx.getContextPath());
        ctx.getRequestDispatcher(String.format("/WEB-INF/jsp/test.jsp")).forward(rq, rs);
        // rs.flushBuffer();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.ctx = servletContext;
	}
}