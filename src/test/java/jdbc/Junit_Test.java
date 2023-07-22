package jdbc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static test_utilities.Database_utilities.*;

public class Junit_Test {
    @Test
    public void test01(){
        //Laptop isimli urunun Database de kayitli oldugunu dogrula

        createConnection();
        String sql="select * from urunler";

        System.out.println("getColumnNames = " + getColumnNames(sql));

        System.out.println("getColumnData = " + getColumnData(sql, "isim"));

        assertTrue("Databasede kayit bulunamadi", getColumnData(sql, "isim")
                .contains("Laptop"));

        closeConnection();

    }

    @Test
    public void test02(){
        //102 id'li urun Database'de bulunuyor mu?
        createConnection();
        assertTrue("Aranan id Database de bulunamadi",
                getColumnData("select * from urunler" , "id").contains(102));
        closeConnection();



    }
}
