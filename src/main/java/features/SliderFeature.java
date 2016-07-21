package features;

import components.SupportPage;
import enums.TariffType;

/**
 * Class contains combined sets of primitive methods from page
 */
public class SliderFeature {
    private SupportPage supportPage = new SupportPage();

    public void resetBalance() {
        supportPage.clickReset();
    }

    public void supplementBalance(int amount) {
        supportPage.typeAmount(amount);
        supportPage.clickPayment();
    }

    public void setTariffWithCost(TariffType tariff) {
        int curTariff = supportPage.getNewTariffCost();
        if (curTariff != tariff.getCost()){
            if (curTariff < tariff.getCost()){
                while (curTariff != tariff.getCost()){
                    supportPage.clickIncrease();
                    curTariff = supportPage.getNewTariffCost();
                }
            } else {
                while (curTariff != tariff.getCost()){
                    supportPage.clickDecrease();
                    curTariff = supportPage.getNewTariffCost();
                }
            }
            supportPage.clickPurchase();
        }
    }

    public int getBalance() {
        return supportPage.getBalanceValue();
    }

    public TariffType getCurrentTariff() {
        return TariffType.getTariffType(
                supportPage.getCurrentTariffTimeValue(),
                supportPage.getCurrentTariffSpeedValue(),
                supportPage.getNewTariffCost()
        );
    }
}
