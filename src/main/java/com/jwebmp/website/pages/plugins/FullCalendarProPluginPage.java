package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fullcalendar-pro")
@NgRoutable(path = "plugins/fullcalendar-pro")
public class FullCalendarProPluginPage extends PluginDetailPage<FullCalendarProPluginPage>
{
    public FullCalendarProPluginPage()
    {
        super(PluginCatalog.getById("fullcalendar-pro").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Resource Timeline",
                        "Create a resource timeline with multiple rooms and events.",
                        "FullCalendarOptions options = new FullCalendarOptions()\n    .setInitialView(\"resourceTimelineDay\")\n    .setResourceAreaHeaderContent(\"Resources\")\n    .setResources(List.of(\n        new Resource().setId(\"r1\").setTitle(\"Room A\"),\n        new Resource().setId(\"r2\").setTitle(\"Room B\")\n    ))\n    .addEvent(new Event()\n        .setTitle(\"Meeting\")\n        .setResourceId(\"r1\")\n        .setStart(\"2026-03-24T09:00\")\n        .setEnd(\"2026-03-24T10:30\"));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FullCalendarProPageConfigurator registers resource timeline, resource grid, and adaptive plugins")
        );
    }
}
