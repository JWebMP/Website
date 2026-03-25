package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-rabbitmq")
@NgRoutable(path = "real-time/rabbitmq")
public class RabbitMQPage extends WebsitePage<RabbitMQPage> implements INgComponent<RabbitMQPage> {
    public RabbitMQPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(richText("For deployments that need durable messaging, multi-instance fan-out, or broker-managed persistence, add the RabbitMQ Comms module. Server-side Java publishes via AMQP to RabbitMQ fanout exchanges. Browser-side Angular connects directly to RabbitMQ via the Web STOMP plugin. Each group name maps to a fanout exchange — messages broadcast to every subscribed client.", "m"));
        var grid = grid(2);
        grid.add(featureCard("Broker-Managed Durability", "Persistent exchanges survive broker restarts. Scale horizontally by adding app instances behind the same broker.", null));
        grid.add(featureCard("Angular Directive", "The [data-rabbit-groups] directive subscribes Angular components to RabbitMQ exchanges declaratively. Subscribe on mount, unsubscribe on destroy.", null));
        grid.add(featureCard("Automatic Exchange Lifecycle", "Exchanges are declared on first subscribe. Session exchanges auto-delete. Custom exchanges persist.", null));
        grid.add(featureCard("SockJS Fallback", "STOMP.js connects via WebSocket. SockJS provides transparent fallback for browsers or proxies that block WebSocket.", null));
        content.add(grid);
        layout.add(buildSection("RABBITMQ COMMS", "Broker-Backed Messaging for Scale", "Add the dependency, enable Web STOMP on RabbitMQ, and publish.", false, content));
        getMain().add(layout);
    }
}

