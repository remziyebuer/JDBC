package jdbc;

import org.testng.Assert;
import org.testng.annotations.Test;


import static utilities.Database_utilities.*;

public class TestNG_Test {

    @Test
    public void test01(){
        //doktorlar Database'inde "Psikoloji" bolumu var mi?
        createConnection();
        String sql = "select * from doktorlar";
        Assert.assertTrue(getColumnData(sql,"bolum").contains("Psikoloji"),"Database de kayit bulunamadi");

        closeConnection();
    }

    @Test
    public void test02(){
        createConnection();
        String sql = "select * from doktorlar";
        Assert.assertTrue(getColumnData(sql,"id").contains(25), "Database de kayit bulunamadi");
        closeConnection();

    }


}
