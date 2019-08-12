import view.*;
import Entity.Admin;
import Instrument.*;
import java.util.List;

public class Manager {
    public static void main(String[] args) {
        AdminAction aaon = new AdminAction();
        Admin admin;
        try {
            System.out.println("欢迎使用电商管理系统");
            while (true) {
                System.out.println("请选择你需要的服务:1.登录 2.注册 3.退出");
                String type = MyInput.input();
                if (type.equals("1")) {
                    System.out.println("请输入用户名:");
                    String name = MyInput.input();
                    System.out.println("请输入密码:");
                    String password = MyInput.input();
                    admin = new Admin(name, password);
                    if (aaon.login(admin)) {
                        System.out.println("登陆成功!");
                        label:
                        while (true) {
                            System.out.println("请选择管理内容:1.产品类别管理 2.供应商管理 3.产品管理 4.查看所有管理员 5.返回上一层");
                            String type1 = MyInput.input();
                            switch (type1) {
                                case "1":
                                    CategoryView categoryView = new CategoryView();
                                    categoryView.cate();
                                    break;
                                case "2":
                                    ProviderView vider = new ProviderView();
                                    vider.vider();
                                    break;
                                case "3":
                                    ProductView productView = new ProductView();
                                    productView.duct();
                                    break;
                                case "4":
                                    List<Admin> list = aaon.getadmin();
                                    for (Admin admin1 : list) {
                                        System.out.println(admin1);
                                    }
                                    break;
                                case "5":
                                    break label;
                                default:
                                    System.out.println("无效指令,请重试");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败,请重试!");
                    }
                } else if (type.equals("2")) {
                    String name = null;
                    String password = null;
                    System.out.println("请输入您要注册的账号密码:");

                    while (true) {
                        System.out.println("请输入你要创建的用户名:");
                        name = MyInput.input();
                        if (name.equals("")) {
                            System.out.println("用户名不能为空!");
                        } else {
                            break;
                        }
                    }
                    while (true) {
                        System.out.println("请输入登陆密码:");
                        password = MyInput.input();
                        if (password.equals("")) {
                            System.out.println("密码不能为空!");
                        } else {
                            break;
                        }
                    }
                    admin = new Admin(name, password, MyInput.getDate());

                    if (aaon.checkRename(admin)) {
                        System.out.println("用户名已存在，请重试!");
                    } else {
                        if (aaon.resigst(admin)) {
                            System.out.println("注册成功，请登录!");
                        } else {
                            System.out.println("注册失败!");
                        }
                    }
                } else if (type.equals("3")) {
                    break;
                } else {
                    System.out.println("无效指令,请重试");
                }
            }
        } catch (Exception e) {
            System.out.println("预料之外的错误！");
        }
    }
}