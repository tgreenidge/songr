package com.tgreenidge.songr.SongApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/")
    public String getAllAlbums(Model m) {
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allAlbums.html";
    }

    @GetMapping("/allalbums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "allAlbums.html";
    }

    @GetMapping("/newAlbum")
    public String albumForm(Model model) {
        model.addAttribute("album", new Album());
        return "newAlbum";
    }

    @PostMapping("/newAlbum")
    public String albumSubmit(@ModelAttribute("album") Album album) {
        System.out.println(album.getTitle());
        albumRepository.save(album);
        return "newAlbumConfirmation";
    }
}
