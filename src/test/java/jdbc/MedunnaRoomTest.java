package jdbc;

import org.junit.Assert;
import org.junit.Test;
import test_utilities.Jdbc_utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static test_utilities.Jdbc_utilities.closeConnection;
import static test_utilities.Jdbc_utilities.connectToMedunnaDataBase;

public class MedunnaRoomTest {
    @Test
    public void roomtest() throws SQLException {

//john_doe isimli kullanici tarafindan oda olusturuldu mu?
        connectToMedunnaDataBase();
        Statement statement= Jdbc_utilities.createStatement();
        String sql01 = "select created_by from room";
        ResultSet resulSet = statement.executeQuery(sql01);
        List<String> created_byList= new ArrayList<>();
        while(resulSet.next()){
            //tek  tek listeye atiyoruz.
            created_byList.add(resulSet.getString(1));
            //test asamasina gecmem icin consol görüntünü listeye almaliyim yoksa yapamam.
        }
       // System.out.println("created_byList = " + created_byList);
        Assert.assertTrue("Database de kayit bulunamadi",created_byList.contains("john_doe"));

        closeConnection();

    }
}
