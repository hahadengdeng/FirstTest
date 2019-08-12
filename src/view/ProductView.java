package view;

import Entity.Product;
import Instrument.FindId;
import Instrument.MyInput;
import Instrument.Page;

public class ProductView {
    public void duct(){
        ProductAction ductaction = new ProductAction();
        while (true) {
            System.out.println("请选择相应操作:1.分页查看产品 2.增加产品 3.删除产品信息 4.修改产品信息 5.批量增加产品信息 6.返回上一层");
            String type2 = MyInput.input();
            if (type2.equals("1")) {



                Page<Product> pageduct = new Page<Product>(4, 1);
                Product[] products = new Product[100000];
                pageduct = ductaction.findall(products, pageduct);
                for (Object o : pageduct.getList()) {
                    System.out.println(o);
                }
                System.out.println("1.上一页    " + "----第" + pageduct.getLocalPage() + "页/"+pageduct.countPage()+"页----" + "    2.下一页");
                System.out.println("--------输入exit退出!--------");
                pageduct.getList().clear();
                while (true) {
                    String book = MyInput.input();
                    if (book.equals("1")) {
                        pageduct.setLocalPage(pageduct.upPage());
                        pageduct = ductaction.findall(products, pageduct);
                        for (Object o : pageduct.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pageduct.getLocalPage() + "页/"+pageduct.countPage()+"页----" + "    2.下一页");
                        System.out.println("--------输入exit退出!--------");
                        pageduct.getList().clear();
                    } else if (book.equals("2")) {
                        pageduct.setLocalPage(pageduct.nextPage());
                        pageduct = ductaction.findall(products, pageduct);
                        for (Object o : pageduct.getList()) {
                            System.out.println(o);
                        }
                        System.out.println("1.上一页    " + "----第" + pageduct.getLocalPage() + "页/"+pageduct.countPage()+"页----" + "    2.下一页");
                        System.out.println("输入exit退出!");
                        pageduct.getList().clear();
                    } else if (book.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        System.out.println("--------无效指令,请重试--------");
                    }
                }
            } else if (type2.equals("2")) {
                double product_price;
                String product_name;
                int providerID;
                int quantity;
                double sales_price;
                int categroyID;
                while (true) {
                    System.out.println("请输入产品名:");
                    product_name = MyInput.input();
                    if (!product_name.equals("")) {
                        if (ductaction.addRename(product_name)) {
                            System.out.println("产品名已存在!");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("产品名不能为空!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品价格:");
                    try {
                        product_price = Double.parseDouble(MyInput.input());
                        if (product_price>0) {
                            break;
                        }else{
                            System.out.println("无法为负数!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入供货商编号:");
                    try {
                        String input = MyInput.input();
                        providerID = Integer.parseInt(input);
                        if (FindId.ductvider(providerID)) {
                            break;
                        } else {
                            System.out.println("该供货商编号不存在 ,请重新输入:");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品重量:");
                    try {
                        quantity = Integer.parseInt(MyInput.input());
                        if (quantity>0) {
                            break;
                        }else {
                            System.out.println("无法为负数!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品销售价格:");
                    try {
                        sales_price = Double.parseDouble(MyInput.input());
                        if (sales_price>0&&sales_price>product_price) {
                            break;
                        }else {
                            System.out.println("输入为负数或者销售价格不大于进价!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品类别编号:");
                    try {
                        String input = MyInput.input();
                        categroyID = Integer.parseInt(input);
                        if (FindId.ductcate(categroyID)) {
                            break;
                        } else {
                            System.out.println("该产品类别编号不存在 ,请重新输入:");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                String income_time = MyInput.getDate();
                if (ductaction.addduct(new Product(product_name, product_price, providerID, quantity, sales_price, categroyID, income_time))) {
                    System.out.println("添加成功!");
                } else {
                    System.out.println("添加失败!");
                }
            } else if (type2.equals("3")) {
                System.out.println("请输入你要删除的产品名:");
                String product_name = MyInput.input();
                if (!ductaction.addRename(product_name)) {
                    System.out.println("该产品不存在,请重试！");
                } else {
                    if (ductaction.delectduct(product_name)) {
                        System.out.println("删除成功!");
                    } else {
                        System.out.println("删除失败！");
                    }
                }
            } else if (type2.equals("4")) {
                String cname;
                while (true) {
                    System.out.println("请输入你要修改的产品名:");
                    cname = MyInput.input();
                    if (ductaction.addRename(cname)==false){
                        System.out.println("该产品不存在!");
                    }else{
                        break;
                    }
                }

                int productID = FindId.findduct(cname);

                double product_price;
                String product_name;
                int providerID;
                int quantity;
                double sales_price;
                int categroyID;
                while (true) {
                    while (true) {
                        System.out.println("请输入产品名:");
                        product_name = MyInput.input();
                        if (product_name.equals("")){
                            System.out.println("产品名不能为空!");
                        }else {
                            break;
                        }
                    }
                    if (ductaction.checkRename(product_name, productID)) {
                        System.out.println("产品名已存在!");
                    } else {
                        break;
                    }
                }

                while (true) {
                    System.out.println("请输入产品价格:");
                    try {
                        product_price = Double.parseDouble(MyInput.input());
                        if (product_price>0) {
                            break;
                        }else{
                            System.out.println("无法为负数!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入供货商编号:");
                    try {
                        String input = MyInput.input();
                        providerID = Integer.parseInt(input);
                        if (FindId.ductvider(providerID)) {
                            break;
                        } else {
                            System.out.println("该供货商编号不存在 ,请重新输入:");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品重量:");
                    try {
                        quantity = Integer.parseInt(MyInput.input());
                        if (quantity>0) {
                            break;
                        }else {
                            System.out.println("无法为负数!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品销售价格:");
                    try {
                        sales_price = Double.parseDouble(MyInput.input());
                        if (sales_price>0&&sales_price>product_price) {
                            break;
                        }else {
                            System.out.println("输入为负数或者销售价格不大于进价!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                while (true) {
                    System.out.println("请输入产品类别编号:");
                    try {
                        String input = MyInput.input();
                        categroyID = Integer.parseInt(input);
                        if (FindId.ductcate(categroyID)) {
                            break;
                        } else {
                            System.out.println("该产品类别编号不存在 ,请重新输入:");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("请输入正确的数据类型!");
                    }
                }

                String income_time = MyInput.getDate();

                if (ductaction.updateduct(new Product(productID, product_name, product_price, providerID, quantity, sales_price, categroyID, income_time))) {
                    System.out.println("修改成功!");
                } else {
                    System.out.println("无此产品,修改失败！");
                }
            } else if (type2.equals("5")) {
                System.out.println("批量插入产品开始:");
                int result[];
                Object[][] arr = new Object[100][7];
                double product_price;
                String product_name;
                int providerID;
                int quantity;
                double sales_price;
                int categroyID;
                int i = 0;
                while (true) {
                    int j = 0;
                    while (true) {
                        System.out.println("请输入产品名:");
                        product_name = MyInput.input();
                        if (!product_name.equals("")) {
                            if (ductaction.addRename(product_name)) {
                                System.out.println("产品名已存在!");
                            } else {
                                break;
                            }
                        } else {
                            System.out.println("产品名不能为空!");
                        }
                    }
                    arr[i][j] = product_name;
                    j++;
                    while (true) {
                        System.out.println("请输入产品价格:");
                        try {
                            product_price = Double.parseDouble(MyInput.input());
                            if (product_price>0) {
                                break;
                            }else {
                                System.out.println("无法为负数!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数据类型!");
                        }
                    }
                    arr[i][j] = product_price;
                    j++;
                    while (true) {
                        System.out.println("请输入供货商编号:");
                        try {
                            String input = MyInput.input();
                            providerID = Integer.parseInt(input);
                            if (FindId.ductvider(providerID)) {
                                break;
                            } else {
                                System.out.println("该供货商编号不存在 ,请重新输入:");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数据类型!");
                        }
                    }
                    arr[i][j] = providerID;
                    j++;
                    while (true) {
                        System.out.println("请输入产品重量:");
                        try {
                            quantity = Integer.parseInt(MyInput.input());
                            if (quantity>0) {
                                break;
                            }else{
                                System.out.println("无法为负数!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数据类型!");
                        }
                    }
                    arr[i][j] = quantity;
                    j++;
                    while (true) {
                        System.out.println("请输入产品销售价格:");
                        try {
                            sales_price = Double.parseDouble(MyInput.input());
                            if (sales_price>0&&sales_price>product_price) {
                                break;
                            }else{
                                System.out.println("输入为负数或者销售价格不大于进价!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数据类型!");
                        }
                    }
                    arr[i][j] = sales_price;
                    j++;
                    while (true) {
                        System.out.println("请输入产品类别编号:");
                        try {
                            String input = MyInput.input();
                            categroyID = Integer.parseInt(input);
                            if (FindId.ductcate(categroyID)) {
                                break;
                            } else {
                                System.out.println("该产品类别编号不存在 ,请重新输入:");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("请输入正确的数据类型!");
                        }
                    }
                    arr[i][j] = categroyID;
                    j++;
                    String income_time = MyInput.getDate();
                    arr[i][j] = income_time;
                    System.out.println("-------------");
                    System.out.println("输入exit停止输入,输入其他继续:");
                    if ("exit".equalsIgnoreCase(MyInput.input())) {
                        break;
                    }
                    i++;
                }
                try {
                    result = ductaction.insertmore(arr);
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
