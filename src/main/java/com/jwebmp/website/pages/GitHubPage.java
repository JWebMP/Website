package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;

@NgComponent("jwebmp-github")
@NgRoutable(path = "github")
public class GitHubPage extends WebsitePage<GitHubPage> implements INgComponent<GitHubPage>
{
    public GitHubPage()
    {
        buildGitHubPage();
    }

    private void buildGitHubPage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro
        var intro = new WaStack();
        intro.setGap(PageSize.Medium);
        intro.add(bodyText(
                "JWebMP is fully open source under the Apache 2.0 licence. The codebase is split across "
                + "focused repositories — core, client, plugins, Vert.x connector, and RabbitMQ comms. "
                + "Contributions, bug reports, and feature requests are welcome on any repo.",
                "m"));
        layout.add(buildSection("OPEN SOURCE",
                "JWebMP on GitHub",
                "Apache 2.0 licensed. Fork it, extend it, ship it.",
                false, intro));

        // Repository grid
        var grid = grid(2);

        grid.add(featureCard("JWebMP Core",
                "The HTML/CSS/JS component model, page rendering, event system, and AJAX pipeline.",
                "github.com/JWebMP/Core"));

        grid.add(featureCard("JWebMP Client",
                "Client SPI contracts — AjaxCall/AjaxResponse, component interfaces, interceptors.",
                "github.com/JWebMP/Client"));

        grid.add(featureCard("JWebMP Plugins",
                "Angular, WebAwesome, AG Grid, AG Charts, FullCalendar, Font Awesome, Chart.js, Easing.",
                "github.com/JWebMP/Plugins"));

        grid.add(featureCard("JWebMP Vert.x",
                "Vert.x 5 HTTP connector — page routing, AJAX handler, CSS/JS endpoints, WebSocket bridge.",
                "github.com/JWebMP/VertX"));

        grid.add(featureCard("JWebMP RabbitMQ",
                "RabbitMQ-to-browser messaging — STOMP/WebSocket bridge, Angular directives, group pub/sub.",
                "github.com/JWebMP/RabbitComms"));

        grid.add(featureCard("JWebMP BOM",
                "Bill of Materials POM that manages versions across the entire JWebMP ecosystem.",
                "github.com/JWebMP/BOM"));

        layout.add(buildSection(null, "Repositories", null, true, grid));

        // Related
        var relatedGrid = grid(2);

        relatedGrid.add(featureCard("GuicedEE",
                "The foundational platform — Guice DI, Vert.x 5 lifecycle, SPI discovery, JPMS modules.",
                "github.com/GuicedEE"));

        relatedGrid.add(featureCard("EntityAssist",
                "Type-safe JPA/Hibernate entity management with CRTP builders.",
                "github.com/EntityAssist"));

        layout.add(buildSection(null, "Related Projects", null, false, relatedGrid));
    }
}
