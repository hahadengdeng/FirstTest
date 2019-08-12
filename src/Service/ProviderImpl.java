package Service;

import Dao.BaseDao;
import Dao.ProviderDaoImpl;
import Entity.Provider;
import Instrument.DBHelper;
import Instrument.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProviderImpl implements ProviderService {
    ResultSet rs;
    List<Provider> list = new ArrayList<Provider>();
    ProviderDaoImpl viderImpl = new ProviderDaoImpl();
    Connection conn= DBHelper.getConnection();
    BaseDao bs=new BaseDao();

    @Override
    public Page<Provider> findall(Provider[] providers, Page<Provider> page){
        String sql = "select * from providers  limit ?,?";
        int pagesize = page.getPageSize();
        int localpage = page.getLocalPage();
        page.setCount(count());
        rs = viderImpl.findAll(conn,sql, (localpage - 1) * pagesize, pagesize);
        int i = 0;
       try {
           while (rs.next()) {
               providers[i] = new Provider();
               int providerID = rs.getInt(1);
               String provider_name = rs.getString(2);
               String provider_add = rs.getString(3);
               String provider_tel = rs.getString(4);
               String account = rs.getString(5);
               String email = rs.getString(6);
               list.add(new Provider(providerID, provider_name, provider_add, provider_tel, account, email));
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
    public int count()  {
        String sql = "select count(providerID) from providers ";
        int countnum = 0;
        rs = viderImpl.count(conn,sql);
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
    public boolean checkRename(String name, int id) {
        boolean result=false;
        String sql = "select * from providers where provider_name=? and providerID <> ?";
        rs = viderImpl.checkRename(conn,sql, name, id);
        try {
            result=rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public boolean addRename(String name) {
        boolean result=false;
        String sql = "select * from providers where provider_name=?";
        rs = viderImpl.checkRename(conn,sql, name);
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
    public boolean add(Provider provider) {
        boolean result = false;
        String sql = "insert into providers (provider_name,provider_add,provider_tel,account,email) values(?,?,?,?,?)";
        result = viderImpl.add(conn,sql, provider.getProvider_name(), provider.getProvider_add(), provider.getProvider_tel(), provider.getAccount(), provider.getEmail());
        bs.close();
        return result;
    }

    @Override
    public boolean updatevider(Provider provider) {
        boolean result = false;
        String sql = "update providers set provider_name=?,provider_add=? ,provider_tel=?,account=?,email=? where providerID=?";
        result = viderImpl.updatevider(conn,sql, provider.getProvider_name(), provider.getProvider_add(), provider.getProvider_tel(), provider.getAccount(), provider.getEmail(), provider.getProviderID());
        bs.close();
        return result;
    }

    @Override
    public boolean delectvider(String name) {
        boolean result = false;
        String sql = "delete from providers where provider_name = ?";
        result = viderImpl.delectvider(conn,sql, name);
        bs.close();
        return result;
    }

    @Override
    public int[] insertmore(Object[][] objects) {
        int []arr=null;
        String sql="insert into providers (provider_name,provider_add,provider_tel,account,email) values(?,?,?,?,?)";
        arr=viderImpl.insertmore(conn,sql,objects);
        bs.close();
        return arr;
    }
}
