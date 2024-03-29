package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day24_DataProviderTest1 {

    /*
DataProvider Nedir?
    ***Veri deposudur. Bir cok veriyi Test Case'lere loop kullanmadan aktarmak icin kullanilir.***
    ***Data provider 2D(2 boyutlu) Object return eder.***
    ***Data provider TestNG'den gelen bir ozelliktir.***

Data Provider ne icin kullanilir?
    ***Data provider DDT(Data Driven Testing) icin kullanilir.Birden fazla data'yi test case'lerde kullanmak icin kullanilir.***

Data Provider'i nasil kullaniriz?
    ***@DataProvider annotation'i ile veri havuzu olusturulur.***
    ***@Test method'larina bu data havuzu dataProvider parametresiyle baglanir.***
    Data provider'da 2 tane parametre vardir:
    ***name : Method ismini override etmek icin, yani farkli bir isim ile data provider'i cagirmak icin kullanilir.
    ***parallel : parallel test case'ler olusturmak icin kullanilir.
 */


    // DATA PROVIDER
    @DataProvider (name = "smoke_test_data")
    public  Object[][] urunler(){
        Object urunListesi[][] = {
                {"tesla"},
                {"bmv"},
                {"mercedes"},
                {"honda"},
                {"toyoto"},
                {"volvo"}
        };
        return urunListesi;
    }

    //TEST METHODU
    @Test(dataProvider = "smoke_test_data")
    public void aramaTesti(String data){
        System.out.println(data);

    }

    //GOOGLE ARAMASI
    @Test(dataProvider = "smoke_test_data")
    public  void googleAraması(String araclar){
        Driver.getDriver().get("https://www.google.com");

        //COOKIES CIKANLAR ICIN
//        try {
//            Driver.getDriver().findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
//        }catch (Exception e){
//
//        }

        //aracları arama kutusuna gir ve ENTER a bas.
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);
        //sayfa title inin aradıgım kelimeyi icerdiğini assert et.
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
        Driver.closeDriver();
    }
}
