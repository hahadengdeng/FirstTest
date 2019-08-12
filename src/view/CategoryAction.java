package view;

import Entity.Category;
import Instrument.Page;
import Service.CategoryImpl;



public class CategoryAction {
    CategoryImpl ctImpl = new CategoryImpl();

    public Page<Category> findall(Category[] categories, Page<Category> page)  {
        return ctImpl.findall(categories, page);
    }

    public boolean add(Category category) {
        return ctImpl.add(category);
    }

    public boolean checkRename(String name, int id)  {
        return ctImpl.checkRename(name, id);
    }

    public boolean registRename(String name)  {
        return ctImpl.registRename(name);
    }

    public boolean update(Category category) {
        return ctImpl.update(category);
    }

    public boolean delectcate(String name) {
        return ctImpl.delectcate(name);
    }

    public int[] insertmore(Object [][] objects){
        return ctImpl.insertmore(objects);
    }
}
