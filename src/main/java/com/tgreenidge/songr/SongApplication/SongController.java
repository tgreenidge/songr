package com.tgreenidge.songr.SongApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }

    @GetMapping("/songs/new")
    public String getNewSongForm(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("song", new Album());

        return "newSong";
    }

    @PostMapping("/songs/new")
    public RedirectView addSong(@RequestParam String title, @RequestParam String album, @RequestParam  Integer trackNumber, @RequestParam  Integer length) {
        System.out.println(album);
            List<Album> albumsWithThatTitle = albumRepository.findByTitle(album);
        if(albumsWithThatTitle.size() > 0) {
            Song song = new Song(title, length, trackNumber, albumsWithThatTitle.get(0));
            songRepository.save(song);
            return new RedirectView("/songs");
        } else {
            Album albumToSave = new Album(album);
            albumRepository.save(albumToSave);
            Song song = new Song(title, length, trackNumber, albumToSave);
            songRepository.save(song);
            return new RedirectView("/songs");
        }
    }
}
