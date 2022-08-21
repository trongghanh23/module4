package app_listen_music.model;

import org.hibernate.annotations.Table;

import javax.persistence.*;

@Entity
@Table(name="music")
public class Music {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String nameMusic;
    private String artist;
    private String kindMusic;
    private String file;

    public Music() {
    }

    public Music(String nameMusic, String artist, String kindMusic, String file) {
        this.nameMusic = nameMusic;
        this.artist = artist;
        this.kindMusic = kindMusic;
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindMusic() {
        return kindMusic;
    }

    public void setKindMusic(String kindMusic) {
        this.kindMusic = kindMusic;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
