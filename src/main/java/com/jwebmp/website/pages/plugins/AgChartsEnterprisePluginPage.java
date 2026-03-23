package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-agcharts-ent")
@NgRoutable(path = "plugins/agcharts-enterprise")
public class AgChartsEnterprisePluginPage extends PluginDetailPage<AgChartsEnterprisePluginPage>
{
    public AgChartsEnterprisePluginPage()
    {
        super(PluginCatalog.getById("agcharts-enterprise").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Radial Gauge",
                        "Create a radial gauge with min/max scale.",
                        "AgChartsEnterprisePageConfigurator\n    .setAG_CHARTS_LICENSE_KEY(\"YOUR_KEY\");\n\n@NgComponent\npublic class DashboardGauge\n        implements INgComponent<DashboardGauge> {\n    public AgRadialGaugeOptions<DashboardGauge> gauge() {\n        return new AgRadialGaugeOptions<>(this)\n            .setValue(75.0)\n            .setScale(new AgGaugeScale()\n                .setMin(0).setMax(100));\n    }\n}",
                        "java"),
                new PluginEntry.ExampleSnippet("Candlestick Chart",
                        "Create a financial candlestick chart.",
                        "var chart = new AgCandlestickChart<>();\nchart.getOptions()\n    .setSeries(List.of(\n        new AgCandlestickSeriesOptions<>()\n            .setXKey(\"date\")\n            .setOpenKey(\"open\")\n            .setHighKey(\"high\")\n            .setLowKey(\"low\")\n            .setCloseKey(\"close\")\n    ));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "AgChartsEnterprisePageConfigurator auto-registers ag-charts-enterprise module and license key")
        );
    }

    @Override
    protected List<PluginEntry.ConfigEntry> pluginConfigurations()
    {
        return List.of(
                new PluginEntry.ConfigEntry("AG_CHARTS_LICENSE_KEY", "String", null, "AG Charts Enterprise license key — set via AgChartsEnterprisePageConfigurator.setAG_CHARTS_LICENSE_KEY()")
        );
    }
}
