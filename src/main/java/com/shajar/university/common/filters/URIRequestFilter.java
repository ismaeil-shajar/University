package com.shajar.university.common.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class URIRequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        // check to add year in graduate path and use default path for university path
        StringBuilder uri=new StringBuilder(req.getRequestURI());
        if(uri.indexOf("graduate") != -1){
            Calendar now = Calendar.getInstance();
            String yearInString = String.valueOf(now.get(Calendar.YEAR));
           if(! uri.toString().matches(".*graduate/20\\d{2}")){
                uri.setLength(0);
                uri.append("/projects/graduate/"+yearInString);
           }
        }else{
            uri.setLength(0);
            uri.append("/projects/university");
        }
        // update req to new value fro uri to call endpoint

        final HttpServletRequestWrapper newReq=new HttpServletRequestWrapper(req){
            @Override
            public String getRequestURI() {
                return uri.toString();
            }
        };
        System.out.println(newReq.getRequestURI());
        filterChain.doFilter(newReq,res);
    }
}
