package com.jwebmp.website.pages.plugins;

import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.catalog.PluginCatalog;
import com.jwebmp.website.catalog.PluginEntry;

import java.util.List;

@NgComponent("jwebmp-plugin-fullcalendar")
@NgRoutable(path = "plugins/fullcalendar")
public class FullCalendarPluginPage extends PluginDetailPage<FullCalendarPluginPage>
{
    public FullCalendarPluginPage()
    {
        super(PluginCatalog.getById("fullcalendar").orElseThrow());
    }

    @Override
    protected List<PluginEntry.ExampleSnippet> pluginExamples()
    {
        return List.of(
                new PluginEntry.ExampleSnippet("Calendar with Events",
                        "Create a month-view calendar with drag-and-drop events.",
                        "FullCalendarOptions options = new FullCalendarOptions()\n    .setInitialView(\"dayGridMonth\")\n    .setEditable(true)\n    .setHeaderToolbar(new Toolbar()\n        .setLeft(\"prev,next today\")\n        .setCenter(\"title\")\n        .setRight(\"dayGridMonth,timeGridWeek,listWeek\"))\n    .addEvent(new Event()\n        .setTitle(\"Sprint Planning\")\n        .setStart(\"2026-03-24T10:00:00\")\n        .setEnd(\"2026-03-24T11:30:00\"));",
                        "java")
        );
    }

    @Override
    protected List<PluginEntry.SpiDetail> pluginSpiDetails()
    {
        return List.of(
                new PluginEntry.SpiDetail("IPageConfigurator", "provides", "FullCalendarPageConfigurator auto-registers FullCalendar CSS/JS and Angular integration")
        );
    }
}
