1.项目介绍
   典型电子商务系统（在线购物平台）。模拟了当当系统部分功能。
2.功能需求
    1）用户管理模块 user
         实现登录、注册功能
    2）产品浏览模块 main
         实现主界面和类别浏览功能
    3）购物车模块 cart
         实现购买、变更数量、删除等功能
    4）生成订单模块  order
         订单确认、填写送货地址、生成订单功能
3.技术应用
   1）技术架构
        Struts2，JDBC(连接池)，jQuery，Ajax
   2）设计思想
       MVC和分层设计思想
       a.显示层：JSP组件(jQuery,Ajax)
       b.控制层：Struts2控制器组件、Action组件
       c.业务层：Bean组件
       d.数据访问层：DAO组件(JDBC)

4.数据库设计
    1）数据库导入
         create database dangdang;      //创建库
         use dang;       //进入dangg库
         set names utf8;    //设置连接和发送SQL编码
         source 路径/dang.sql; //导入sql文件
    2）数据表功能
         a.d_user（用户信息表）
            存储了用户信息，涉及登录和注册功能
         b.d_receive_address（收货地址信息表）
            存储了收货地址信息，涉及填写送货地址功能
         c.d_category（类别信息表）
             存储了图书的类别信息，涉及主界面左侧类别菜单功能
         d.d_book（图书信息表）
             存储了图书的特有信息，涉及产品浏览等功能
         e.d_product（产品信息表）
             存储了各类型产品的共通信息字段。
         f.d_category_product（类别和产品对应关系表）
             存储了类别和产品之间包含关系，涉及产品浏览功能
         g. d_order（订单信息表）
             存储了订单信息，涉及创建订单功能
         h. d_item（订单明细表）
             存储了订单中所购买的商品信息，涉及创建订单功能。
         
5. 搭建工程结构
    1）引入需要的开发包
          struts2开发包
          jdbc开发包
          dbcp连接池开发包
    2）src文件结构
         org.dang.action  ：控制层
         org.dang.action.user ：用户模块的action
         org.dang.action.main  ：产品浏览的action
         org.dang.action.order ：订单的action
         org.dang.action.cart ：购物车的action
         org.dang.service ：业务层
         org.dang.dao ：数据访问层
         org.dang.entity ：实体类
         org.dang.util ：工具类
         org.dang.interceptor ：拦截器
    3）struts配置文件结构
         web.xml（配置Filter控制器）
         struts.xml （struts主配置文件）
         struts-user.xml（用户模块配置文件）
         struts-main.xml（浏览模块配置文件）
         struts-order.xml（订单模块配置文件）
         struts-cart.xml（购物车模块配置文件）

    4）WebRoot文件结构
         /user/* ：用户管理的JSP
         /cart/* ：购物车的JSP
         /order/* ：订单的JSP
         /main/* ：产品浏览的JSP
         /common/* ：页眉、页脚等共同JSP
         /js/*      ： 放置js脚本文件
         /css/* ：放置css样式文件
         /images/* ：放置页面图片文件
         /productImages/* ：放置产品图片




