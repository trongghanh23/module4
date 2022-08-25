package com.codegym.song.service.impl;

import com.codegym.song.model.Song;
import com.codegym.song.repository.ISongRepository;
import com.codegym.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Song findGetId(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song user) {
        iSongRepository.save(user);

    }
}
