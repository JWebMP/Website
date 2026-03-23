package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.webawesome.components.button.Appearance;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-usecases")
@NgRoutable(path = "real-time/use-cases")
public class UseCasesPage extends WebsitePage<UseCasesPage> implements INgComponent<UseCasesPage> {
    public UseCasesPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("CRUD Applications", "REST endpoints for API access. AJAX events for form submissions and interactive buttons. Standard request/response — no real-time needed.", "REST + AJAX"));
        grid.add(featureCard("Live Data Grids & Charts", "AG Grid and Chart.js register WebSocket receivers on the Vert.x event bus. Push new data from the server — components update in real time.", "Vert.x event bus"));
        grid.add(featureCard("Push Notifications", "Send user-specific or broadcast notifications from event handlers, scheduled tasks, or message consumers.", "Vert.x or RabbitMQ"));
        grid.add(featureCard("Collaborative & IoT", "Multi-user editing, live presence, sensor telemetry. RabbitMQ provides durability and multi-instance fan-out.", "RabbitMQ"));
        content.add(grid);

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Get Started", "/getting-started", Variant.Brand, null));
        ctas.add(buildCta("Full Plugin Catalog", "/plugins", Variant.Neutral, Appearance.Outlined));
        content.add(ctas);

        layout.add(buildSection("USE CASES", "Matching Patterns to Problems", "From CRUD forms to real-time dashboards — the right tool for each job.", false, content));
        getMain().add(layout);
    }
}

