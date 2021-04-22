package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String albums(Model m){
        m.addAttribute("albums" ,albumRepository.findAll());
        return "albums.html";
    }

    @GetMapping("/album/{id}")
    public String getDetaislView (@PathVariable(value="id") int id, Model m) {
        m.addAttribute("album", albumRepository.findById(id).get());

        return "/details.html";
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
