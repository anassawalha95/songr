package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String getSongRepository(Model model) {
        model.addAttribute("songs",songRepository.findAll());
        return "songs.html";
    }


    @PostMapping("/album/{id}")
    public RedirectView addSong( @PathVariable(value="id") int id, String title, int length, String trackNumber) {
        try {
        Album album = albumRepository.findById(id).get();
        Song newSong = new Song( title, length, trackNumber,album);
        songRepository.save(newSong);


        }catch (Exception e){
            System.out.println(e);
            return new RedirectView("/error");
        }
        return new  RedirectView("/album/" + id);
    }

}
