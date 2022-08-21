package app_listen_music.repository;

import app_listen_music.model.Music;

import java.util.List;

public interface IMusicRepository {

    List<Music> findAll();

    void addMusic(Music music);

    void edit(Music music);

    void delete(int id);

    Music findById(int id);
}
