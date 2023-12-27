package stepdefinitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import utils.DriverHelper;

public class ValidateProductAndSubCategorySteps {

    WebDriver driver = DriverHelper.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);


    @Then("user click add new category button")
    public void user_click_add_new_category_button() throws InterruptedException {
        productsPage.clickAddCategoryButton();
    }

    @Then("the user enter {string}")
    public void the_user_enter(String categoryName) {
        productsPage.categoryName(categoryName);
    }

    @Then("the user clicks {string}")
    public void the_user_clicks(String button) throws InterruptedException {
        productsPage.saveNewCategory(button);
    }

    @Then("the user verifies category {string} added")
    public void the_user_verifies_category_added(String categoryName) throws InterruptedException {
      productsPage.validateCreatedCategory(categoryName);
    }

    @Then("the user click add new category button")
    public void the_user_click_add_new_category_button() {

    }

    @Then("the user verifies new category Hauling Equipment showing on the category list")
    public void the_user_verifies_new_category_hauling_equipment_showing_on_the_category_list() {

    }

    @Then("the user selects {string} as category")
    public void the_user_selects_as_category(String string) {

    }

    @Then("the user click add button for the product Sub Category")
    public void the_user_click_add_button_for_the_product_sub_category() {

    }

    @Then("the user enter Sub Category Name: {string}")
    public void the_user_enter_sub_category_name(String string) {

    }

    @Then("the user verifies Sub Category is displayed on product page and after clicking add button")
    public void the_user_verifies_sub_category_is_displayed_on_product_page_and_after_clicking_add_button() {

    }
}
