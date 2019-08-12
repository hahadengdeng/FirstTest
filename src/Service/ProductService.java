package Service;

import Entity.Product;
import Instrument.Page;



public interface ProductService {
    public int count() ;

    public Page<Product> findall(Product[] products, Page<Product> page) ;

    public boolean add(Product product);

    public boolean checkRename(String name, int id) ;

    public boolean addRename(String name) ;

    public boolean updateduct(Product product);

    public boolean delectduct(String name);

    public int[] insertmore(Object[][] objects);
}
