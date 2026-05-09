package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bsnav-bar")
@NgRoutable(path = "frameworks/bootstrap/bsnav-bar")
public class BSNavBarPage extends FrameworkComponentPage<BSNavBarPage>
{
    public BSNavBarPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(24));
    }
}
