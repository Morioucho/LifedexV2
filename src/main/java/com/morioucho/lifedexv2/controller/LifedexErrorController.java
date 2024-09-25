package com.morioucho.lifedexv2.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class LifedexErrorController implements ErrorController {
    @RequestMapping("/error")
    public String handleError() {
        return "lifedexError";
    }
}
