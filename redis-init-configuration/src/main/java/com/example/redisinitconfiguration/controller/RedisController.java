package com.example.redisinitconfiguration.controller;

import com.example.redisinitconfiguration.data.User;
import com.example.redisinitconfiguration.service.RedisService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RedisController {

    private final RedisService redisService;

    @GetMapping("/test")
    public String getUser(@RequestParam String name){
        return redisService.getUser(name);
    }

    @PostMapping("/test")
    public void setUser(@RequestBody User request){
        redisService.setUser(request);
    }


//    @Getter
//    @Setter
//    class Request{
//        private int id;
//        private String name;
//        private int age;
//    }
}
