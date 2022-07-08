package pages;

import driver.BaseTest;
import methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    Methods methods;
    WebDriver driver;
    Logger logger = LogManager.getLogger(ProductPage.class);


    public ProductPage(){
        methods=new Methods();
        driver= BaseTest.driver;
    }

    public void mainPageControl(){
        String title= "kitapla buluşmanın en kolay yolu!";
        String Title=driver.findElement(By.cssSelector(".logo-text")).getText();

        if(title.equals(Title)){
            System.out.println("Anasayfaya başarıyla girildi!");
        }
    }
    public void searchProduct(){
        methods.waitBySeconds(1);
        WebElement ara=methods.findElement(By.xpath("//*[@id=\"search-input\"]"));
        ara.sendKeys("Roman");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(1);
    }

    public void selectProduct(){
        methods.waitBySeconds(1);
        methods.findElement(By.xpath("//*[@id=\"product-306815\"]/div[1]/div[2]/a/span")).click();
        methods.waitBySeconds(1);

    }

    public void addToBasket(){
        methods.waitBySeconds(1);

        String adet= "1";
        String eklenen= driver.findElement(By.cssSelector("#sprite-cart-icon>#cart-items")).getText();

        if(adet.equals(eklenen)){
            System.out.println("Ürün sepete eklendi!");
        }


        methods.click(By.cssSelector(".add-to-cart.btn-orange.btn-ripple")); // sepete git tıklandı
        methods.waitBySeconds(1);
    }


    public void goToBasket(){
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#sprite-cart-icon"));
        methods.waitBySeconds(1);
        methods.click(By.cssSelector("#js-cart"));
        methods.waitBySeconds(1);
    }

    public void increaseProduct() {
        methods.waitBySeconds(1);
        WebElement numberProduct = methods.findElement(By.xpath("//*[@id=\"cart_module\"]/div[2]/table/tbody/tr/td[4]/form/input[1]"));
        numberProduct.clear();
        numberProduct.sendKeys("2");
        methods.waitBySeconds(1);
        methods.click(By.cssSelector(".fa.fa-refresh.green-icon"));
        methods.waitBySeconds(1);
    }

    public void updateBasket(){
        String durum= driver.findElement(By.xpath("//*[@id=\"swal2-title\"]")).getText();
        String beklenenDurum= "Sepetiniz güncelleniyor!";

        if(beklenenDurum.equals(durum)){
            System.out.println("Sepetteki ürün miktarı güncellenmiştir!");
        }
    }

    public void cancelProduct(){
        methods.waitBySeconds(1);
        methods.findElement(By.cssSelector(".fa.fa-times.red-icon")).click();
        methods.waitBySeconds(1);
    }

    public void deleteProductControl(){
        methods.waitBySeconds(1);
        String adet= "0";
        String silinen= driver.findElement(By.cssSelector("#sprite-cart-icon>#cart-items")).getText();

        if(adet.equals(silinen)){
            System.out.println("Ürün sepetten silindi!");
        }
    }

}
