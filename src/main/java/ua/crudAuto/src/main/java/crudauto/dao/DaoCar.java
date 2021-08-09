package crudauto.dao;

import crudauto.entitys.Car;
import crudauto.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DaoCar {

    public boolean createAuto(Car car) {

        boolean created = true;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(car);
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

    public boolean updateAuto(int carId, Car currentCar) {

        boolean updated = true;
        Transaction transaction = null;
        if (checkId(carId)) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                if (!currentCar.getTitle().equals("")) {
                    String hql = "UPDATE Car set title = :carTitle " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carTitle", currentCar.getTitle());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                if (currentCar.getPrice() != 0) {
                    String hql = "UPDATE Car set price = :carPrice " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carPrice", currentCar.getPrice());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                if (currentCar.getManufactureDate() != null) {
                    String hql = "UPDATE Car set manufactureDate = :carManufactureDate " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carManufactureDate", currentCar.getManufactureDate());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                if (currentCar.getSellDate() != null) {
                    String hql = "UPDATE Car set sellDate = :carSellDate " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carSellDate", currentCar.getSellDate());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                if (!currentCar.getGearType().equals("")) {
                    String hql = "UPDATE Car set gearType = :carGearType " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carGearType", currentCar.getGearType());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                if (currentCar.getFuelVolume() != 0) {
                    String hql = "UPDATE Car set fuelVolume = :carFuelVolume " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carFuelVolume", currentCar.getFuelVolume());
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } else {
            System.out.println("id = " + carId + " not found");
            updated = false;
        }
        return updated;
    }

    public Car fetchById(int carId, Car currentCar) {

        Transaction transaction = null;
        if (checkId(carId)) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                String hql = " FROM Car C WHERE C.id = :carId";
                Query query = session.createQuery(hql);
                query.setParameter("carId", carId);
                currentCar = (Car) query.getSingleResult();
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } else {
            System.out.println("id = " + carId + " not found");
            currentCar = null;
        }
        return currentCar;
    }

    public List fetchByName(String carTitle) {

        Transaction transaction = null;
        List carsByName = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Car C WHERE C.title = :carTitle";
            Query query = session.createQuery(hql);
            query.setParameter("carTitle", carTitle);
            carsByName = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return carsByName;
    }

    public List fetchByPriceRange(double priceMin, double priceMax) {

        List carsByRange = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = " FROM Car C WHERE C.price BETWEEN '" + priceMin + "' AND '" + priceMax + "'";
            Query query = session.createQuery(hql);
            carsByRange = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return carsByRange;
    }

    public List<Car> fetchAll() {

        List<Car> allCars = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            allCars = session.createQuery("from Car", Car.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allCars;
    }

    public boolean deleteAuto(int carId) {

        boolean deleted = true;
        Transaction transaction = null;
        if (checkId(carId)) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                Car car = session.get(Car.class, carId);
                if (car != null) {
                    String hql = "DELETE FROM Car " + "WHERE id = :carId";
                    Query query = session.createQuery(hql);
                    query.setParameter("carId", carId);
                    int result = query.executeUpdate();
                    System.out.println("Rows affected: " + result);
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        } else {
            System.out.println("id = " + carId + " not found");
            deleted = false;
        }
        return deleted;
    }

    public boolean deleteAllAutos() {

        boolean deleteAll = true;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Car ";
            Query query = session.createQuery(hql);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                deleteAll = false;
            }
            e.printStackTrace();
        }
        return deleteAll;
    }

    private boolean checkId(int carId) {

        boolean checkId = false;
        List allId;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            allId = session.createQuery("select id from Car").list();
            checkId = allId.contains(carId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkId;
    }
}
