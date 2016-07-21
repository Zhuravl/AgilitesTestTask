package tests;

import enums.TariffType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestContext;

public class SliderTest extends BaseTest{

    @BeforeClass
    private void getTargetPage(){
        log.info("Navigate to the target page " + TestContext.sliderPageUrl);
        TestContext.getDriver().get(TestContext.sliderPageUrl);
    }

    @Test(description = "TC1 - Smoke test")
    public void smokeTest() throws InterruptedException{
        sliderFeature.resetBalance();
        Assert.assertEquals(sliderFeature.getBalance(), 0, "Verify that balance equals 0");

        sliderFeature.supplementBalance(500);
        Thread.sleep(1000);
        Assert.assertEquals(sliderFeature.getBalance(), 500, "Verify that balance equals 500");

        sliderFeature.setTariffWithCost(TariffType.T512);
        Assert.assertEquals(sliderFeature.getCurrentTariff(), TariffType.T512, "Verify that current tariff is " + TariffType.T512.toString());

        sliderFeature.resetBalance();
        Assert.assertEquals(1, 1, "Verify that current tariff is " + TariffType.FREE.toString());
    }
}
