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

@NgComponent("jwebmp-gs-whats-happening")
@NgRoutable(path = "getting-started/whats-happening")
public class WhatsHappeningPage extends WebsitePage<WhatsHappeningPage> implements INgComponent<WhatsHappeningPage> {
    public WhatsHappeningPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText("Under the hood, your six files produced a complete application:", "m"));

        var grid = grid(2);

        grid.add(featureCard("TypeScript Generated",
                "The Angular Maven Plugin scanned your @NgApp and @NgComponent classes and generated "
                        + ".ts files, angular.json, package.json, tsconfig.json, and routing modules.",
                null));

        grid.add(featureCard("Angular Built",
                "npm install and ng build --configuration production ran automatically. "
                        + "The compiled dist/ was bundled into your JAR.",
                null));

        grid.add(featureCard("Vert.x Serving",
                "IGuiceContext.inject() discovered JWebMPVertx via SPI, started the HTTP server, "
                        + "and registered routes for the SPA, AJAX, CSS, and scripts.",
                null));

        grid.add(featureCard("SPI Wired",
                "Every IPageConfigurator, IEventConfigurator, and render-ordering hook was discovered "
                        + "and applied — WebAwesome CSS/JS injected, theme classes added.",
                null));

        content.add(grid);

        layout.add(buildSection("UNDER THE HOOD",
                "What Just Happened?",
                "Six Java files. A complete reactive Angular application.",
                false, content));
        getMain().add(layout);
    }
}

