package hibernate.dao.objects;

import hibernate.entity.Stat;
import hibernate.entity.UserData;

public interface StatDAO {

    Stat getByUser(String email);
    Stat getByUser(UserData userData);

}