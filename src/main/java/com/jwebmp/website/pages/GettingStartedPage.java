package com.jwebmp.website.pages;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.webawesome.components.PageSize;
import com.jwebmp.webawesome.components.WaStack;

@NgComponent("jwebmp-getting-started")
@NgRoutable(path = "getting-started")
public class GettingStartedPage extends WebsitePage<GettingStartedPage> implements INgComponent<GettingStartedPage>
{
    public GettingStartedPage()
    {

        var layout = new WaStack();
        layout.setGap(PageSize.ExtraLarge);
        getMain().add(layout);

        // Intro only — steps are now individual sub-pages
        var content = new WaStack();
        content.setGap(PageSize.Medium);
        content.add(bodyText(
                "This guide walks you through creating a JWebMP application from scratch. "
                + "By the end, you will have a reactive Angular 20 SPA served on a Vert.x 5 HTTP "
                + "server — built entirely from Java source files. No TypeScript. No HTML templates. "
                + "Six files total. Use the menu tree to navigate each step.",
                "m"));
        layout.add(buildSection("QUICK START",
                "Getting Started with JWebMP",
                "Zero to production Angular app in six steps.",
                false, content));
    }
}
