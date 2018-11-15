package com.webarity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/thing")
public class TestCtrl {

    private String qweee;

    @GetMapping(path="/test", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String testt() {
        return qweee;
    }

    public void setQweee(String s) { this.qweee = s; }
}