package steps;

import global.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddToCart extends BaseClass {

    String nameOfProduct;
    String quantityOfProduct;
    String priceOfProduct;

    @Given("Open application")
    public void openApplication() throws Exception {
        openApps();
    }

    @Given("Click product")
    public void clickProduct() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Sauce Lab Back Packs\"]")).click();
    }

    @Given("Choose blue color")
    public void chooseBlueColor() {
        nameOfProduct = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")).getText();
        scrollDown();
        priceOfProduct = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.TextView")).getText();
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Blue color\"]")).click();
    }

    @Given("Select how many want to add")
    public void selectHowManyWantToAdd() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Increase item quantity\"]")).click();
        quantityOfProduct = driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.TextView")).getText();
    }

    @Given("Click add")
    public void clickAdd() {
        driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")).click();
    }

    @When("Click cart")
    public void clickCart() {
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")).click();
    }

    @Then("The product added to cart successfully")
    public void theProductAddedToCartSuccessfully() {
        String resultOfName = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        String resultOfQuantity = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
        String resultOfPrice = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays list of selected products\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).getText();
        Assert.assertEquals(nameOfProduct, resultOfName);
        Assert.assertEquals(quantityOfProduct, resultOfQuantity);
        Assert.assertEquals(priceOfProduct, resultOfPrice);
        closeApps();
    }





}
