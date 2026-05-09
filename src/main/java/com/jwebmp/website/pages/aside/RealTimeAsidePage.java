package com.jwebmp.website.pages.aside;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.webawesome.components.text.WaText;

import java.util.ArrayList;
import java.util.List;

/**
 * Aside component for the Real-Time &amp; Data page.
 * Renders navigation links to each communication sub-page.
 */
@NgComponent("jwebmp-real-time-aside")
@NgRoutable(path = "real-time", outlet = "aside")
@NgImportReference(value = "Router", reference = "@angular/router")
@NgImportReference(value = "inject", reference = "@angular/core")
public class RealTimeAsidePage extends DivSimple<RealTimeAsidePage> implements INgComponent<RealTimeAsidePage>
{
    public RealTimeAsidePage()
    {
        setTag("aside");
        addClass("page-aside");
        addStyle("position:sticky");
        addStyle("top:var(--wa-spacing-large)");
        addStyle("padding:0 var(--wa-spacing-large) var(--wa-spacing-large) var(--wa-spacing-large)");
        addStyle("min-width:14rem");

        var heading = new WaText<>();
        heading.setTag("div");
        heading.setWaCaption("s");
        heading.setWaFontWeight("semibold");
        heading.addClass("hero-eyebrow");
        heading.setText("Real-Time & Data");
        add(heading);

        var list = new DivSimple<>();
        list.setTag("ul");
        list.addStyle("list-style:none");
        list.addStyle("padding:0");
        list.addStyle("margin:var(--wa-spacing-small) 0 0 0");
        list.addStyle("display:flex");
        list.addStyle("flex-direction:column");
        list.addStyle("gap:var(--wa-spacing-x-small)");

        list.add(asideLink("real-time", "Overview"));
        list.add(asideLink("real-time/communication-layers", "Communication Layers"));
        list.add(asideLink("real-time/rest-and-ajax", "REST & AJAX"));
        list.add(asideLink("real-time/data-services", "Data Services"));
        list.add(asideLink("real-time/vertx-event-bus", "Vert.x Event Bus"));
        list.add(asideLink("real-time/vertx-code-samples", "Vert.x Code Samples"));
        list.add(asideLink("real-time/rabbitmq", "RabbitMQ"));
        list.add(asideLink("real-time/rabbitmq-code-samples", "RabbitMQ Code Samples"));
        list.add(asideLink("real-time/use-cases", "Use Cases"));
        list.add(asideLink("real-time/choosing-a-pattern", "Choosing a Pattern"));

        add(list);
    }

    private DivSimple<?> asideLink(String route, String label)
    {
        var li = new DivSimple<>();
        li.setTag("li");

        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", "javascript:void(0)");
        link.addAttribute("(click)", "navigateTo('" + route + "')");
        link.setText(label);
        link.addStyle("cursor", "pointer");
        li.add(link);

        return li;
    }

    @Override
    public List<String> fields()
    {
        var f = new ArrayList<>(INgComponent.super.fields());
        f.add("private router: Router = inject(Router);");
        return f;
    }

    @Override
    public List<String> methods()
    {
        var m = new ArrayList<String>();
        m.add("""
                navigateTo(route: string) {
                    this.router.navigate(['/' + route]);
                }
                """);
        return m;
    }
}

