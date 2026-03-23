package com.jwebmp.website.pages.gettingstarted;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-gs-prerequisites")
@NgRoutable(path = "getting-started/prerequisites")
public class PrerequisitesPage extends WebsitePage<PrerequisitesPage> implements INgComponent<PrerequisitesPage> {
    public PrerequisitesPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        var grid = grid(3);

        grid.add(featureCard("Java 25+",
                "JWebMP targets the latest Java with preview features. Download from adoptium.net or sdkman.",
                null));

        grid.add(featureCard("Maven 3.9+",
                "The build uses Maven with the JWebMP and GuicedEE BOM chain. No Gradle support yet.",
                null));

        grid.add(featureCard("Node.js 22+",
                "Required by the Angular CLI for the TypeScript build. Install from nodejs.org or nvm.",
                null));

        content.add(grid);

        layout.add(buildSection("PREREQUISITES",
                "What You Need",
                null,
                true, content));

        getMain().add(layout);
    }
}

