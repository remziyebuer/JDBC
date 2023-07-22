package org.example;

import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.
                getConnection("jdbc:postgresql://localhost:5432/jdbc",
                        "postgres", "1299");
        Statement st = con.createStatement();

        //***** pojo class isimize cok yarar

        //Soru: urunler adinda bir tablo olusturunuz.
       String sql01 ="create table urunler (id int , isim varchar(10), fiyat int)";
       st.execute(sql01);

        // neden resulset kullanilmiyor bu soruda diye sorabilirler cun ki biz burda veri
        // gönderiyoruz eger veri alsaydik kullanirdik

        //1.adim datalari bu seklide bir kaliba koyalim

        List<Urun> kayitlar = new ArrayList<>();
        kayitlar.add(new Urun(100, "Laptop", 35000));
        kayitlar.add(new Urun(101, "Ipad", 25000));
        kayitlar.add(new Urun(102, "MacBook", 55000));
        kayitlar.add(new Urun(103, "Anakart", 15000));
        kayitlar.add(new Urun(104, "IMac", 15000));
        kayitlar.add(new Urun(105, "IPhone", 45000));



        /*

        Bu yapiyi baska hangi sekilde olusturabilirdim
        Urun[] urunler = new Urun[6];
        urunler[0] = new Urun(100, "Laptop", 35000);
        urunler[1] = new Urun(101, "Ipad", 25000);
        urunler[2] = new Urun(102, "MacBook", 55000);
        urunler[3] = new Urun(103, "Anakart", 15000);
        urunler[4] = new Urun(104, "IMac", 15000);
        urunler[5] = new Urun(105, "IPhone", 45000);

        List<Urun> kayitlar = new ArrayList<>(Arrays.asList(urunler));

        Bu örnekte, öncelikle Urun tipinde altı adet eleman içeren bir urunler dizisi
        oluşturulur.Daha sonra, her bir eleman için ayrı ayrı Ürün nesneleri oluşturulur
        ve urunler dizisine atanır.

        En son adımda, urunler dizisi Arrays.asList() yöntemi kullanılarak bir
        List<Urun> nesnesine dönüştürülür ve kayitlar adında yeni bir ArrayList 'e atanır.

        Bu yöntem, birkaç Ürün nesnesi oluşturmak yerine bir dizi oluşturarak ve daha
        sonra bu diziyi ArrayList 'e dönüştürerek biraz daha kısa bir kod yazmanızı sağlar.
     */

        //Cok miktarda data eklemek icin preparedstatement kullanmaliyiz.

        //2.adim Ps olusturma

        PreparedStatement tablo = con.
                prepareStatement("insert into urunler values (?,?,?)");

        //3.adim listeden alma pojo yardimi ile

        for (Urun each : kayitlar) {
            tablo.setInt(1, each.getId());
            tablo.setString(2,each.getIsim());
            tablo.setDouble(3, each.getFiyat());
            tablo.addBatch();//butun datalari birlestirerek gönderir bu da
            // uygulamanin performanisini artirir
        }
        //
         tablo.executeBatch();// bunu disariya yazmaliyim for ' un disina
        //pojo class ile coklu data gönderme

/*

            addBatch() yöntemi, SQL sorgularını bir diziye eklemenizi sağlar ve ardından bu
            sorguları sunucuya tek bir istek olarak göndermek için executeBatch() yöntemini
            kullanabilirsiniz.Bu, tek tek sorguları göndermek yerine, tüm sorguları tek bir
            işlemdesunucuya gönderir ve veritabanı işlemlerinin daha hızlı gerçekleşmesini
            sağlar.

                    Bu şekilde, üç sorgu tek bir işlemde sunucuya gönderilir ve veritabanı
            işlemleri daha hızlı gerçekleştirilir.

            Connection conn = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
            Statement stmt = conn.createStatement();
            stmt.addBatch("INSERT INTO employees (id, name, salary) VALUES (1, 'John', 50000)");
            stmt.addBatch("INSERT INTO employees (id, name, salary) VALUES (2, 'Jane', 60000)");
            stmt.addBatch("UPDATE employees SET salary = 55000 WHERE id = 1");
            stmt.executeBatch();

            Benim önceki örneğimde PreparedStatement kullanmama sebebim, basitliği sağlamaktı
            ve örnek açıklamamda öncelikle Statement kullanarak addBatch() yöntemini açıklamak
            istedim.Ancak gerçek hayatta, SQL sorguları için PreparedStatement kullanılması
            daha güvenlidir ve özellikle kullanıcı girdilerini içeren sorgularda önerilir.



 */
        st.close();
        tablo.close();
        con.close();


    }
}
