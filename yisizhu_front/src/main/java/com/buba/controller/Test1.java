package com.buba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test1 {

    @RequestMapping("/test")
        public String test1 () {
            return "indexYES";
        }

}
