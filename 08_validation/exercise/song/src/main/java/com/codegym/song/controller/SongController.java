package com.codegym.song.controller;

import com.codegym.song.dto.SongDto;
import com.codegym.song.model.Song;
import com.codegym.song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String listSong(Model model) {
        model.addAttribute("songList", this.iSongService.findAll());
        return ("/list");
    }

    @GetMapping("/showCreate")
    public String update(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/create/save")
    public String saveCreate(@ModelAttribute("song") @Valid SongDto songDto, BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        this.iSongService.save(song);
        return "redirect:/";
    }

    @GetMapping("/showUpdate")
    public String showFormUpdate(@RequestParam int id, Model model) {
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(iSongService.findGetId(id), songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }

    @PostMapping("/update/save")
    public String updateSong(@ModelAttribute @Valid SongDto songDto,
                             BindingResult bindingResult) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.save(song);

        return "redirect:/";
    }

}
