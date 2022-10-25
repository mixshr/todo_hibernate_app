package hibernate.dao.impl;

import hibernate.HibernateUtil;
import hibernate.dao.CommonDAO;
import hibernate.dao.FindDAO;
import hibernate.entity.UserData;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements CommonDAO<UserData>, FindDAO<UserData> {

    @Override
    public List<UserData> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<UserData> query = session.createQuery("FROM UserData");
        List<UserData> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<UserData> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<UserData> query = session.createQuery("FROM UserData where email=:email");
        query.setParameter("email", email);
        List<UserData> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public UserData get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        UserData  userData = session.get(UserData.class, id);
        session.close();

        return userData;
    }

    @Override
    public void update(UserData obd) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obd);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UserData userData = new UserData();
        userData.setId(id);
        session.delete(userData);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(UserData obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }
}
