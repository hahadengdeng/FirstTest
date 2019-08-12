package view;

import Entity.Category;
import Instrument.CheckDelect;
import Instrument.FindId;
import Instrument.MyInput;
import Instrument.Page;
import jdk.internal.util.xml.impl.Input;

public class CategoryView {
    CategoryAction cateaction = new CategoryAction();
    public void cate(){
        while (true) {
            System.out.println("请选择相应操作:1.分页查看类别 2.增加类别 3.删除类别 4.修改已有类别信息 5.批量增加类别 6.返回上一层");
            String type2 = MyInput.input();
            if (type2.equals("1")) {

                Page<Category> pagegory = new Page<Category>(4, 1);
                Category[] categorys = new Category[100000];
                pagegory = cateaction.findall(categorys, pagegory);
                for (Object o : pagegory.getList()) {
                    System.out.println(o);
                }
                System.out.println("1.上一页    " + "----第" + pagegory.getLocalPage() + "页/"+pagegory.countPage()+"页----" + "    2.下一页");
                System.out.println("--------输入exit退出!--------");
                pagegory.getList().clear();
                while (true) {
                    String book = MyInput.input();
                    if (book.equals("1")) {
                        pagegory.setLocalPage(pagegory.upPage());
                        pagegory = cateaction.findall(categorys, pagegory);
                        for (Object o : pagegory.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pagegory.getLocalPage() + "页/"+pagegory.countPage()+"页----" + "    2.下一页");
                        System.out.println("--------输入exit退出!--------");
                        pagegory.getList().clear();
                    } else if (book.equals("2")) {
                        pagegory.setLocalPage(pagegory.nextPage());
                        pagegory = cateaction.findall(categorys, pagegory);
                        for (Object o : pagegory.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pagegory.getLocalPage() + "页/"+pagegory.countPage()+"页----" + "    2.下一页");
                        System.out.println("输入exit退出!");
                        pagegory.getList().clear();
                    } else if (book.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        System.out.println("--------无效指令,请重试--------");
                    }
                }
            } else if (type2.equals("2")) {
                System.out.println("请添加字段:");
                String cate_name;
                while (true) {
                    System.out.println("请输入产品类别名:");
                    cate_name = MyInput.input();
                    if (!cate_name.equals("")) {
                        if (cateaction.registRename(cate_name)) {
                            System.out.println("产品名已存在,请重试");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("类别名不能为空:");
                    }
                }
                System.out.println("请输入产品介绍:");
                String cate_desc = MyInput.input();
                cateaction.add(new Category(cate_name, cate_desc));
                System.out.println("添加成功!");
            } else if (type2.equals("3")) {
                System.out.println("请输入你要删除的名称:");
                String dename = MyInput.input();
                if (!cateaction.registRename(dename)) {
                    System.out.println("你要删除的产品类别不存在,请重试！");
                } else {
                    if (CheckDelect.Checkcategorys(dename)) {
                        System.out.println("此产品种类还有库存,无法删除！");
                    } else {
                        cateaction.delectcate(dename);
                        System.out.println("删除成功!");
                    }
                }
            } else if (type2.equals("4")) {
                String caname;
                while (true) {
                    System.out.println("请输入修改的目录名:");
                    caname = MyInput.input();
                    if (cateaction.registRename(caname)==false){
                        System.out.println("要修改的产品不存在");
                    }else {
                        break;
                    }
                }
                String rcname;
                int id = FindId.findcate(caname);
                while (true) {
                    while (true) {
                        System.out.println("请输入修改后的名称:");
                        rcname = MyInput.input();
                        if (rcname.equals("")){
                            System.out.println("产品名不能为空!");
                        }else{
                            break;
                        }
                    }
                    if (cateaction.checkRename(rcname, id)) {
                        System.out.println("此产品已存在,请重新输入:");
                    } else {
                        System.out.println("请输入产品介绍:");
                        String sec = MyInput.input();
                        if (cateaction.update(new Category(id, rcname, sec))) {
                            System.out.println("修改成功!");
                        } else {
                            System.out.println("无此类别,修改失败!");
                        }
                        break;
                    }
                }
            } else if (type2.equals("5")) {
                System.out.println("批量增加开始:");
                String cate_name;
                int i = 0;
                int result[];
                Object[][] arr = new Object[100][2];
                while (true) {
                    int j = 0;
                    while (true) {
                        System.out.println("请输入产品类别名:");
                        cate_name = MyInput.input();
                        if (!cate_name.equals("")) {
                            if (cateaction.registRename(cate_name)) {
                                System.out.println("产品名已存在,请重试");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("产品类别不能为空!");
                        }
                    }
                    arr[i][j] = cate_name;
                    j++;
                    System.out.println("请输入产品介绍:");
                    String cate_desc = MyInput.input();
                    arr[i][j] = cate_desc;
                    System.out.println("-------------");
                    System.out.println("输入exit停止输入,输入其他继续:");
                    if ("exit".equalsIgnoreCase(MyInput.input())) {
                        break;
                    }
                    i++;
                }
                try {
                    result = cateaction.insertmore(arr);
                    System.out.println("添加" + result.length + "种产品类别成功!");
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
