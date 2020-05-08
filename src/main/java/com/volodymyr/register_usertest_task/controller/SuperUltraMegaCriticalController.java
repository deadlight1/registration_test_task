package com.volodymyr.register_usertest_task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperUltraMegaCriticalController {

    @GetMapping("/main/greeting")
    public String getHelloWorldPage() {
        return "hello_world";
    }
}
