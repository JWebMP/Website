package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-next-steps")
@NgRoutable(path = "getting-started/next-steps")
public class NextStepsPage extends WebsitePage<NextStepsPage> implements INgComponent<NextStepsPage> {
    public NextStepsPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "You have a working JWebMP application. From here, add plugins for data grids, charts, "
                        + "calendars, or real-time messaging — each is a Maven dependency away. Some plugins "
                        + "(like AG Grid, Chart.js, FullCalendar) require Angular mode; others (like WebAwesome, "
                        + "Font Awesome) work in both modes. Check the plugin catalog for details.",
                "m"));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Browse Plugins", "/plugins", Variant.Brand, null));
        ctas.add(buildCta("See the Architecture", "/architecture", Variant.Neutral, Appearance.Outlined));
        ctas.add(buildCta("Real-Time Messaging", "/real-time", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        layout.add(buildSection(null,
                "Next Steps",
                "Every plugin is a Maven dependency away.",
                true, content));
        getMain().add(layout);
    }
}

