package Test_01;

import Utilities.staticDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

import java.util.List;
import java.awt.*;
import java.awt.event.KeyEvent;

public class shoppingTest_01 extends staticDriver {
    public static void main(String[] args) throws AWTException {
        driver.get("https://www.a101.com.tr/");

        System.out.println("Test başladı!");

        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyRelease(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement buttonKabulEt = driver.findElement(By.xpath("//button[text()='Kabul Et']"));
        buttonKabulEt.click();

        WebElement a101Logo = driver.findElement(By.cssSelector("a[title='A101'][class='logo']"));
        a101Logo.click(); //Ana sayfa iki farklı title yapısıyla açıldığı için eklendi

        WebElement giyimAndAksesuar = driver.findElement(By.xpath("(//li[@class='js-navigation-item '])[4]"));
        giyimAndAksesuar.click();

        WebElement kadinIcGiyim = driver.findElement(By.xpath("//li[@class='derin ']//a[contains(text(),'Kadın İç Giyim')]"));
        kadinIcGiyim.click();

        wait.until(ExpectedConditions.stalenessOf(kadinIcGiyim));

        WebElement dizAltiCorap = driver.findElement(By.xpath("(//li[starts-with(@class,'derin')])[2]"));
        dizAltiCorap.click();   //Bu adımda locater doğru alındığı halde bir atlama olabiliyor. Kontrol edilmeli


        wait.until(ExpectedConditions.stalenessOf(dizAltiCorap));

        List<WebElement> corapList = driver.findElements(By.cssSelector("h3[class='name']"));
        for (WebElement corap : corapList) {
            if (corap.getText().toLowerCase().contains("siyah") && corap.getText().toLowerCase().contains("çora")) {
                corap.click();
                break;
            }

        }

        WebElement siyahControl = driver.findElement(By.xpath("//span[text()='SİYAH']"));
        if (siyahControl.getText().equalsIgnoreCase("siyah")) {
            System.out.println("Siyah çorap seçildi.");
        } else {
            System.out.println("Seçilen çorap siyah değil. Seçiminizi kontrol edin!");
        }

        WebElement sepetButton = driver.findElement(By.cssSelector("button[class^='add']"));
        sepetButton.click();

        WebElement sepGorButton = driver.findElement(By.xpath("(//a[text()='Sepeti Görüntüle'])[2]"));
        sepGorButton.click();

        WebElement sepOnayButton = driver.findElement(By.cssSelector("div[class^='total']+a[title='Sepeti Onayla']"));
        sepOnayButton.click();

        WebElement uyeOlmadanDevButton = driver.findElement(By.cssSelector("a[title='ÜYE OLMADAN DEVAM ET']"));
        uyeOlmadanDevButton.click();

        WebElement emailInput = driver.findElement(By.name("user_email"));
        emailInput.sendKeys("fixtests@gmail.com");

        WebElement devamEtButton = driver.findElement(By.xpath("//button[contains(text(),'DEVAM ET')]"));
        devamEtButton.click();

        WebElement adresOlusturButton = driver.findElement(By.xpath("(//a[@title='Yeni adres oluştur'])[1]"));
        adresOlusturButton.click();

        WebElement titleInput = driver.findElement(By.name("title"));
        titleInput.sendKeys("Test Adresim");

        String alf = "ABCÇDEFGĞHİIJKLMNOÖPRSŞTUÜVYZabcçdefgğhiıjklmnoöprsştuüvyz";
        int ek = (int) (Math.random() * 59);
        int ek2 = (int) (Math.random() * 59);
        char alfCh1 = alf.charAt(ek);
        char alfCh2 = alf.charAt(ek2);
        String eklemestr = "İbrahim" + alfCh1 + alfCh2;
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys(eklemestr);

        WebElement lastNameInput = driver.findElement(By.name("last_name"));
        lastNameInput.sendKeys("Figen");

        WebElement phoneNumberInput = driver.findElement(By.name("phone_number"));
        phoneNumberInput.sendKeys("5010010101");

        WebElement cities = driver.findElement(By.name("city"));
        Select selectCity = new Select(cities);
        selectCity.selectByVisibleText("ADANA");

        WebElement townships = driver.findElement(By.name("township"));
        Select selectTownship = new Select(townships);
        selectTownship.selectByVisibleText("SEYHAN");

        WebElement optionWait = driver.findElement(By.xpath("(//select[@name='district']//option)[1]"));

        wait.until(ExpectedConditions.stalenessOf(optionWait));

        WebElement districts = driver.findElement(By.name("district"));
        Select selectDistrict = new Select(districts);
        selectDistrict.selectByVisibleText("BARIŞ MAH");

        WebElement adresText = driver.findElement(By.name("line"));
        adresText.sendKeys("Türkiye Cumhuriyeti");

        WebElement kaydetButton = driver.findElement(By.xpath("//button[contains(text(),'KAYDET')]"));
        kaydetButton.click();

        WebElement kargoRadioButton = driver.findElement(By.cssSelector("input[name='shipping']+div+span"));
        kargoRadioButton.click();

        WebElement kaydetDevamEt = driver.findElement(By.xpath("//button[contains(text(),'Kaydet ve Devam Et')]"));
        kaydetDevamEt.click();

        WebElement adSoyadInput = driver.findElement(By.xpath("(//input[@name='name'])[2]"));
        adSoyadInput.sendKeys("İbrahim Figen");

        WebElement kartNoInput = driver.findElement(By.xpath("(//input[@type='tel'])[3]"));
        kartNoInput.sendKeys("0000 0000 0000 0000");

        WebElement cartMonths = driver.findElement(By.cssSelector("select[name='card_month'][autocomplete]"));
        Select selectCartMonth = new Select(cartMonths);
        selectCartMonth.selectByIndex(4);

        WebElement cartYears = driver.findElement(By.cssSelector("select[name='card_year'][autocomplete]"));
        Select selectCartYear = new Select(cartYears);
        selectCartYear.selectByIndex(4);

        WebElement cvcInput = driver.findElement(By.xpath("(//input[@name='card_cvv'])[2]"));
        cvcInput.sendKeys("000");

        WebElement odemeAssert = driver.findElement(By.xpath("//div[contains(text(),'Masterpass ile Ödeme')]"));
        Assert.assertTrue(odemeAssert.getText().contains("Masterpass ile Ödeme")); //Sayfa doğrulama bu kısımda gerçekleşiyor

        System.out.println("Test sona erdi!");

        //Not: Yoğun bir dönemime denk geldiği için detaylara inemedim.
        // TestNG ve Cucumber ile de yapmayı düşünüyordum.
        // Yarışmacı arkadaşlara başarılar :)


    }
}

