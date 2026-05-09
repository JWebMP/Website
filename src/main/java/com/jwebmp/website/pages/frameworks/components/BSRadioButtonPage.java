package com.jwebmp.website.pages.frameworks.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.frameworks.FrameworkComponentPage;
import com.jwebmp.website.pages.frameworks.BootstrapFrameworkPage;
@NgComponent("jwebmp-comp-bsradio-button")
@NgRoutable(path = "frameworks/bootstrap/bsradio-button")
public class BSRadioButtonPage extends FrameworkComponentPage<BSRadioButtonPage>
{
    public BSRadioButtonPage()
    {
        super("bootstrap", "Bootstrap", BootstrapFrameworkPage.COMPONENTS.get(7));
    }
}
