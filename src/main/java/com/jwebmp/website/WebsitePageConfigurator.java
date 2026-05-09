package com.jwebmp.website;

import com.jwebmp.core.Page;
import com.jwebmp.core.base.angular.client.services.TypescriptIndexPageConfigurator;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.fontawesome5pro.FontAwesome5ProPageConfigurator;
import com.jwebmp.webawesome.components.WebAwesomePageConfigurator;

public class WebsitePageConfigurator implements IPageConfigurator<WebsitePageConfigurator>, TypescriptIndexPageConfigurator<WebsitePageConfigurator>
{
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        WebAwesomePageConfigurator.setWaKitCode("fad4033d8cb94cc4");
        FontAwesome5ProPageConfigurator.setKitCode("cf4534f35c");
        page.addCssReference(new CSSReference("JWebMPBase", 1.0, "/base.css"));
        page.addCssReference(new CSSReference("JWebMPLayout", 1.0, "/layout.css"));
        page.addCssReference(new CSSReference("JWebMPComponents", 1.0, "/components.css"));
        page.addCssReference(new CSSReference("JWebMPFeatures", 1.0, "/features.css"));
        page.addCssReference(new CSSReference("JWebMPCode", 1.0, "/code.css"));
        Page<?> p = (Page<?>) page;
        p.getOptions().setFavIcon("/jwebmp-logo-green-full.svg");
        p.getOptions().setIcon("/jwebmp-logo-green-full.svg", "any");
        return page;
    }

    @Override
    public IPage<?> configureAngular(IPage<?> page) {
        return configure(page);
    }

    @Override
    public boolean enabled()
    {
        return true;
    }

    @Override
    public Integer sortOrder()
    {
        return 200;
    }
}

