package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.Variant;
import com.jwebmp.webawesome.components.WaCluster;
import com.jwebmp.webawesome.components.WaStack;

@NgComponent("jwebmp-real-time")
@NgRoutable(path = "real-time")
public class RealTimePage extends WebsitePage<RealTimePage> implements INgComponent<RealTimePage>
{
    public RealTimePage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro only — sub-sections are now individual pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);

        content.add(bodyText(
                "JWebMP supports multiple client-server communication patterns — from traditional REST "
                + "endpoints and server-driven AJAX events, through typed Angular data services, to "
                + "real-time WebSocket messaging. You choose the right tool for each interaction. "
                + "REST and AJAX work out of the box. Real-time is there when you need it. "
                + "Explore each pattern via the menu tree.",
                "l"));

        var tags = new WaCluster<>();
        tags.setGap(PageSize.Small);
        tags.add(buildTag("REST / Jakarta RS", Variant.Brand));
        tags.add(buildTag("AJAX Events", Variant.Success));
        tags.add(buildTag("Data Services", Variant.Neutral));
        tags.add(buildTag("Vert.x Event Bus", Variant.Warning));
        tags.add(buildTag("RabbitMQ", Variant.Danger));
        content.add(tags);

        layout.add(buildSection("CLIENT-SERVER COMMUNICATION",
                "REST, Events, Data Services, and Real-Time",
                "Multiple patterns. Pick what fits. Layer them as you grow.",
                false, content));
    }
}
