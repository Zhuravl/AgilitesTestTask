package features;

import pages.SupportPage;
import enums.TariffType;
import utils.TestContext;

/**
 * Class contains combined sets of primitive methods from page
 */
public class SliderFeature {
    private SupportPage supportPage = new SupportPage();

    public void resetBalance() throws InterruptedException {
        supportPage.clickReset();
        waitForUpdateCompleted();
    }

    public void supplementBalance(String amount) throws InterruptedException {
        supportPage.typeAmount(amount);
        supportPage.clickPayment();
        waitForUpdateCompleted();
    }

    public void supplementBalance(Number amount) throws InterruptedException {
        supplementBalance(amount.toString());
    }

    public void selectTariff(TariffType tariff) {
        TariffType curTariff = getNewTariff();
        if (curTariff.getCost() != tariff.getCost()){
            if (curTariff.getCost() < tariff.getCost()){
                while (curTariff.getCost() != tariff.getCost()){
                    supportPage.clickIncrease();
                    curTariff = getNewTariff();
                }
            } else {
                while (curTariff.getCost() != tariff.getCost()){
                    supportPage.clickDecrease();
                    curTariff = getNewTariff();
                }
            }
        }
    }

    public void setTariff(TariffType tariff) {
        selectTariff(tariff);
        supportPage.clickPurchase();
    }

    public int getBalance() {
        String s = supportPage.getBalanceValue();
        //Check that actual balance is integer number
        if (s.contains(".") || s.contains("e")) {
            return -1;
        } else return Integer.parseInt(s);
    }

    public TariffType getCurrentTariff() {
        return TariffType.getTariffType(
                supportPage.getCurrentTariffTimeValue(),
                supportPage.getCurrentTariffSpeedValue(),
                supportPage.getCurrentTariffCostValue()
        );
    }

    public TariffType getNewTariff() {
        return TariffType.getTariffType(
                supportPage.getNewTariffTimeValue(),
                supportPage.getNewTariffSpeedValue(),
                supportPage.getNewTariffCostValue()
        );
    }

    private void waitForUpdateCompleted() throws InterruptedException {
        //TODO Re-implement this method by better way
        Thread.sleep(TestContext.DEFAULT_WAIT_TIME);
    }
}
