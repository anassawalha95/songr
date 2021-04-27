package com.example.songr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/error")
    public String error(){
        return "error.html";
    }


    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello.html";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(Model m, @PathVariable String word){
        m.addAttribute("word", word.toUpperCase());
        return "capitalize.html";
    }

}
