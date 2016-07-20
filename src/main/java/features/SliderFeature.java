package features;

import components.SupportPage;

/**
 * Class contains combined sets of primitive methods from page
 */
public class SliderFeature {
    private SupportPage supportPage = new SupportPage();

    public void navigateToPage(String url) {
        supportPage.navigateToPage(url);
    }

}
