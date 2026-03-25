package com.jwebmp.website.pages.home;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.base.html.Link;
import com.jwebmp.webawesome.components.text.WaText;

/**
 * Aside component for the Home page.
 * <p>
 * Renders "On this page" anchor links in the named "aside" router-outlet
 * of the WaPage shell, rather than being inlined inside the main content area.
 */
@NgComponent("jwebmp-home-aside")
@NgRoutable(path = "home", outlet = "aside")
public class HomeAsidePage extends DivSimple<HomeAsidePage> implements INgComponent<HomeAsidePage>
{
    public HomeAsidePage()
    {
        setTag("aside");
        addClass("home-aside");
        addStyle("position:sticky");
        addStyle("top:var(--wa-spacing-large)");
        addStyle("padding:var(--wa-spacing-large)");
        addStyle("min-width:14rem");

        var heading = new WaText<>();
        heading.setTag("div");
        heading.setWaCaption("s");
        heading.setWaFontWeight("semibold");
        heading.setText("On this page");
        add(heading);

        var list = new DivSimple<>();
        list.setTag("ul");
        list.addStyle("list-style:none");
        list.addStyle("padding:0");
        list.addStyle("margin:var(--wa-spacing-small) 0 0 0");
        list.addStyle("display:flex");
        list.addStyle("flex-direction:column");
        list.addStyle("gap:var(--wa-spacing-x-small)");

        list.add(asideLink("hero", "Overview"));
        list.add(asideLink("why-jwebmp", "Why JWebMP"));
        list.add(asideLink("annotation-driven", "Annotation-Driven"));
        list.add(asideLink("reactive-stack", "Reactive Stack"));
        list.add(asideLink("real-time-overview", "Real-Time Overview"));
        list.add(asideLink("component-ecosystem", "Component Ecosystem"));
        list.add(asideLink("developer-experience", "Developer Experience"));
        list.add(asideLink("production-ready", "Production Ready"));

        add(list);
    }

    private DivSimple<?> asideLink(String anchorId, String label)
    {
        var li = new DivSimple<>();
        li.setTag("li");

        var link = new Link<>();
        link.setTag("a");
        link.addAttribute("href", "javascript:void(0)");
        link.addAttribute("onclick",
                "document.getElementById('" + anchorId + "').scrollIntoView({behavior:'smooth'})");
        link.setText(label);
        li.add(link);

        return li;
    }
}

