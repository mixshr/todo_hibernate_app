package hibernate.dao.impl;

import hibernate.HibernateUtil;
import hibernate.dao.FindDAO;
import hibernate.dao.objects.TaskDAO;
import hibernate.entity.Task;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TaskDAOImpl implements TaskDAO<Task>, FindDAO<Task> {

    @Override
    public List<Task> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task");
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public List<Task> findAll(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task AS t where t.userData.email=:email");
        query.setParameter("email", email);
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public Task get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task = session.get(Task.class, id);
        session.close();

        return task;
    }

    @Override
    public void update(Task obd) {
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
        Task task = new Task();
       // Task.setId(id);
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Task obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Task> find(boolean completed, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Task> query = session.createQuery("FROM Task AS t where t.userData.email=:email and t.completed=:completed");
        query.setParameter("email", email);
        query.setParameter("completed", completed);
        List<Task> list = query.getResultList();
        session.close();
        return list;
    }
}