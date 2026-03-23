package com.jwebmp.website.pages.capabilities;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-cap-realtime")
@NgRoutable(path = "capabilities/real-time-messaging")
public class RealTimeMessagingPage extends WebsitePage<RealTimeMessagingPage> implements INgComponent<RealTimeMessagingPage> {
    public RealTimeMessagingPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        var grid = grid(2);
        grid.add(featureCard("RabbitMQ WebSocket Bridge", "STOMP over WebSocket connects Angular clients directly to RabbitMQ exchanges. Server publishes via AMQP; browsers receive via STOMP. Automatic reconnection, heartbeat monitoring, and SockJS fallback.", null));
        grid.add(featureCard("Group-Based Pub/Sub", "Dynamic subscription management with fanout exchanges. Session-aware groups (Everyone, per-session, per-user) with automatic exchange lifecycle.", null));
        grid.add(featureCard("Angular Directive", "The [data-rabbit-groups] directive subscribes Angular components to RabbitMQ exchanges declaratively. Messages arrive automatically; cleanup runs on destroy.", null));
        grid.add(featureCard("STOMP Event Bus", "Built-in receivers for AJAX calls, data requests, data sends, and group management. Inbound messages at /toBus/incoming are deserialized, dispatched, and responded to via the Vert.x event bus.", null));
        content.add(grid);
        layout.add(buildSection("REAL-TIME", "Bidirectional Client-Server Messaging", "RabbitMQ + WebSocket + Angular — live updates without boilerplate.", false, content));
        getMain().add(layout);
    }
}

