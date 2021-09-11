package dao;

import entities.Horse;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class HorseDao {

    public void createInstance(Horse horse) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(horse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateInstance(Horse horse) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(horse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Horse getInstanceById(int id) {
        Transaction transaction = null;
        Horse horse = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            horse = session.get(Horse.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return horse;
    }


    public List<Horse> getAllInstance() {
        List<Horse> horses = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            horses = session.createQuery("from entities.Horse", Horse.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return horses;
    }
}
