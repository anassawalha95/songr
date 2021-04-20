package com.example.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/helloworld")
    public String helloWorld(){
        return "hello.html";
    }

    @GetMapping("/capitalize/{word}")
    public String capitalize(Model m, @PathVariable String word){
        m.addAttribute("word", word.toUpperCase());
        return "capitalize.html";
    }
    @GetMapping("/albums")
    public String albums(Model m){
        m.addAttribute("albums" ,albumRepository.findAll());
        return "albums.html";
    }

    @GetMapping("/addAlbum")
    public String addAlbumView() {
        return "addAlbum.html";
    }

    @PostMapping("/album")
    public RedirectView addAlbum(
            @RequestParam(value ="title") String title,
            @RequestParam(value ="artist") String artist,
            @RequestParam(value ="songsCount") int songCount,
            @RequestParam(value ="length") int length,
            @RequestParam(value ="imageUrl") String imageUrl){
        System.out.println(title);
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

}
