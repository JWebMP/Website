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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("FullCalendarPro", "Pro extension of FullCalendar — adds resource timeline, resource day grid, resource time grid, adaptive plugin, and WebSocket-driven resource channels",
                    "com.jwebmp.plugins.fullcalendarpro",
                    List.of(
                            new PluginEntry.PropertyInfo("enableResourceLabelTemplate", "boolean", "false", "Enable ng-template for custom resource label rendering"),
                            new PluginEntry.PropertyInfo("enableResourceAreaHeaderTemplate", "boolean", "false", "Enable ng-template for custom resource area header"),
                            new PluginEntry.PropertyInfo("enableResourceAreaColumnTemplates", "boolean", "false", "Enable ng-templates for resource area column header and cell")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Resource Timeline Calendar",
                                    "Create a resource timeline with rooms and events.",
                                    "public class RoomCalendar extends FullCalendarPro<RoomCalendar> {\n    public RoomCalendar() {\n        super(\"room-cal\");\n        getOptions()\n            .setInitialView(\"resourceTimelineDay\")\n            .setSchedulerLicenseKey(\"your-key\")\n            .setResourceAreaHeaderContent(\"Rooms\")\n            .setResourceAreaWidth(\"20%\");\n    }\n\n    @Override\n    public FullCalendarResourceItemsList getInitialResources() {\n        var resources = new FullCalendarResourceItemsList();\n        resources.add(new FullCalendarResourceItem().setId(\"r1\").setTitle(\"Room A\"));\n        resources.add(new FullCalendarResourceItem().setId(\"r2\").setTitle(\"Room B\"));\n        return resources;\n    }\n\n    @Override\n    public FullCalendarEventsList getInitialEvents() {\n        var events = new FullCalendarEventsList();\n        events.add(new FullCalendarEvent<>()\n            .setTitle(\"Meeting\")\n            .setResourceId(List.of(\"r1\"))\n            .setStart(LocalDateTime.of(2026, 5, 10, 9, 0))\n            .setEnd(LocalDateTime.of(2026, 5, 10, 10, 30)));\n        return events;\n    }\n}",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FullCalendarPro(String id)", "Creates a Pro calendar component bound to the given ID")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getInitialResources", "FullCalendarResourceItemsList", "getInitialResources()", "Override to provide initial resources loaded via WebSocket"),
                            new PluginEntry.MethodInfo("enableAllProTemplates", "J", "enableAllProTemplates()", "Enable all Pro-specific Angular ng-template slots"),
                            new PluginEntry.MethodInfo("setEnableResourceLabelTemplate", "J", "setEnableResourceLabelTemplate(boolean)", "Toggle resource label template"),
                            new PluginEntry.MethodInfo("setEnableResourceAreaHeaderTemplate", "J", "setEnableResourceAreaHeaderTemplate(boolean)", "Toggle resource area header template"),
                            new PluginEntry.MethodInfo("setEnableResourceAreaColumnTemplates", "J", "setEnableResourceAreaColumnTemplates(boolean)", "Toggle resource area column templates")
                    ), null, null, null)
    );

    public FullCalendarProPluginPage()
    {
        super(PluginCatalog.getById("fullcalendar-pro").orElseThrow());
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
