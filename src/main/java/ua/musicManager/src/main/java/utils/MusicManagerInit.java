package utils;

import dao.*;
import entities.*;

import java.util.*;

public class MusicManagerInit {

    AlbumDao albumDao = new AlbumDao();
    TrackDao trackDao = new TrackDao();
    Random random = new Random();
    OrderDao orderDao = new OrderDao();
    CustomerDao customerDao = new CustomerDao();


    public void musicCascadeInit() {

        MusicManagerInit init = new MusicManagerInit();
//        init.tracksInit();
//        init.albumsInit();
        init.musicInit();
        init.orderInit();
        init.addManyEntities();
    }
//    I don’t quite understand why it doesn't work.
//    I haven't found a solution to the problem yet.
//
//    private void tracksInit() {
//
//        List<Artist> artists = new ArrayList<>();
//        artists.add(new Artist("Freddy Mercury"));
//        artists.add(new Artist("Joan Stingray"));
//        artists.add(new Artist("Sting"));
//        artists.add(new Artist("Elton Jon"));
//        artists.add(new Artist("Sher"));
//
//        Artist artist;
//        Track track = new Track();
//        TrackDao trackDao = new TrackDao();
//        for (int i = 0; i < 30; i++) {
//
//            artist = artists.get(random.nextInt(5));
//            track.setTitle("Track" + (i + 1));
//            track.setPrice(50 + random.nextInt(50));
//            track.setArtist(artist);
//            trackDao.createInstance(track);
//        }
//    }
//
//    private void albumsInit() {
//
//        for (int j = 1; j <= 3; j++) {
//            Album album = new Album();
//            album.setTitle("Album" + j);
//            albumDao.createInstance(album);
//            int count = 0;
//            while (!(count == 10)){
//                Track track = trackDao.getInstanceById(1+random.nextInt(29));
//                albumDao.addTrackToAlbum(album, track);
//                count +=1;
//            }
//        }
//    }

    private void musicInit() {

        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("Freddy Mercury"));
        artists.add(new Artist("Joan Stingray"));
        artists.add(new Artist("Sting"));
        artists.add(new Artist("Elton Jon"));
        artists.add(new Artist("Sher"));

        Artist artist;

        for (int j = 1; j <= 3; j++) {
            Album album = new Album();
            album.setTitle("Album" + j);
            albumDao.createInstance(album);
            for (int i = 0; i < 9; i++) {
                Track track = new Track();
                artist = artists.get(random.nextInt(5));
                track.setTitle("Track" + j + (i + 1));
                track.setPrice(50 + random.nextInt(50));
                track.setArtist(artist);
                albumDao.addTrackToAlbum(album, track);
            }
        }
    }

    private void orderInit() {

        Customer customer = new Customer("Jone Smith", "jone.smith@email.com", "Jone Smith address");
        customerDao.createInstance(customer);
        Order order = new Order();
        orderDao.createInstance(order, customer);
        Album album = albumDao.getInstanceById(1);
        Album album1 = albumDao.getInstanceById(2);
        Track track = trackDao.getInstanceById(9);
        orderDao.addAlbumToOrder(order, album);
        orderDao.addAlbumToOrder(order, album1);
        orderDao.addTrackToOrder(order, track);
    }

    private void addManyEntities() {

        trackDao.createManyInstance(2000000);
    }

}

