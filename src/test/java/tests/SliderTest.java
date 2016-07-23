package tests;

import enums.TariffType;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestContext;

public class SliderTest extends BaseTest{

    @BeforeClass
    private void getTargetPage(){
        log.info("Navigate to the target page " + TestContext.SLIDER_PAGE_URL);
        TestContext.getDriver().get(TestContext.SLIDER_PAGE_URL);
    }

    @BeforeMethod
    private void resetBalance() throws InterruptedException {
        sliderFeature.resetBalance();
        Assert.assertEquals(sliderFeature.getBalance(), 0, "Verify that balance equals 0");
        Assert.assertEquals(sliderFeature.getCurrentTariff(), TariffType.FREE, "Verify that current tariff is " + TariffType.FREE.toString());
    }

    @DataProvider
    public Object[][] balanceData(){
        return new Object[][]{
                {1, 1},
                {1000000, 1000000},
                {0, 0},
                {1000001, 0},
                {-1, 0},
                {"%", 0},
                {"a", 0},
                {0.5, 0},
        };
    }

    @Test(description = "TC8 - Payment balance check", dataProvider  = "balanceData")
    public void balanceCheck(Object amount, int result) throws InterruptedException{
        if (amount instanceof Number) {
            sliderFeature.supplementBalance((Number) amount);
        } else {
            sliderFeature.supplementBalance((String) amount);
        }

        Assert.assertEquals(sliderFeature.getBalance(), result, "Verify that balance equals " + result);
    }

    @Test(description = "TC5 - Purchase new tariff")
    public void purchaseNewTariffTest() throws InterruptedException{
        sliderFeature.supplementBalance(300);
        Assert.assertEquals(sliderFeature.getBalance(), 300, "Verify that balance equals 300");

        sliderFeature.setTariff(TariffType.T320);
        Assert.assertEquals(sliderFeature.getCurrentTariff(), TariffType.T320, "Verify that current tariff is " + TariffType.T320.toString());
    }

    @Test(description = "TC9 - Reset button behaviour")
    public void resetButtonBehaviour() throws InterruptedException{
        sliderFeature.supplementBalance(300);
        Assert.assertEquals(sliderFeature.getBalance(), 300, "Verify that balance equals 300");

        sliderFeature.resetBalance();
        Assert.assertEquals(sliderFeature.getBalance(), 0, "Verify that balance equals 0");
        Assert.assertEquals(sliderFeature.getCurrentTariff(), TariffType.FREE, "Verify that current tariff is " + TariffType.FREE.toString());
    }
}