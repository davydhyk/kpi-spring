package com.example.spring.middleware;

import com.example.spring.models.User;
import com.example.spring.repositories.interfaces.IUserRepository;
import com.example.spring.services.interfaces.IUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserMiddleware implements HandlerInterceptor {

    private final IUserService userService;

    public UserMiddleware(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            String userIp = request.getRemoteAddr();
            user = userService.getByIp(userIp);
            if (user == null) {
                user = new User(userIp);
            }
            userService.create(user);
            request.getSession().setAttribute("user", user);
        }
        System.out.println(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if (modelAndView == null) return;
        modelAndView.addObject("user", user);
    }
}
