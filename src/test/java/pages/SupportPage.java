package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * Class contains description of elements from support page
 */
public class SupportPage extends BasePage{

    //region Amount elements
    @FindBy(xpath = ".//dd[@id='balance-holder']/span")
    private WebElement balanceView;

    @FindBy(id = "amount")
    private WebElement amountField;

    @FindBy(xpath = ".//a[@data-bind='click: doPayment']")
    private WebElement paymentButton;

    @FindBy(xpath = ".//a[@data-bind='click: doReset']")
    private WebElement resetButton;

    //endregion

    //region Slider elements
    @FindBy(xpath = ".//div[@class='decrease']/a")
    private WebElement decreaseButton;

    @FindBy(xpath = ".//div[@class='increase']/a")
    private WebElement increaseButton;

    @FindBy(xpath = ".//*[@class='tarriff-info']/a")
    private WebElement purchaseButton;

    @FindBy(xpath = "//div[@class='tariff']//div[@class='time']/strong")
    private WebElement newTarifTimeValue;

    @FindBy(xpath = "//div[@class='tariff']//div[@class='speed']/strong")
    private WebElement newTarifSpeedValue;

    @FindBy(xpath = "//div[@class='tariff']//div[@class='cost']/strong")
    private WebElement newTarifCostValue;

    @FindBy(xpath = "//div[@class='tariff unavailable']//div[@class='time']/strong")
    private WebElement currentTarifTimeValue;

    @FindBy(xpath = "//div[@class='tariff unavailable']//div[@class='speed']/strong")
    private WebElement currentTariffSpeedValue;

    @FindBy(xpath = "//div[@class='tariff unavailable']//div[@class='cost no-arrow']/strong")
    private WebElement currentTariffCostValue;
    //endregion

    /**
     * Clicks Reset button
     */
    public void clickReset() {
        log.info("Click Reset");
        resetButton.click();
    }

    /**
     * Types text into Amount field
     * @param amount - text to type
     */
    public void typeAmount(String amount) {
        log.info("Type text '" + amount + "'.");
        amountField.clear();
        amountField.sendKeys(amount);
    }

    /**
     * Clicks Payment button
     */
    public void clickPayment() {
        log.info("Click Payment");
        paymentButton.click();
    }

    /**
     * Returns new tariff cost
     */
    public int getNewTariffCostValue() {
        log.info("Get new tariff cost");
        String s = newTarifCostValue.getText();
        log.info("New tariff cost - " + s);
        return Integer.parseInt(s);
    }

    /**
     * Returns new tariff time
     */
    public int getNewTariffTimeValue() {
        log.info("Get new tariff time");
        String s = newTarifTimeValue.getText();
        log.info("New tariff time - " + s);
        return Integer.parseInt(s);
    }

    /**
     * Returns new tariff speed
     */
    public String getNewTariffSpeedValue() {
        log.info("Get new tariff speed");
        String s = newTarifSpeedValue.getText();
        log.info("New tariff speed - " + s);
        return s;
    }

    /**
     * Clicks Increase button
     */
    public void clickIncrease() {
        log.info("Click Increase");
        increaseButton.click();
    }

    /**
     * Clicks Decrease button
     */
    public void clickDecrease() {
        log.info("Click Decrease");
        decreaseButton.click();
    }

    /**
     * Clicks Purchase button
     */
    public void clickPurchase() {
        log.info("Click Purchase");
        purchaseButton.click();
    }

    /**
     * Returns balance
     */
    public String getBalanceValue() {
        log.info("Get balance");
        String s = balanceView.getText();
        log.info("Balance - " + s);
        return s;
    }

    /**
     * Returns current tariff time
     */
    public int getCurrentTariffTimeValue() {
        log.info("Get current tariff time");
        String s = currentTarifTimeValue.getText();
        log.info("Current tariff time - " + s);
        return Integer.parseInt(s);
    }

    /**
     * Returns current tariff speed
     */
    public String getCurrentTariffSpeedValue() {
        log.info("Get current tariff speed");
        String s = currentTariffSpeedValue.getText();
        log.info("Current tariff speed - " + s);
        return s;
    }

    /**
     * Returns current tariff cost
     */
    public int getCurrentTariffCostValue() {
        log.info("Get current tariff cost");
        String s = currentTariffCostValue.getText();
        log.info("Current tariff cost - " + s);
        return Integer.parseInt(s);
    }
}
