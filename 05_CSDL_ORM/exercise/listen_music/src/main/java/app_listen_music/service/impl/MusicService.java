package app_listen_music.service.impl;

import app_listen_music.model.Music;
import app_listen_music.repository.IMusicRepository;
import app_listen_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void addMusic(Music music) {
        iMusicRepository.addMusic(music);
    }

    @Override
    public void edit(Music music) {
        iMusicRepository.edit(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }
}
