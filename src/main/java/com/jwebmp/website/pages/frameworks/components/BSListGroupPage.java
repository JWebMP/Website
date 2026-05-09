package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bslist-group")
@NgRoutable(path = "frameworks/bootstrap/bslist-group")
public class BSListGroupPage extends FrameworkComponentPage<BSListGroupPage>
{
    public BSListGroupPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(21));
    }
}
