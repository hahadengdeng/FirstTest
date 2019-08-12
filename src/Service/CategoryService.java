package Service;

import Entity.Category;
import Instrument.Page;


public interface CategoryService {
    public Page<Category> findall(Category[] categories, Page<Category> page) ;

    public int count();

    public boolean add(Category category);

    public boolean checkRename(String name, int id) ;

    public boolean registRename(String name);

    public boolean update(Category category);

    public boolean delectcate(String name);

    public int[] insertmore(Object[][] objects);
}
