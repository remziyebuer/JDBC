package org.example;

import java.sql.*;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbc",
                        "postgres","1299");

       // Statement st = con.createStatement();
       // st.executeUpdate("insert into ogrenciler values (850, 'Ali Can', 11 , 'E')");
       // bu yapinin yerine preparedstatement kullanilir
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?,?,?,?)");
        ps.setInt(1, 900);
        ps.setString(2, "Ali Can");
        ps.setInt(3, 11);
        ps.setString(4, "E");
        ps.executeUpdate();
   //ben bu yapiyi kullanarak sana her zaman deger gönderecegim anlamindadir
        ps.close();
        con.close();

    }
}
