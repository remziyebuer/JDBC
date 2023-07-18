package org.example;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbc",
                        "postgres","1299");
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();

        System.out.println("Sütun Sayisi; " + rsmd.getColumnCount());//Sütun Sayisi; 4

        System.out.println("1. sutunun ismi: " + rsmd.getColumnName(1));//1. sutunun ismi: okul_no
        System.out.println("2. sutunun ismi: " + rsmd.getColumnName(2));//2. sutunun ismi: ogrenci_ismi
        System.out.println("3. sutunun ismi: " + rsmd.getColumnName(3));//3. sutunun ismi: sinif
        System.out.println("4. sutunun ismi: " + rsmd.getColumnName(4));//4. sutunun ismi: cinsiyet

        System.out.println("Tablo ismi: " + rsmd.getTableName(3));//Tablo ismi: ogrenciler

        System.out.println(rsmd.getColumnTypeName(1));//int4//bunlar yeterli

        st.close();
        con.close();


    }
}
