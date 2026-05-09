package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.JQueryUIPluginPage;
@NgComponent("jwebmp-pcomp-jquiaccordion")
@NgRoutable(path = "plugins/jquery-ui/jquiaccordion")
public class JQUIAccordionPluginCompPage extends PluginComponentPage<JQUIAccordionPluginCompPage>
{
    public JQUIAccordionPluginCompPage()
    {
        super("jquery-ui", "jQuery UI", JQueryUIPluginPage.COMPONENTS.get(0));
    }
}
