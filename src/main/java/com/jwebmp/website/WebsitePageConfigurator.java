package com.jwebmp.website;

import com.jwebmp.core.base.angular.client.services.TypescriptIndexPageConfigurator;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.webawesome.components.WebAwesomePageConfigurator;

public class WebsitePageConfigurator implements IPageConfigurator<WebsitePageConfigurator>, TypescriptIndexPageConfigurator<WebsitePageConfigurator>
{
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        WebAwesomePageConfigurator.setWaKitCode("fad4033d8cb94cc4");
        page.getBody().addClass("wa-dark");
        page.addCssReference(new CSSReference("JWebMPLanding", 1.0, "/jwebmp-landing.css"));
        return page;
    }

    @Override
    public IPage<?> configureAngular(IPage<?> page) {
        return IPageConfigurator.super.configureAngular(page);
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

