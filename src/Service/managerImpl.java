package Service;

import Dao.AdminDaoImpl;
import Dao.BaseDao;
import Entity.Admin;
import Instrument.DBHelper;
import Instrument.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class managerImpl implements MangerService {
    AdminDaoImpl adImpl = new AdminDaoImpl();
    ResultSet rs;
    List<Admin> list = new ArrayList<Admin>();
    Connection conn= DBHelper.getConnection();
    BaseDao bs=new BaseDao();
    @Override
    public boolean login(Admin admin) {
        boolean x = false;
        String sql = "select * from admin where admin_name=? and admin_password=?";
        rs = adImpl.login(conn,sql, admin.getAdmin_name(), admin.getAdmin_password());
        try {
            if (rs.next()) {
                x = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return x;
    }

    @Override
    public Page<Admin> findall(Admin[] admins, Page<Admin> page) {//----------------------------------
        String sql = "select * from admin  limit ?,?";
        int pagesize = page.getPageSize();
        int localpage = page.getLocalPage();
        page.setCount(count());
        rs = adImpl.findAll(conn,sql, (localpage - 1) * pagesize, pagesize);
        int i = 0;
        try {
            while (rs.next()) {
                admins[i] = new Admin();
                int Admin_id = rs.getInt(1);
                String Admin_name = (rs.getString(2));
                String Admin_password = (rs.getString(3));
                String date = (rs.getString(4));
                list.add(new Admin(Admin_id, Admin_name, Admin_password, date));
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
    public int count() {//-----------------------------------------------
        String sql = "select count(admin_id) from admin ";
        int countnum = 0;
        rs = adImpl.count(conn,sql);
       try {
           if (rs.next()) {
               countnum = rs.getInt(1);
           }
       }catch (SQLException e){
           e.printStackTrace();
       }finally {
           bs.close();
       }
        return countnum;
    }

    @Override
    public boolean checkRename(Admin admin){
       boolean x=false;
        String sql = "select * from admin where admin_name=?";
        rs = adImpl.checkRename(conn,sql, admin.getAdmin_name());
        try {
            x=rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        bs.close();
        return x;
    }

    @Override
    public boolean resigst(Admin admin) {
        String sql = "insert into admin (admin_name,admin_password,date) values(?,?,?)";
        boolean result = adImpl.resigst(conn,sql, admin.getAdmin_name(), admin.getAdmin_password(), admin.getDate());
        bs.close();
        return result = true;
    }

    @Override
    public List<Admin> getadmin() {
        String sql="select * from admin";
        rs=adImpl.findcount(conn,sql,null);
        int id=0;
        String name=null;
        String password=null;
        String date=null;

        try {
            while (rs.next()){
                id=rs.getInt(1);
                name=rs.getString(2);
                password=rs.getString(3);
                date=rs.getString(4);
                list.add(new Admin(id,name,password,date));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            bs.close();
        }
        return list;
    }
}
