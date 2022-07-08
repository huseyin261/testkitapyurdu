package test;

import driver.BaseTest;
import org.junit.Test;
import pages.ProductPage;


public class ProductTest extends BaseTest {
    @Test
    public void productTest(){
        ProductPage productPage=new ProductPage();
        productPage.mainPageControl();
        productPage.searchProduct();
        productPage.selectProduct();
        productPage.addToBasket();
        productPage.goToBasket();
        productPage.increaseProduct();
        productPage.updateBasket();
        productPage.cancelProduct();
        productPage.deleteProductControl();
    }
}
