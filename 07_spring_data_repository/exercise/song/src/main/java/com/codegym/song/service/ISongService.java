package com.codegym.song.service;

import com.codegym.song.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findGetId(Integer id);

    void save(Song user);
}
