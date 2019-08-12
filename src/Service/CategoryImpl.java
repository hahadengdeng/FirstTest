package Service;

import Dao.BaseDao;
import Dao.CategoryDaoImpl;
import Entity.Category;
import Instrument.DBHelper;
import Instrument.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryImpl implements CategoryService {
    ResultSet rs;
    List<Category> list = new ArrayList<Category>();
    CategoryDaoImpl ctImpl = new CategoryDaoImpl();
    Connection conn= DBHelper.getConnection();
    BaseDao bs=new BaseDao();

    @Override
    public Page<Category> findall(Category[] categories, Page<Category> page)  {
        String sql = "select * from categorys  limit ?,?";
        int pagesize = page.getPageSize();
        int localpage = page.getLocalPage();
        page.setCount(count());
        rs = ctImpl.findAll(conn,sql, (localpage - 1) * pagesize, pagesize);
        int i = 0;
        while (true) {
            try {
                if (!rs.next()) break;
                categories[i] = new Category();
                int categoryID = rs.getInt(1);
                String category_name = rs.getString(2);
                String category_desc = rs.getString(3);
                list.add(new Category(categoryID, category_name, category_desc));
                page.setList(list);
                i++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        bs.close();
        return page;
    }

    @Override
    public int count()  {
        String sql = "select count(categoryID) from categorys ";
        int countnum = 0;
        rs = ctImpl.count(conn,sql);
        try {
            if (rs.next()) {
                countnum = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bs.close();
        return countnum;
    }

    @Override
    public boolean add(Category category) {
        boolean result = false;
        String sql = "insert into categorys (category_name,category_desc) values(?,?)";
        result = ctImpl.add(conn,sql, category.getCategory_name(), category.getCategory_desc());
        bs.close();
        return result;
    }

    @Override
    public boolean checkRename(String name, int id) {
        boolean result = false;
        String sql = "select * from categorys where category_name=? and categoryID <> ?";
        rs = ctImpl.checkRename(conn,sql, name, id);
        try {
            result=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return result;
    }

    @Override
    public boolean registRename(String name) {
        boolean result = false;
        String sql = "select * from categorys where category_name=?";
        rs = ctImpl.checkRename(conn,sql, name);
        try {
            result=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return result;
    }

    @Override
    public boolean update(Category category) {
        boolean result = false;
        String sql = "update categorys set category_name=?,category_desc=? where categoryID=?";
        result = ctImpl.update(conn,sql, category.getCategory_name(), category.getCategory_desc(), category.getCategoryID());
        bs.close();
        return result;
    }

    @Override
    public boolean delectcate(String name) {
        boolean result = false;
        String sql = "delete from categorys where category_name = ?";
        result = ctImpl.delectcate(conn,sql, name);
        bs.close();
        return result;
    }

    @Override
    public int[] insertmore(Object[][] objects) {
        int []arr=null;
        String sql="insert into categorys (category_name,category_desc) values(?,?)";
        arr=ctImpl.insertmore(conn,sql,objects);
        bs.close();
        return arr;
    }
}
