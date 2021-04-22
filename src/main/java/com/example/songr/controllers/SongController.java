package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;




    @PostMapping("/album/{id}")
    public RedirectView addSong( @PathVariable(value="id") int id, String title, int length, String trackNumber) {
        Album album = albumRepository.findById(id).get();
        Song newSong = new Song( title, length, trackNumber,album);
        songRepository.save(newSong);
        return new  RedirectView("/album/" + id);
    }

}
