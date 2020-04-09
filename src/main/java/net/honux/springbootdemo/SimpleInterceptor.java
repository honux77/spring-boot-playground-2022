package net.honux.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log =
            LoggerFactory.getLogger(SimpleInterceptor.class);
    private static final String TIME = "TIME";
    private static final String URL = "URL";
    private static final String METHOD = "METHOD";



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        request.setAttribute(TIME, System.currentTimeMillis());
        request.setAttribute(URL, request.getRequestURL());
        request.setAttribute(METHOD, request.getMethod());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        long startTime = (long)request.getAttribute(TIME);
        log.debug("{} {} {}", request.getAttribute(METHOD), request.getAttribute(URL), System.currentTimeMillis() - startTime);
    }
}
