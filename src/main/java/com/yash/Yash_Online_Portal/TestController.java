package com.yash.Yash_Online_Portal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String method()
    {
        return "Hey there";
    }
}
