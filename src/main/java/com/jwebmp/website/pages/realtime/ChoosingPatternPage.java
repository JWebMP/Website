package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-choosing")
@NgRoutable(path = "real-time/choosing-a-pattern")
public class ChoosingPatternPage extends WebsitePage<ChoosingPatternPage> implements INgComponent<ChoosingPatternPage> {
    public ChoosingPatternPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(bodyText("Most applications start with REST and AJAX — they cover the majority of client-server interactions. Add real-time when your use case demands it. All patterns coexist in the same application.", "m"));
        var grid = grid(2);
        grid.add(featureCard("REST & AJAX — The Default", "Standard request/response. REST endpoints for API consumers. AJAX events for interactive UI. Data services for typed data fetching. No WebSocket infrastructure needed.", "Always available"));
        grid.add(featureCard("Vert.x Event Bus — Zero-Infra Push", "Add push updates without a broker. Plugin data push (AG Grid, Chart.js, FullCalendar). Single-instance deployments. Rapid prototyping.", "Built-in with Angular plugin"));
        grid.add(featureCard("RabbitMQ — Production Scale", "Multi-instance deployments. Durable message delivery. Broker-managed routing and persistence. SLA requirements.", "Requires RabbitMQ broker"));
        grid.add(featureCard("Mix and Match", "REST for your API. AJAX for form submissions. Vert.x event bus for grid data push. RabbitMQ for cross-instance notifications. All in the same app.", "Composable"));
        content.add(grid);
        layout.add(buildSection("CHOOSING A PATTERN", "When to Use What", "Start with REST and AJAX. Add real-time when you need it.", false, content));
        getMain().add(layout);
    }
}

