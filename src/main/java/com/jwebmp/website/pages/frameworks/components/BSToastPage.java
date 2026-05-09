package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bstoast")
@NgRoutable(path = "frameworks/bootstrap/bstoast")
public class BSToastPage extends FrameworkComponentPage<BSToastPage>
{
    public BSToastPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(33));
    }
}
