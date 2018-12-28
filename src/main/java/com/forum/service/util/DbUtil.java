package com.forum.service.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DbUtil {

    public static Connection getConnection() {
        Connection con = null;
        try{
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/forum-step");
            con = ds.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }




    public static void closeAll(AutoCloseable... closeables) {
        for (AutoCloseable c : closeables) {
            if (c != null) {
                try {
                    c.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}