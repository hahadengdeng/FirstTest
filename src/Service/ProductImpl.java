package Service;

import Dao.BaseDao;
import Dao.ProductDaoImpl;
import Entity.Product;
import Entity.Provider;
import Entity.Category;
import Instrument.DBHelper;
import Instrument.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductService {
    ResultSet rs;
    ProductDaoImpl pddaoImpl = new ProductDaoImpl();
    List<Product> list = new ArrayList<Product>();
    Connection conn= DBHelper.getConnection();
    BaseDao bs=new BaseDao();

    @Override
    public int count(){
        String sql = "select count(productID) from products ";
        int countnum = 0;
        rs = pddaoImpl.count(conn,sql);
        try {
            if (rs.next()) {
                countnum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return countnum;
    }

    @Override
    public Page<Product> findall(Product[] products, Page<Product> page) {
        String sql = "SELECT  p.*,c.category_name,pv.provider_name from products p,categorys c,providers pv  WHERE p.categroyID = c.categoryID and p.providerID =  pv.providerID order by p.productID asc limit ?,?";
        int pagesize = page.getPageSize();
        int localpage = page.getLocalPage();
        page.setCount(count());
        rs = pddaoImpl.findAll(conn,sql, (localpage - 1) * pagesize, pagesize);
        int i = 0;
        try {
            while (rs.next()) {
                products[i] = new Product();
                int productID = rs.getInt(1);
                String product_name = rs.getString(2);
                double product_price = rs.getDouble(3);
                int quantity = rs.getInt(5);
                double sales_price = rs.getDouble(6);
                String income_time = rs.getString(8);
                String category_name = rs.getString(9);
                String provider_name = rs.getString(10);

                list.add(new Product(productID, product_name, product_price, quantity, sales_price, income_time, new Category(category_name), new Provider(provider_name)));
                page.setList(list);
                i++;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return page;
    }

    @Override
    public boolean add(Product product) {
        boolean result = false;
        String sql = "insert into products (product_name,product_price,providerID,quantity,sales_price,categroyID,income_time) values(?,?,?,?,?,?,?)";
        result = pddaoImpl.add(conn,sql, product.getProduct_name(), product.getProduct_price(), product.getProviderID(), product.getQuantity(), product.getSales_price(), product.getCategroyID(), product.getIncome_time());
        bs.close();
        return result;
    }

    @Override
    public boolean checkRename(String name, int id) {
        boolean result = false;
        String sql = "select * from products where product_name=? and productID <> ?";
        rs = pddaoImpl.checkRename(conn,sql, name, id);
        try {
            result=rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return result;
    }

    @Override
    public boolean addRename(String name)  {
        boolean result = false;
        String sql = "select * from products where product_name=?";
        rs = pddaoImpl.checkRename(conn,sql, name);
        try {
            result=rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return result;
    }

    @Override
    public boolean updateduct(Product product) {
        boolean result = false;
        String sql = "update products set product_name=?,product_price=? ,providerID=?,quantity=?,sales_price=? ,categroyID=?,income_time=? where productID=?";
        result = pddaoImpl.updateduct(conn,sql, product.getProduct_name(), product.getProduct_price(),
                product.getProviderID(), product.getQuantity(), product.getSales_price(), product.getCategroyID(), product.getIncome_time(), product.getProductID());
        bs.close();
        return result;
    }

    @Override
    public boolean delectduct(String name) {
        boolean result = false;
        String sql = "delete from products where product_name = ?";
        result = pddaoImpl.delectduct(conn,sql, name);
        bs.close();
        return result;
    }

    @Override
    public int[] insertmore(Object[][] objects) {
        int []arr=null;
        String sql="insert into products (product_name,product_price,providerID,quantity,sales_price,categroyID,income_time) values(?,?,?,?,?,?,?)";
        arr=pddaoImpl.insertmore(conn,sql,objects);
        bs.close();
        return arr;
    }
}
