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
        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(codeBlockWithTitle("Request-Response Flow",
                "Browser                     Vert.x Server                Java Handler\n"
                        + "   │                            │                            │\n"
                        + "   ├── GET /dashboard ──────────>│                            │\n"
                        + "   │                            ├── StaticHandler ────────────│\n"
                        + "   │<── index.html + dist/ ─────┤                            │\n"
                        + "   │                            │                            │\n"
                        + "   ├── POST /jwajax ────────────>│                            │\n"
                        + "   │   (AjaxCall JSON)          ├── deserialize ─────────────>│\n"
                        + "   │                            │   ├── intercept chain       │\n"
                        + "   │                            │   ├── fireEvent()           │\n"
                        + "   │                            │   └── AjaxResponse ─────────>│\n"
                        + "   │<── DOM updates JSON ───────┤                            │\n"
                        + "   │                            │                            │\n"
                        + "   ├── WS /eventbus ────────────>│                            │\n"
                        + "   │   (STOMP subscribe)        ├── RabbitMQ exchange ────────│\n"
                        + "   │<── STOMP message ──────────┤                            │"));

        layout.add(buildSection("DATA FLOW", "Request, Event, and Message Paths",
                "HTTP for pages, AJAX for events, WebSocket for real-time.", false, content));
        getMain().add(layout);
    }
}

