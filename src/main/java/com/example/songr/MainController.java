package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

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

        Album rockTheHighway  = new Album("Rock the HighwayGirish And The Chronicles","Girish And The Chronicles",13,1000,"https://musicfromtheheart.eu/images/CD_reviews/Girish_The_Chronicles_Rock_The_Highway.png");
        Album infinite  = new Album("Infinite ","Eminem ",11,38,"https://i.pinimg.com/736x/cb/4b/cd/cb4bcd3c0e7d21d6787f3471f27df3c7.jpg");
        Album backstreetsBack = new Album("Backstreet's Back","Backstreet Boys",11,50,"https://upload.wikimedia.org/wikipedia/en/e/eb/Backstreet%27s_Back_cover.jpg");

        List<Album> albums = new ArrayList<>();

        albums.add(rockTheHighway);
        albums.add(infinite);
        albums.add(backstreetsBack);
        m.addAttribute("albums",albums);
        return "albums.html";
    }

}
