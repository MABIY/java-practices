package com.example.messagingstompwebsocket;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lh
 */
@RequestMapping("/test")
@RestController
public class TestController {
    @GetMapping("/1")
    public String test(HttpServletRequest httpServletRequest){
        httpServletRequest.getSession().getId();
        return "dfas";
    }
}
