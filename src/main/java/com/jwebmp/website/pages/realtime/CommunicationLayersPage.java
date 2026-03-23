package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-layers")
@NgRoutable(path = "real-time/communication-layers")
public class CommunicationLayersPage extends WebsitePage<CommunicationLayersPage> implements INgComponent<CommunicationLayersPage> {
    public CommunicationLayersPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(codeBlockWithTitle("Communication Stack",
                "  REQUEST / RESPONSE (always available)\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  REST Endpoints     @Path @GET @POST        │  ← Jakarta RS on Vert.x\n"
                        + "  │  AJAX Events        OnClickAdapter, etc.    │  ← 50+ server-driven events\n"
                        + "  │  Data Services      @NgDataService           │  ← Typed Angular services\n"
                        + "  └─────────────────────────────────────────────┘\n"
                        + "\n"
                        + "  REAL-TIME (opt-in when you need it)\n"
                        + "  ┌─────────────────────────────────────────────┐\n"
                        + "  │  Vert.x Event Bus   Built-in STOMP/WS       │  ← Zero infrastructure\n"
                        + "  │  RabbitMQ Comms     Broker-backed STOMP/WS   │  ← Production scale\n"
                        + "  └─────────────────────────────────────────────┘"));

        content.add(bodyText(
                "The request/response layer is always present. REST endpoints, AJAX event handlers, and "
                        + "data services require no additional dependencies beyond JWebMP core. The real-time "
                        + "layer is opt-in — add it when your application needs push updates, live data, "
                        + "or bidirectional messaging.",
                "m"));

        layout.add(buildSection("LAYERED COMMUNICATION", "Request/Response First, Real-Time When Ready",
                "REST and AJAX are the foundation. WebSocket is the upgrade path.", true, content));
        getMain().add(layout);
    }
}

