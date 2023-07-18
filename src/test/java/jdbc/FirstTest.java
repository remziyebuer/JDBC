package jdbc;

import org.junit.Assert;
import org.junit.Test;

public class FirstTest {
    //target dosyalari run edilmis classlari gösterir silebilirsin sorun olmaz
   // mainde test yapilmaz

    @Test
    public void firstTest01(){

        Assert.assertTrue( 6<9);
        //dogrulama yapacagimiz icin bunu cok kullanacagiz
    }

@Test
    public void firstTest02(){
      Assert.assertTrue("Test Fail", 7<9);
      //test kaldiginda bu mesaji aliriz kalmazsa almayiz

   //Bu klassta iki tane test var bu klassin yapisini bize
    // verecekleri usercase belirler.
//
//    @Test
//    public void test03(){
//        Assert.assertEquals("Sayilar esit degil", "3","3");
//    }
//
//    // asail isimiz beklenen deger ile gercek degeri karsilastirmak olackatir
//

}

}
