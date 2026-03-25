package com.jwebmp.website.pages.realtime;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-rt-vertx")
@NgRoutable(path = "real-time/vertx-event-bus")
public class VertxEventBusPage extends WebsitePage<VertxEventBusPage> implements INgComponent<VertxEventBusPage> {
    public VertxEventBusPage() {
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(richText("When you need server-to-browser push, the Angular plugin includes a built-in STOMP server at `/eventbus` backed by the Vert.x event bus. No external broker required. The generated `EventBusService` manages connections, reconnection, and message routing. Plugins like AG Grid, FullCalendar, and Chart.js already use this for live data push.", "m"));
        var grid = grid(2);
        grid.add(featureCard("Zero Configuration", "The STOMP server starts automatically when the Angular plugin is on the classpath. No environment variables, no broker setup, no additional dependencies.", null));
        grid.add(featureCard("Plugin Data Push", "AG Grid, FullCalendar, and Chart.js register IWebSocketMessageReceiver implementations to push data to the browser. The pattern is SPI-driven — register your own receiver to handle any custom message type.", null));
        grid.add(featureCard("Built-in Receivers", "WebSocketAjaxCallReceiver (ajax), WebSocketDataRequestCallReceiver (data), WebSocketDataSendCallReceiver (dataSend), group management receivers — all discovered via SPI at startup.", null));
        grid.add(featureCard("Session & Context Aware", "EventBusService generates a GUID per browser tab and subscribes to private addresses. Session storage and local storage updates arrive as event bus messages.", null));
        content.add(grid);
        layout.add(buildSection("VERT.X EVENT BUS", "Built-In Real-Time — No Broker Required", "Opt-in STOMP/WebSocket backed by the Vert.x event bus.", false, content));
        getMain().add(layout);
    }
}

