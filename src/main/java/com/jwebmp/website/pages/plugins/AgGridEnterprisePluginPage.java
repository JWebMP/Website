package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-aggrid-ent")
@NgRoutable(path = "plugins/aggrid-enterprise")
public class AgGridEnterprisePluginPage extends PluginDetailPage<AgGridEnterprisePluginPage>
{
    public AgGridEnterprisePluginPage()
    {
        super(PluginCatalog.getById("aggrid-enterprise").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Enterprise Grid Setup",
                        "Set license key and configure enterprise features.",
                        "// Set license key at startup\nAgGridEnterprisePageConfigurator\n    .setAG_GRID_LICENSE_KEY(\"YOUR_LICENSE_KEY\");\n\n// Server-side row model (millions of rows)\ngridOptions.setRowModelType(RowModelType.SERVER_SIDE)\n    .setServerSideInitialRowCount(1000);\n\n// Row grouping and aggregation\ngridOptions.setRowGroupPanelShow(RowGroupPanelShow.ALWAYS)\n    .addRowGroupColumn(\"region\")\n    .addValueColumn(\"revenue\");",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "AgGridEnterprisePageConfigurator auto-registers AllEnterpriseModule, license key, and enterprise CSS/JS")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("AG_GRID_LICENSE_KEY", "String", null, "AG Grid Enterprise license key — set via AgGridEnterprisePageConfigurator.setAG_GRID_LICENSE_KEY()")
        );
    }
}
