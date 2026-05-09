package com.jwebmp.website.pages.architecture;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;
import com.jwebmp.website.pages.WebsitePage;

@NgComponent("jwebmp-arch-dataflow")
@NgRoutable(path = "architecture/data-flow")
public class DataFlowPage extends WebsitePage<DataFlowPage> implements INgComponent<DataFlowPage> {
    public DataFlowPage() {
        var layout = new WaStack<>();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack<>();
        content.setGap(PageSize.Medium);

        content.add(mermaidDiagramWithTitle("Request-Response Flow",
                """
                        sequenceDiagram
                          participant B as 🌐 Browser
                          participant V as ⚡ Vert.x Server
                          participant H as ☕ Java Handler

                          rect rgba(99, 102, 241, 0.1)
                          Note over B,V: Page Delivery
                          B->>V: GET /dashboard
                          V-->>B: index.html + dist/ assets
                          end

                          rect rgba(52, 211, 153, 0.1)
                          Note over B,H: AJAX Event Cycle
                          B->>V: POST /jwajax
                          V->>H: deserialize AjaxCall
                          H->>H: intercept → fireEvent()
                          H-->>V: AjaxResponse
                          V-->>B: DOM update instructions
                          end

                          rect rgba(248, 113, 113, 0.1)
                          Note over B,H: Real-Time Push
                          B->>V: WS /eventbus STOMP
                          V->>H: RabbitMQ exchange
                          V-->>B: STOMP message push
                          end
                        """));

        layout.add(buildSection("DATA FLOW", "Request, Event, and Message Paths",
                "HTTP for pages, AJAX for events, WebSocket for real-time.", false, content));
        getMain().add(layout);
    }
}
