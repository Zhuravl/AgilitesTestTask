package features;

import org.apache.logging.log4j.Logger;
import pages.SupportPage;
import enums.TariffType;
import utils.TestContext;

/**
 * Class contains combined sets of primitive methods from page
 */
public class SliderFeature {
    private SupportPage supportPage = new SupportPage();
    private static Logger log = TestContext.getLogger();

    /**
     * Resets balance
     * @throws InterruptedException
     */
    public void resetBalance() throws InterruptedException {
        log.info("Reset balance");
        supportPage.clickReset();
        waitForUpdateCompleted();
    }

    /**
     * Supplements balance
     * @param amount - amount to supplement
     * @throws InterruptedException
     */
    public void supplementBalance(String amount) throws InterruptedException {
        log.info("Supplement balance");
        supportPage.typeAmount(amount);
        supportPage.clickPayment();
        waitForUpdateCompleted();
    }

    /**
     * Supplements balance
     * @param amount - amount to supplement
     * @throws InterruptedException
     */
    public void supplementBalance(Number amount) throws InterruptedException {
        supplementBalance(amount.toString());
    }

    /**
     * Selects new tariff
     * @param tariff - target tariff
     */
    public void selectTariff(TariffType tariff) {
        log.info("Select new tariff");
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

    /**
     * Sets new tariff
     * @param tariff - target tariff
     */
    public void setTariff(TariffType tariff) {
        log.info("Set new tariff");
        selectTariff(tariff);
        supportPage.clickPurchase();
    }

    /**
     * Returns balance
     */
    public int getBalance() {
        log.info("Get balance");
        String s = supportPage.getBalanceValue();
        //Check that actual balance is integer number
        if (s.contains(".") || s.contains("e")) {
            log.info("Balance not integer value - " + s + ", so will return -1");
            return -1;
        } else {
            Integer i = Integer.parseInt(s);
            log.info("Balance - " + i);
            return i;
        }
    }

    /**
     * Returns current tariff
     */
    public TariffType getCurrentTariff() {
        log.info("Get current tariff");
        TariffType tt = TariffType.getTariffType(
                supportPage.getCurrentTariffTimeValue(),
                supportPage.getCurrentTariffSpeedValue(),
                supportPage.getCurrentTariffCostValue()
        );
        log.info("Current tariff is " + tt.toString());
        return tt;
    }

    /**
     * Returns new tariff
     */
    public TariffType getNewTariff() {
        log.info("Get new tariff");
        TariffType tt = TariffType.getTariffType(
                supportPage.getNewTariffTimeValue(),
                supportPage.getNewTariffSpeedValue(),
                supportPage.getNewTariffCostValue()
        );
        log.info("New tariff is " + tt.toString());
        return tt;
    }

    /**
     * Waits for update to be completed
     * @throws InterruptedException
     */
    private void waitForUpdateCompleted() throws InterruptedException {
        //TODO Re-implement this method by better way
        Thread.sleep(TestContext.DEFAULT_WAIT_TIME);
    }
}
