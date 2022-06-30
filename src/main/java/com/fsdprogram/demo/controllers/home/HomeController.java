package com.fsdprogram.demo.controllers.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1><a href=\"/api/admin/medicines\">Medicines</a></br><a href=\"/logout\">Logout</a>");
    }

    @GetMapping("/api")
    public String homeUser() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/api/admin")
    public String homeAdmin() {
        return ("<h1>Welcome Admin</h1>");
    }
}
