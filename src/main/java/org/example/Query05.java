package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbc",
                        "postgres","1299");
        Statement st = con.createStatement();

         //veri ekleme kaldi

//        //Soru 1 ; Ögrenciler tablosuna yeni bir kayit ekleyin(300, 'Sena Can', 12, K)
//        String sql01 = "insert into ogrenciler values(300 ,'Sena Can', 12, 'K')";
//        st.executeUpdate(sql01);// int deger döner kac satir ekledigini söyler.
//        String sql02="insert into ogrenciler values (302, 'Havva Can', 12, 'K')";
//        int s1 = st.executeUpdate(sql02);
//        System.out.println(s1 + " tane satir database'e eklendi");

//       // SORU 2: Öğrenciler tablosuna birden fazla veri ekleyin
//         (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

         String [] cokluVeriGirisi = {"insert into ogrenciler values (600, 'Sena Can', 12, 'K')",
                                      "insert into ogrenciler values (601, 'Sena Can', 12, 'K')",
                                       "insert into ogrenciler values(602, 'Sena Can', 12, 'K')"};

//      //1.yol
//         int count = 0 ;
//         for (String each : cokluVeriGirisi){
//             st.executeUpdate(each);   // ya da count = count + st.executeUpdate(each);
//                                      // yazarakta kac satir eklend. buluruz
//             count++;
//         }
//        System.out.println(count + " satir eklendi");

         //2.yol
        for(String each : cokluVeriGirisi){
            st.addBatch(each);// yukarda ki datalarin hepsini birlestiriyor
        }
               st.executeBatch();//Datalari tek seferde gönderiyor

        st.close();
        con.close();
    }
}
