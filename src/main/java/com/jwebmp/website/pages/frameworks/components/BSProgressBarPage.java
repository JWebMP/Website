package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bsprogress-bar")
@NgRoutable(path = "frameworks/bootstrap/bsprogress-bar")
public class BSProgressBarPage extends FrameworkComponentPage<BSProgressBarPage>
{
    public BSProgressBarPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(28));
    }
}
