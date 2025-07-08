import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration){

        if(songs.findSong(title) == null){
            return songs.add(new Song(title, duration));
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){

        Song song = songs.findSong(trackNumber);
        if(song != null)
            return playlist.add(song);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song song = songs.findSong(title);
        if(song != null)
            return playlist.add(song);
        return false;
    }

    public static class SongList {

        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if(findSong(song.getTitle()) == null)
                return songs.add(song);
            return false;
        }

        private Song findSong(String title){
            for(Song song : songs)
                if(song.getTitle().equals(title))
                    return song;
            return null;
        }

        private Song findSong(int trackNumber){
            if(trackNumber <= 0 ||  trackNumber > songs.size())
                return null;

            return songs.get(trackNumber - 1);
        }
    }
}