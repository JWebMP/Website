package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-production-ready")
@NgRoutable(path = "home/production-ready")
public class ProductionReadyPage extends WebsitePage<ProductionReadyPage> implements INgComponent<ProductionReadyPage> {
    public ProductionReadyPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        // Production Ready section
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("JPMS Modular",
                "Every module has an explicit module-info.java with declared exports, requires, and provides. "
                        + "JLink-ready for minimal container images.",
                null));

        grid.add(featureCard("Reactive Non-Blocking",
                "Vert.x 5 event-loop server. No thread-per-request overhead. "
                        + "Scales to thousands of concurrent connections.",
                null));

        grid.add(featureCard("Apache 2.0 Open Source",
                "Permissive licensing. Fork it, extend it, ship it. "
                        + "Active development with snapshot builds on Maven Central.",
                null));

        content.add(grid);

        layout.add(buildSection("PRODUCTION READY",
                "Ship with Confidence",
                "Modular, reactive, and open source — ready for production workloads.",
                true, content));

        // Call to Action
        var ctaContent = new WaStack();
        ctaContent.setGap(PageSize.Medium);

        ctaContent.add(bodyText(
                "Stop context-switching between Java and TypeScript. Build your entire web application "
                        + "in the language you already know. JWebMP handles the rest.",
                "l"));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("View on GitHub", "/github", Variant.Neutral, Appearance.Outlined));
        ctaContent.add(ctas);

        layout.add(buildSection(null,
                "Ready to Build?",
                "From zero to production Angular app — entirely in Java.",
                false, ctaContent));

        getMain().add(layout);
    }
}

