package hibernate.dao.objects;

import hibernate.dao.CommonDAO;
import hibernate.dao.FindDAO;
import hibernate.entity.Task;

import java.util.List;

public interface TaskDAO<T> extends CommonDAO<Task>, FindDAO<Task> {

    List<Task> find(boolean completed, String email);


}