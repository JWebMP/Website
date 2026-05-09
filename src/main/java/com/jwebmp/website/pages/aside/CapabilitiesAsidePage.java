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
 * Aside component for the Capabilities page.
 * Renders navigation links to each capability sub-page.
 */
@NgComponent("jwebmp-capabilities-aside")
@NgRoutable(path = "capabilities", outlet = "aside")
@NgImportReference(value = "Router", reference = "@angular/router")
@NgImportReference(value = "inject", reference = "@angular/core")
public class CapabilitiesAsidePage extends DivSimple<CapabilitiesAsidePage> implements INgComponent<CapabilitiesAsidePage>
{
    public CapabilitiesAsidePage()
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
        heading.setText("Capabilities");
        add(heading);

        var list = new DivSimple<>();
        list.setTag("ul");
        list.addStyle("list-style:none");
        list.addStyle("padding:0");
        list.addStyle("margin:var(--wa-spacing-small) 0 0 0");
        list.addStyle("display:flex");
        list.addStyle("flex-direction:column");
        list.addStyle("gap:var(--wa-spacing-x-small)");

        list.add(asideLink("capabilities", "Overview"));
        list.add(asideLink("capabilities/angular-generation", "Angular Generation"));
        list.add(asideLink("capabilities/rendering", "Rendering"));
        list.add(asideLink("capabilities/event-system", "Event System"));
        list.add(asideLink("capabilities/plugin-model", "Plugin Model"));
        list.add(asideLink("capabilities/real-time-messaging", "Real-Time Messaging"));
        list.add(asideLink("capabilities/spi-extensibility", "SPI Extensibility"));

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

