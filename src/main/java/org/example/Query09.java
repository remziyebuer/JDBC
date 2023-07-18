package org.example;

import static utilities.DatabaseUtilty.*;

public class Query09 {
    public static void main(String[] args) {

        /*
         Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbc",
                        "postgres", "1299");
                        bu kod sadece createConnection yzarak hallederiz
         */

        createConnection();

        String sql01 = "select *  from  ogrenciler ";
        System.out.println("Sütun Isimleri: "+getColumnNames(sql01));

        System.out.println(getColumnData(sql01, "okul_no"));
        System.out.println(getColumnData(sql01, "ogrenci_ismi"));
        System.out.println(getColumnData(sql01, "sinif"));
        System.out.println(getColumnData(sql01, "cinsiyet"));


        closeConnection();

    }
}
