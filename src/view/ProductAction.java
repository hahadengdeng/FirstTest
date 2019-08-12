package view;

import Entity.Product;
import Instrument.Page;
import Service.ProductImpl;



public class ProductAction {
    ProductImpl pdImpl = new ProductImpl();

    public Page<Product> findall(Product[] products, Page<Product> page){
        return pdImpl.findall(products, page);
    }

    public boolean addduct(Product product) {
        return pdImpl.add(product);
    }

    public boolean checkRename(String name, int id) {
        return pdImpl.checkRename(name, id);
    }

    public boolean addRename(String name){
        return pdImpl.addRename(name);
    }

    public boolean updateduct(Product product) {
        return pdImpl.updateduct(product);
    }

    public boolean delectduct(String name) {
        return pdImpl.delectduct(name);
    }

    public int[] insertmore(Object[][] objects){
        return  pdImpl.insertmore(objects);
    }
}
