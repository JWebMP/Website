package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.CorePluginPage;
@NgComponent("jwebmp-pcomp-table")
@NgRoutable(path = "plugins/core/table")
public class TablePluginCompPage extends PluginComponentPage<TablePluginCompPage>
{
    public TablePluginCompPage()
    {
        super("core", "Core", CorePluginPage.COMPONENTS.get(3));
    }
}
