package com.jwebmp.website;

import com.jwebmp.core.base.angular.client.annotations.angular.NgApp;
import com.jwebmp.core.base.angular.services.NGApplication;
import com.jwebmp.webawesome.components.WebAwesomePageConfigurator;

@NgApp(value = "jwebmp-website", bootComponent = WebsiteBoot.class)
public class WebsiteApplication extends NGApplication<WebsiteApplication>
{
    public WebsiteApplication()
    {
        getOptions().setTitle("JWebMP — Type-Safe Web Components in Java");
    }

}
