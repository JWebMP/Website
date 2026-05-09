package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bscheck-box")
@NgRoutable(path = "frameworks/bootstrap/bscheck-box")
public class BSCheckBoxPage extends FrameworkComponentPage<BSCheckBoxPage>
{
    public BSCheckBoxPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(6));
    }
}
