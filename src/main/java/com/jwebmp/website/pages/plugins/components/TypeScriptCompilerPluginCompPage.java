package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.AngularPluginPage;
@NgComponent("jwebmp-pcomp-type-script-compiler")
@NgRoutable(path = "plugins/angular/type-script-compiler")
public class TypeScriptCompilerPluginCompPage extends PluginComponentPage<TypeScriptCompilerPluginCompPage>
{
    public TypeScriptCompilerPluginCompPage()
    {
        super("angular", "Angular", AngularPluginPage.COMPONENTS.get(5));
    }
}
