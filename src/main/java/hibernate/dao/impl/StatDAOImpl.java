package hibernate.dao.impl;

import hibernate.dao.objects.StatDAO;
import hibernate.entity.Stat;
import hibernate.entity.UserData;

public class StatDAOImpl implements StatDAO {
    @Override
    public Stat getByUser(String email) {
        return null;
    }

    @Override
    public Stat getByUser(UserData userData) {
        return null;
    }
}
