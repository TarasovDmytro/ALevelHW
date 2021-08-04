package dao;

import entities.Album;
import entities.Artist;
import entities.Track;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;

public class AlbumDao {

    public void createInstance(Album album) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(album);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateInstance(Album album) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(album);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Album getInstanceById(int id) {

        Transaction transaction = null;
        Album album = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            album = session.get(Album.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return album;
    }


    public List<Album> getAllInstance() {

        List<Album> albums = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            albums = session.createQuery("from entities.Album", Album.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return albums;
    }

    public void deleteInstanceById(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Album instance = session.get(Album.class, id);
            if (instance != null) {
                session.delete(instance);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteAllInstance() {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM entities.Album ";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void addTrackToAlbum(Album album, Track track) {

        if (!album.getTracks().contains(track)) {
            Artist artist = track.getArtist();
            album.getTracks().add(track);
            album.setPrice(album.getPrice() + track.getPrice());
            album.getArtists().add(artist);
            updateInstance(album);
        } else {
            System.out.println("This track is already on this album");
        }
    }

    public void deleteTrackFromAlbum(Album album, Track track) {

        if (album.getTracks().contains(track)) {
            album.getTracks().remove(track);
            album.setPrice(album.getPrice() - track.getPrice());
            updateInstance(album);
        } else {
            System.out.println("There is no such track in this album");
        }
    }
}
