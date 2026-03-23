package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-realtime-overview")
@NgRoutable(path = "home/real-time-overview")
public class RealTimeOverviewPage extends WebsitePage<RealTimeOverviewPage> implements INgComponent<RealTimeOverviewPage> {
    public RealTimeOverviewPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);

        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP supports REST endpoints (Jakarta RS), 50+ server-driven AJAX events, and typed "
                        + "@NgDataService classes out of the box — no WebSocket infrastructure required. When you "
                        + "need push updates, the built-in Vert.x STOMP event bus is already there (AG Grid "
                        + "and Chart.js use it for live data). For production scale, add RabbitMQ Comms for "
                        + "broker-backed durability. Start with request/response. Layer in real-time when you need it.",
                "m"));

        content.add(codeBlockWithTitle("REST endpoint — always available",
                "@Path(\"/api/sales\") @GET\n"
                        + "public List<SalesRow> getSales() { return service.findAll(); }"));

        content.add(codeBlockWithTitle("Push updates — opt-in when ready",
                "StompEventBusPublisher.publish(vertx, \"dashboard\", jsonPayload);\n"
                        + "// or: publisher.publish(\"user-\" + userId, payload); // RabbitMQ"));

        var ctas = new WaCluster<>();
        ctas.setGap(PageSize.Small);
        ctas.add(buildCta("Communication Patterns", "/real-time", Variant.Brand, null));
        content.add(ctas);

        layout.add(buildSection("CLIENT-SERVER COMMUNICATION",
                "REST, AJAX, Data Services, and Real-Time",
                "Request/response first. Push updates when you need them.",
                false, content));

        getMain().add(layout);
    }
}

