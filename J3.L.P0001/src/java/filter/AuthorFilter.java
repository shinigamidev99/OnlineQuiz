/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Administrator
 */
public class AuthorFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession session = req.getSession();

            Account acc = (Account) session.getAttribute("login");

            if (acc == null) {
                req.setAttribute("error", "This function required login!");
            } else {
                if (!acc.isUserType()) {
                    req.setAttribute("errorInFilter", "This function required role teacher!");
                }
            }
            
            chain.doFilter(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", ex + " tan");
            request.getRequestDispatcher("handler-error").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
