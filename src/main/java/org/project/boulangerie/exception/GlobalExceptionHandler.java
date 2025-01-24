package org.project.boulangerie.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        HttpSession session = request.getSession();
        session.setAttribute("eswal", e.getMessage());
        String referer = request.getHeader("Referer");
        return "redirect:" + (referer != null ? referer : "");
    }
}
