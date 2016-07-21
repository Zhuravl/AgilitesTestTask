package components;

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

    @FindBy(xpath = ".//div[@class='main-offer-container line']//div[@class='tariff']//div[@class='time']/strong")
    private WebElement newTarifTimeValue;

    @FindBy(xpath = ".//div[@class='main-offer-container line']//div[@class='tariff']//div[@class='speed']/strong")
    private WebElement newTarifSpeedValue;

    @FindBy(xpath = ".//div[@class='main-offer-container line']//div[@class='tariff']//div[@class='cost']/strong")
    private WebElement newTarifCostValue;

    @FindBy(xpath = ".//div[@class='hint hint_pos_current-conditions']//div[@class='tariff unavailable']//div[@class='time']/strong")
    private WebElement currentTarifTimeValue;

    @FindBy(xpath = ".//div[@class='hint hint_pos_current-conditions']//div[@class='tariff unavailable']//div[@class='speed']/strong")
    private WebElement currentTariffSpeedValue;

    @FindBy(xpath = ".//div[@class='hint hint_pos_current-conditions']//div[@class='tariff unavailable']//div[@class='cost no-arrow']/strong")
    private WebElement currentTariffCostValue;
    //endregion

    public void clickReset() {
        resetButton.click();
    }

    public void typeAmount(Integer amount) {
        log.info("Type text '" + amount + "' into " + newTarifCostValue.toString());
        amountField.clear();
        amountField.sendKeys(amount.toString());
    }

    public void clickPayment() {
        log.info("Click " + paymentButton.toString());
        paymentButton.click();
    }

    public int getNewTariffCost() {
        log.info("Get text from " + newTarifCostValue.toString());
        return Integer.parseInt(newTarifCostValue.getText());
    }

    public void clickIncrease() {
        log.info("Click " + increaseButton.toString());
        increaseButton.click();
    }

    public void clickDecrease() {
        log.info("Click " + decreaseButton.toString());
        decreaseButton.click();
    }

    public void clickPurchase() {
        log.info("Click " + purchaseButton.toString());
        purchaseButton.click();
    }

    public int getBalanceValue() {
        log.info("Get balance from " + balanceView.toString());
        return Integer.parseInt(balanceView.getText());
    }

    public int getCurrentTariffTimeValue() {
        log.info("Get current tariff time");
        return Integer.parseInt(currentTarifTimeValue.getText());
    }

    public String getCurrentTariffSpeedValue() {
        log.info("Get current tariff speed");
        return currentTariffSpeedValue.getText();
    }

    public int getCurrentTariffCostValue() {
        log.info("Get current tariff cost");
        return Integer.parseInt(currentTariffCostValue.getText());
    }
}
