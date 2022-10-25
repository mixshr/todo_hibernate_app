package hibernate.dao.objects;

import hibernate.dao.CommonDAO;
import hibernate.dao.FindDAO;
import hibernate.entity.UserData;

public interface UserDAO extends CommonDAO<UserData>, FindDAO<UserData> {

    UserData getByEmail(String email);

}
