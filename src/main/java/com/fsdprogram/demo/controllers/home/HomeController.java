package com.fsdprogram.demo.controllers.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        String str_html = """
            <h1>Welcome</h1>
            <a href=\"/api/admin/medicines\">Medicines</a>
            </br>
            <a href=\"/api/admin/user\">Users</a>
            </br>
            <a href=\"/perform_logout\">Logout</a>
            """;
        return (str_html);
    }

    @GetMapping("/api")
    public String homeUser() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/api/admin")
    public String homeAdmin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @GetMapping("/perform_logout")
    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null)
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        return "redirect:/login";
    }
}
