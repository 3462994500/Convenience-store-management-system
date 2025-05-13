package com.gec.util;


import java.sql.*;

public class JDBCUtil {

    // 定义连接对象，执行sql对象 结果集
    private static Connection conn;
    private static PreparedStatement ps;
    private static ResultSet rs;

    // 驱动 url username password
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=UTF-8";
    private static String userName = "root";
    private static String password = "123456";

    // 加载驱动
    // static {} 静态的代码块  类加载的时候就会执行这个代码
    static {
        // try{} catch{} 捕获异常
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // static 静态，在类加载的时候就加载static修饰的资源，可以通过类名.属性名 类名.方法名
    // 获取连接对象
    public static Connection getConnection()  {


        try {
            // 用静态的属性Connection接收获取到的返回值
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 返回值
        return conn;
    }


    // 查询方法 查询数据库后会返回结果集
    // Object... obj 可变参数，参数的数量是可以变化 ，可以是0个
    // 转换为数组
    // sELECT * from user where userName = ? and `password` = ?
    // query(sql , userName,password)
    public static ResultSet query(String sql,Object... obj){
        // 获取连接
        getConnection();
        // 获取ps
        try {
            ps = conn.prepareStatement(sql);
            // 处理占位符
            if(obj != null ){
                for(int i=0; i<obj.length; i++){
                    ps.setObject(i+1,obj[i]);
                }
            }
            // 执行sql 语句
            rs = ps.executeQuery();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // 返回值
        return rs;
    }


    // 更新方法（增 修 删）
    public static int update(String sql,Object... obj){
        int j = 0;
        getConnection();
        try {
            ps = conn.prepareStatement(sql);
            // 处理占位符
            if(obj != null ){
                for(int i=0; i<obj.length; i++){
                    ps.setObject(i+1,obj[i]);
                }
            }

            j = ps.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return j;

    }


    // 关闭资源
    public static void close(){
        try {
            if(rs != null)  rs.close();
            if(ps != null) ps.close();
            if(conn !=null) conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
