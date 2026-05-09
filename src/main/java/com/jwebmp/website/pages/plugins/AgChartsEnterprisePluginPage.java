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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("AgCandlestickSeriesOptions", "Financial candlestick series with open/high/low/close keys",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(
                            new PluginEntry.PropertyInfo("xKey", "String", null, "Date/category key"),
                            new PluginEntry.PropertyInfo("openKey", "String", null, "Opening price key"),
                            new PluginEntry.PropertyInfo("highKey", "String", null, "High price key"),
                            new PluginEntry.PropertyInfo("lowKey", "String", null, "Low price key"),
                            new PluginEntry.PropertyInfo("closeKey", "String", null, "Closing price key")
                    ), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgWaterfallSeriesOptions", "Waterfall chart series showing cumulative values",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "Category key"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgTreemapSeriesOptions", "Hierarchical treemap series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("labelKey", "String", null, "Label key"),
                            new PluginEntry.PropertyInfo("sizeKey", "String", null, "Size value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgSunburstSeriesOptions", "Radial hierarchical sunburst series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("labelKey", "String", null, "Label key"),
                            new PluginEntry.PropertyInfo("sizeKey", "String", null, "Size value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgSankeySeriesOptions", "Flow/sankey diagram series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("fromKey", "String", null, "Source node key"),
                            new PluginEntry.PropertyInfo("toKey", "String", null, "Target node key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRangeBarSeriesOptions", "Range bar series with min/max values",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "Category key"),
                            new PluginEntry.PropertyInfo("yLowKey", "String", null, "Low value key"),
                            new PluginEntry.PropertyInfo("yHighKey", "String", null, "High value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRangeAreaSeriesOptions", "Range area series with min/max values",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "Category key"),
                            new PluginEntry.PropertyInfo("yLowKey", "String", null, "Low value key"),
                            new PluginEntry.PropertyInfo("yHighKey", "String", null, "High value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRadialColumnSeriesOptions", "Radial/polar column series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("angleKey", "String", null, "Angle key"),
                            new PluginEntry.PropertyInfo("radiusKey", "String", null, "Radius value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRadialBarSeriesOptions", "Radial/polar bar series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("angleKey", "String", null, "Angle key"),
                            new PluginEntry.PropertyInfo("radiusKey", "String", null, "Radius value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRadarLineSeriesOptions", "Radar/spider line series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("angleKey", "String", null, "Angle key"),
                            new PluginEntry.PropertyInfo("radiusKey", "String", null, "Radius value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgRadarAreaSeriesOptions", "Radar/spider area series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("angleKey", "String", null, "Angle key"),
                            new PluginEntry.PropertyInfo("radiusKey", "String", null, "Radius value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgNightingaleSeriesOptions", "Nightingale/rose chart series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("angleKey", "String", null, "Angle key"),
                            new PluginEntry.PropertyInfo("radiusKey", "String", null, "Radius value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgHistogramSeriesOptions", "Histogram series with automatic binning",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "Value key for binning")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgHeatmapSeriesOptions", "Heatmap matrix series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "X-axis key"),
                            new PluginEntry.PropertyInfo("yKey", "String", null, "Y-axis key"),
                            new PluginEntry.PropertyInfo("colorKey", "String", null, "Color value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgFunnelSeriesOptions", "Funnel chart series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("stageKey", "String", null, "Stage/label key"),
                            new PluginEntry.PropertyInfo("valueKey", "String", null, "Value key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgChordSeriesOptions", "Chord diagram series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("fromKey", "String", null, "Source key"),
                            new PluginEntry.PropertyInfo("toKey", "String", null, "Target key")), null, null, null, null, null, null),
            new PluginEntry.ComponentInfo("AgOhlcSeriesOptions", "OHLC (Open-High-Low-Close) financial series",
                    "com.jwebmp.plugins.agchartsenterprise.options.series",
                    List.of(new PluginEntry.PropertyInfo("xKey", "String", null, "Date key"),
                            new PluginEntry.PropertyInfo("openKey", "String", null, "Open price key"),
                            new PluginEntry.PropertyInfo("highKey", "String", null, "High price key"),
                            new PluginEntry.PropertyInfo("lowKey", "String", null, "Low price key"),
                            new PluginEntry.PropertyInfo("closeKey", "String", null, "Close price key")), null, null, null, null, null, null)
    );

    public AgChartsEnterprisePluginPage()
    {
        super(PluginCatalog.getById("agcharts-enterprise").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ComponentInfo> pluginComponents()
    {
        return COMPONENTS;
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
