package view;

import Entity.Provider;
import Instrument.*;

public class ProviderView {
    ProviderAction videraction = new ProviderAction();
    public void vider(){
        while (true) {
            System.out.println("请选择相应操作:1.分页查看供货信息 2.增加供货信息 3.删除供货信息 4.修改供货信息 5.批量增加供货信息 6.返回上一层");
            String type2 = MyInput.input();
            if (type2.equals("1")) {




                Page<Provider> pagevider = new Page<Provider>(4, 1);
                Provider[] providers = new Provider[100000];
                pagevider = videraction.findall(providers, pagevider);
                for (Object o : pagevider.getList()) {
                    System.out.println(o);
                }
                System.out.println("1.上一页    " + "----第" + pagevider.getLocalPage() + "页/"+pagevider.countPage()+"页----" + "    2.下一页");
                System.out.println("--------输入exit退出!--------");
                pagevider.getList().clear();
                while (true) {
                    String book = MyInput.input();
                    if (book.equals("1")) {
                        pagevider.setLocalPage(pagevider.upPage());
                        pagevider = videraction.findall(providers, pagevider);
                        for (Object o : pagevider.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pagevider.getLocalPage() + "页/"+pagevider.countPage()+"页----" + "    2.下一页");
                        System.out.println("--------输入exit退出!--------");
                        pagevider.getList().clear();
                    } else if (book.equals("2")) {
                        pagevider.setLocalPage(pagevider.nextPage());
                        pagevider = videraction.findall(providers, pagevider);
                        for (Object o : pagevider.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pagevider.getLocalPage() + "页/"+pagevider.countPage()+"页----" + "    2.下一页");
                        System.out.println("输入exit退出!");
                        pagevider.getList().clear();
                    } else if (book.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        System.out.println("--------无效指令,请重试--------");
                    }
                }
            } else if (type2.equals("2")) {
                System.out.println("请添加供货信息:");
                String provider_name;
                String provider_tel;
                String email;
                while (true) {
                    System.out.println("请输入供应商名:");
                    provider_name = MyInput.input();
                    if (!provider_name.equals("")) {
                        if (videraction.addRename(provider_name)) {
                            System.out.println("此供货商名已存在，请重新输入:");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("供货商名不能为空!");
                    }
                }
                System.out.println("请输入供货商地址");
                String provider_add = MyInput.input();
                while (true) {
                    System.out.println("请输入供货商电话:");
                    provider_tel = MyInput.input();
                    if (Regexcheck.phone(provider_tel) == false) {
                        System.out.println("电话格式不正确,请重新输入:");
                    } else {
                        break;
                    }
                }
                System.out.println("请输入供货商账户:");
                String account = MyInput.input();
                while (true) {
                    System.out.println("请输入电子邮箱:");
                    email = MyInput.input();
                    if (Regexcheck.email(email) == false) {
                        System.out.println("电子邮箱格式错误,请重新输入:");
                    } else {
                        break;
                    }
                }
                if (videraction.addvider(new Provider(provider_name, provider_add, provider_tel, account, email))) {
                    System.out.println("增加成功!");
                }
            } else if (type2.equals("3")) {
                System.out.println("请输入要删除的名字:");
                String provider_name = MyInput.input();
                if (!videraction.addRename(provider_name)) {
                    System.out.println("你要删除的供货商不存在，请重试!");
                } else {
                    if (CheckDelect.Checkprivuder(provider_name)) {
                        System.out.println("此产品已存在,请重新输入:");
                    } else {
                        if (videraction.delectvider(provider_name)) {
                            System.out.println("删除成功!");
                        } else {
                            System.out.println("删除失败!");
                        }
                    }
                }
            } else if (type2.equals("4")) {
                String cname;
                while (true) {
                    System.out.println("请输入你要修改的供货商名称:");
                    cname = MyInput.input();
                    if (videraction.addRename(cname)==false){
                        System.out.println("该供应商不存在!");
                    }else{
                        break;
                    }
                }
                int id = FindId.findvider(cname);
                String rcname;
                String provider_tel;
                String email;
                while (true) {
                    while (true) {
                        System.out.println("请输入修改后的名称:");
                        rcname = MyInput.input();
                        if (rcname.equals("")){
                            System.out.println("名称不能为空!");
                        }else{
                            break;
                        }
                    }
                    if (videraction.checkRename(rcname, id)) {
                        System.out.println("名称已存在请重试!");
                    } else {
                        break;
                    }
                }
                System.out.println("请输入供货商地址");
                String provider_add = MyInput.input();
                while (true) {
                    System.out.println("请输入供货商电话:");
                    provider_tel = MyInput.input();
                    if (!Regexcheck.phone(provider_tel)) {
                        System.out.println("电话格式不正确,请重新输入:");
                    } else {
                        break;
                    }
                }
                System.out.println("请输入供货商账户:");
                String account = MyInput.input();
                while (true) {
                    System.out.println("请输入电子邮箱:");
                    email = MyInput.input();
                    if (!Regexcheck.email(email)) {
                        System.out.println("电子邮箱格式错误,请重新输入:");
                    } else {
                        break;
                    }
                }
                if (videraction.updatevider(new Provider(id, rcname, provider_add, provider_tel, account, email))) {
                    System.out.println("修改成功!");
                } else {
                    System.out.println("无此供应商,修改失败!");
                }
            } else if (type2.equals("5")) {


                System.out.println("批量添加供货信息开始:");
                String provider_name;
                String provider_tel;
                String email;
                int result[];
                Object[][] arr = new Object[100][5];
                int i = 0;
                while (true) {
                    int j = 0;
                    while (true) {
                        System.out.println("请输入供货商名:");
                        provider_name = MyInput.input();
                        if (!provider_name.equals("")) {
                            if (videraction.addRename(provider_name)) {
                                System.out.println("此供货商名已存在，请重新输入:");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("供货商名不能为空!");
                        }
                    }
                    arr[i][j] = provider_name;
                    j++;
                    System.out.println("请输入供货商地址");
                    String provider_add = MyInput.input();
                    arr[i][j] = provider_add;
                    j++;
                    while (true) {
                        System.out.println("请输入供货商电话:");
                        provider_tel = MyInput.input();
                        if (Regexcheck.phone(provider_tel) == false) {
                            System.out.println("电话格式不正确,请重新输入:");
                        } else {
                            break;
                        }
                    }
                    arr[i][j] = provider_tel;
                    j++;
                    System.out.println("请输入供货商账户:");
                    String account = MyInput.input();
                    arr[i][j] = provider_tel;
                    j++;
                    while (true) {
                        System.out.println("请输入电子邮箱:");
                        email = MyInput.input();
                        if (Regexcheck.email(email) == false) {
                            System.out.println("电子邮箱格式错误,请重新输入:");
                        } else {
                            break;
                        }
                    }
                    arr[i][j] = email;
                    System.out.println("-------------");
                    System.out.println("输入exit停止输入,输入其他继续:");
                    if ("exit".equalsIgnoreCase(MyInput.input())) {
                        break;
                    }
                    i++;
                }
                try {
                    result = videraction.insertmore(arr);
                    System.out.println("添加" + result.length + "条供货商信息成功!");
                } catch (NullPointerException e) {
                    System.out.println("正在回滚数据......");
                }
            } else if (type2.equals("6")) {
                break;
            } else {
                System.out.println("无效指令,请重试");
            }
        }
    }
}
