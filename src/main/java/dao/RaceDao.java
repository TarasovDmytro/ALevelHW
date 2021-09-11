package dao;

import entities.Race;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class RaceDao {

    public boolean createInstance(Race race) {
        boolean created = true;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(race);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                created = false;
            }
            e.printStackTrace();
        }
        return created;
    }

    public void updateInstance(Race race) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(race);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Race getInstanceById(int id) {
        Transaction transaction = null;
        Race race = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            race = session.get(Race.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return race;
    }


    public List<Race> getAllInstance() {
        List<Race> races = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            races = session.createQuery("from entities.Race", Race.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return races;
    }
}
