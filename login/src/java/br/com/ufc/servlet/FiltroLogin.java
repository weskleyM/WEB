package br.com.ufc.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
  
@WebFilter("/*")
public class FiltroLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sessao = httpRequest.getSession();
        if(sessao.getAttribute("usuarioLogado") != null || httpRequest.getRequestURI().endsWith("loginForm") || httpRequest.getRequestURI().endsWith("efetuarLogin") || httpRequest.getRequestURI().contains("resources")) {
        chain.doFilter(request, response);
        return;
        }
        httpResponse.sendRedirect("loginForm");
    }
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
        
    }
    
}