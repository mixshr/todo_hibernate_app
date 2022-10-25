package hibernate;

import hibernate.dao.objects.TaskDAO;
import hibernate.dao.impl.TaskDAOImpl;
import hibernate.entity.Task;
import lombok.extern.log4j.Log4j2;

// import javax.management.Query;
// import jakarta.persistence.Query;

@Log4j2
public class Main {
    public static void main(String[] args) {

        /*UserDAOImpl userDAO = new UserDAOImpl();

        UserData userData = userDAO.get(10026L);
        log.info(userData);

        log.info(userDAO.findAll());*/

        TaskDAO<Task> taskDAO = new TaskDAOImpl();
        log.info(taskDAO.find(true, "email2@gmail.com"));

        HibernateUtil.close();
    }
}