package hibernate.dao.objects;

import hibernate.dao.CommonDAO;
import hibernate.dao.FindDAO;
import hibernate.entity.Category;

public interface CategoryDAO extends CommonDAO<Category>, FindDAO<Category> {
}
