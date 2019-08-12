import Dao.BaseDao;
import Entity.Admin;
import Entity.Product;
import Instrument.CheckDelect;
import Instrument.FindId;
import Instrument.MyInput;
import Instrument.Page;
import view.AdminAction;
import view.CategoryAction;
import view.ProductAction;
import view.ProviderAction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Tset {
    public static void main(String[] args) throws SQLException {
        AdminAction adaction=new AdminAction();
        List<Admin> list=adaction.getadmin();
        for (Admin admin:list){
            System.out.println(admin);
        }
/*         CategoryAction ctaction=new CategoryAction();
        Product[] products=new Product[10];
        Page<Product> page=new Page<Product>(2,1);
        ResultSet rs;
       ProviderAction pvdaction=new ProviderAction();
        ProductAction pdtaction=new ProductAction();

        String sql="insert into admin (admin_name,admin_password,date)values(?,?,?)";
        Admin ad=new Admin();
        ad.setAdmin_name("qwe");
        ad.setAdmin_password("123");
        ad.setDate("2019-07-02 11:46:33");
        bs.add(sql,ad.getAdmin_id(),ad.getAdmin_name(),ad.getAdmin_password(),ad.getDate());

        String sql="delete from admin where admin_name=?";
        System.out.println( bs.delect(sql,"qwe"));



        String sql = "select * from admin";
        ResultSet rs = bs.search(sql);

        while (rs.next()) {
            System.out.println(rs.getInt(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            System.out.println(rs.getString(4));
        }


        Admin admin=new Admin("qwe","123");
        System.out.println(adaction.login(admin));


while (true) {
    String type= MyInput.input();
    switch (type) {
        case "1":
            page = pdtaction.findall(products, page);
            for (Object o : page.getList()) {
                System.out.println(o);
            }
            System.out.println("---------------");
            page.getList().clear();
            break;

        case "2":
            page.setLocalPage(page.nextPage());
            page = pdtaction.findall(products, page);
            for (Object o : page.getList()) {
                System.out.println(o);
            }
            System.out.println("---------------");
            page.getList().clear();
            break;

        case "3":
            page.setLocalPage(page.upPage());
            page = pdtaction.findall(products, page);
            for (Object o : page.getList()) {
                System.out.println(o);
            }
            page.getList().clear();
            break;
    }
}




       CategoryAction ata=new CategoryAction();

        String a;
        while(true) {
            a= MyInput.input();
            if (pvdaction.addRename(a)) {
                System.out.println("cdcscc");
            }else {
                break;
            }
        }
        String b= MyInput.input();
        String c= MyInput.input();
        String d= MyInput.input();
        String e= MyInput.input();

        pvdaction.addvider(new Provider(a,b,c,d,e));



        String bb=MyInput.input();
        int a= FindId.findvider(bb);
        String b;
       while (true){

           b=MyInput.input();
            if(pvdaction.checkRename(b,a)==true){
                System.out.println("asxasxa");
            }else{
                 break;
            }
       }
        String c=MyInput.input();
        String d=MyInput.input();
        String e=MyInput.input();
        String f=MyInput.input();
        pvdaction.updatevider(new Provider(a,b,c,d,e,f));



      String name=MyInput.input();
      if(CheckDelect.Checkprivuder(name)){
          System.out.println("acascacdv");
      }else {
          ProviderAction pa = new ProviderAction();
          System.out.println(pa.delectvider(name));
      }




        double a=Double.parseDouble(MyInput.input());
        System.out.println(a);*/
        /*System.out.println(Regexcheck.phone("111111111111"));*/
/*        Object[][] objects = new Object[100][2];
        objects[0][0]="asxxa";
        objects[0][1]="123131";

        objects[1][0]="dqwdwq";
        objects[1][1]="123131";


        objects[2][0]="yyp";
        objects[2][1]="1234";

        CategoryAction CategoryAction=new CategoryAction();
        CategoryAction.insertmore(objects);*/
    }

}
