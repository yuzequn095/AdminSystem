package com.spring.admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * Login Status Check
 * 1. Configure requests should be intercepted
 * 2. put configuration in container
 */
public class LoginInterceptor implements HandlerInterceptor {

    /*
     * Before method take action
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // we should check login status here
        // because if login status is invalid, the method should not be allowed to take action

        // get the session
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("login_user");

        // we catch the login informaiton session
        if(loginUser != null){
            return true;
        }

        // if not login, jump to the login page
        // session.setAttribute("msg", "login first please");
        request.setAttribute("msg", "login first please");
        // response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request, response);
        return false;
    }

    /*
     * After method take action
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /*
     * After page rendering
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
