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
    public static final List<PluginEntry.ComponentInfo> COMPONENTS = List.of(
            new PluginEntry.ComponentInfo("FullCalendar", "Abstract base FullCalendar component — renders a full-size drag-and-drop calendar with WebSocket-driven events, resources, and options channels",
                    "com.jwebmp.plugins.fullcalendar",
                    List.of(
                            new PluginEntry.PropertyInfo("options", "FullCalendarOptions", null, "The calendar options object bound to [options]"),
                            new PluginEntry.PropertyInfo("eventSource", "String", null, "External event source identifier"),
                            new PluginEntry.PropertyInfo("externalEventContainerId", "String", null, "ID of the external draggable events container"),
                            new PluginEntry.PropertyInfo("dateClickEvent", "FullCalendarDateClickEvent", null, "Server-side handler for date click events"),
                            new PluginEntry.PropertyInfo("eventClickEvent", "FullCalendarEventClickEvent", null, "Server-side handler for event click events"),
                            new PluginEntry.PropertyInfo("selectEvent", "FullCalendarSelectEvent", null, "Server-side handler for date selection events"),
                            new PluginEntry.PropertyInfo("dropEvent", "FullCalendarDropEvent", null, "Server-side handler for external drop events"),
                            new PluginEntry.PropertyInfo("eventDropEvent", "FullCalendarEventDropEvent", null, "Server-side handler for event drag-drop events"),
                            new PluginEntry.PropertyInfo("receiveEvent", "FullCalendarEventReceiveEvent", null, "Server-side handler for event receive events"),
                            new PluginEntry.PropertyInfo("eventResizeEvent", "FullCalendarEventResizeEvent", null, "Server-side handler for event resize events"),
                            new PluginEntry.PropertyInfo("enableEventContentTemplate", "boolean", "false", "Enable ng-template for custom event content rendering"),
                            new PluginEntry.PropertyInfo("enableDayHeaderTemplate", "boolean", "false", "Enable ng-template for custom day header rendering"),
                            new PluginEntry.PropertyInfo("enableDayCellTemplate", "boolean", "false", "Enable ng-template for custom day cell rendering")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Calendar with Date Click",
                                    "Create a calendar with a date click handler.",
                                    "public class MyCalendar extends FullCalendar<MyCalendar> {\n    public MyCalendar() {\n        super(\"my-cal\");\n        getOptions().setInitialView(\"dayGridMonth\")\n            .setEditable(true)\n            .setHeaderToolbar(new FullCalendarHeaderToolBarOptions()\n                .setLeft(\"prev,next today\")\n                .setCenter(\"title\")\n                .setRight(\"dayGridMonth,timeGridWeek,listWeek\"));\n        setDateClickEvent(new MyDateClickHandler());\n    }\n\n    @Override\n    public FullCalendarEventsList getInitialEvents() {\n        var events = new FullCalendarEventsList();\n        events.add(new FullCalendarEvent<>()\n            .setTitle(\"Sprint Planning\")\n            .setStart(LocalDateTime.of(2026, 3, 24, 10, 0)));\n        return events;\n    }\n}",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FullCalendar(String id)", "Creates a calendar component bound to the given ID")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("getInitialEvents", "FullCalendarEventsList", "getInitialEvents()", "Override to provide initial events loaded via WebSocket"),
                            new PluginEntry.MethodInfo("getOnLoadOptions", "FullCalendarOptions", "getOnLoadOptions()", "Override to provide dynamic options loaded via WebSocket"),
                            new PluginEntry.MethodInfo("getOptions", "FullCalendarOptions", "getOptions()", "Returns the current calendar options"),
                            new PluginEntry.MethodInfo("setDateClickEvent", "J", "setDateClickEvent(FullCalendarDateClickEvent)", "Register a server-side date click handler"),
                            new PluginEntry.MethodInfo("setEventClickEvent", "J", "setEventClickEvent(FullCalendarEventClickEvent)", "Register a server-side event click handler"),
                            new PluginEntry.MethodInfo("setSelectEvent", "J", "setSelectEvent(FullCalendarSelectEvent)", "Register a server-side date select handler"),
                            new PluginEntry.MethodInfo("setDropEvent", "J", "setDropEvent(FullCalendarDropEvent)", "Register a server-side external drop handler"),
                            new PluginEntry.MethodInfo("setEventDropEvent", "J", "setEventDropEvent(FullCalendarEventDropEvent)", "Register a server-side event drag-drop handler"),
                            new PluginEntry.MethodInfo("enableAllBaseTemplates", "J", "enableAllBaseTemplates()", "Enable all base Angular ng-template slots")
                    ), null, null, null),

            new PluginEntry.ComponentInfo("FullCalendarOptions", "Root calendar options — toolbar, views, locale, sizing, time slots, date navigation, drag-and-drop, selection, event display, and resource configuration",
                    "com.jwebmp.plugins.fullcalendar.options",
                    List.of(
                            new PluginEntry.PropertyInfo("headerToolbar", "FullCalendarHeaderToolBarOptions", null, "Header toolbar layout (left/center/right sections)"),
                            new PluginEntry.PropertyInfo("footerToolbar", "FullCalendarHeaderToolBarOptions", null, "Footer toolbar layout"),
                            new PluginEntry.PropertyInfo("initialView", "String", null, "Initial view name (dayGridMonth, timeGridWeek, listWeek, etc.)"),
                            new PluginEntry.PropertyInfo("editable", "Boolean", null, "Whether events can be dragged and resized"),
                            new PluginEntry.PropertyInfo("selectable", "Boolean", null, "Whether the user can select date ranges"),
                            new PluginEntry.PropertyInfo("navLinks", "Boolean", null, "Whether day/week names can be clicked for navigation"),
                            new PluginEntry.PropertyInfo("weekends", "Boolean", "true", "Whether to include Saturday/Sunday columns"),
                            new PluginEntry.PropertyInfo("locale", "String", null, "Locale code for display (e.g. en, es, fr)"),
                            new PluginEntry.PropertyInfo("timeZone", "String", null, "IANA timezone string (e.g. America/New_York)"),
                            new PluginEntry.PropertyInfo("firstDay", "Integer", null, "First day of the week (0=Sunday, 1=Monday)"),
                            new PluginEntry.PropertyInfo("height", "String", null, "Calendar height (integer, auto, or CSS value)"),
                            new PluginEntry.PropertyInfo("contentHeight", "String", null, "View area height"),
                            new PluginEntry.PropertyInfo("aspectRatio", "Double", "1.35", "Width-to-height aspect ratio"),
                            new PluginEntry.PropertyInfo("themeSystem", "String", "standard", "Theme system: standard or bootstrap"),
                            new PluginEntry.PropertyInfo("slotDuration", "FullCalendarTimeSlot", "00:30:00", "Time slot frequency"),
                            new PluginEntry.PropertyInfo("slotMinTime", "FullCalendarTimeSlot", "00:00:00", "First time slot of day"),
                            new PluginEntry.PropertyInfo("slotMaxTime", "FullCalendarTimeSlot", "24:00:00", "Last time slot of day"),
                            new PluginEntry.PropertyInfo("nowIndicator", "Boolean", "false", "Show the current time indicator"),
                            new PluginEntry.PropertyInfo("weekNumbers", "Boolean", "false", "Display week numbers"),
                            new PluginEntry.PropertyInfo("fixedWeekCount", "Boolean", "true", "Fixed number of weeks in month view"),
                            new PluginEntry.PropertyInfo("droppable", "Boolean", "false", "Allow external droppable elements"),
                            new PluginEntry.PropertyInfo("eventDisplay", "String", "auto", "Event rendering style (auto, block, list-item, background, none)"),
                            new PluginEntry.PropertyInfo("schedulerLicenseKey", "String", null, "FullCalendar Scheduler license key for Pro features"),
                            new PluginEntry.PropertyInfo("resourceGroupField", "String", null, "Field to group resources by"),
                            new PluginEntry.PropertyInfo("resourceAreaWidth", "String", "30%", "Width of the resource area in resource views"),
                            new PluginEntry.PropertyInfo("resourceOrder", "String", null, "Field(s) to sort resources by"),
                            new PluginEntry.PropertyInfo("resourceAreaHeaderContent", "String", null, "Text content for the resource area header"),
                            new PluginEntry.PropertyInfo("datesAboveResources", "Boolean", "false", "Show date headings above resource headings")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("TimeGrid Week View",
                                    "Configure a week view with business hours and slot customization.",
                                    "new FullCalendarOptions()\n    .setInitialView(\"timeGridWeek\")\n    .setSlotDuration(new FullCalendarTimeSlot(0, 15, 0))\n    .setSlotMinTime(new FullCalendarTimeSlot(8, 0, 0))\n    .setSlotMaxTime(new FullCalendarTimeSlot(20, 0, 0))\n    .setNowIndicator(true)\n    .setWeekends(false)\n    .setEditable(true)\n    .setSelectable(true);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("Resource Timeline",
                                    "Set up a resource timeline with area columns.",
                                    "new FullCalendarOptions()\n    .setInitialView(\"resourceTimelineDay\")\n    .setSchedulerLicenseKey(\"your-key\")\n    .setResourceAreaWidth(\"25%\")\n    .setResourceAreaHeaderContent(\"Rooms\")\n    .setResourceOrder(\"title\");",
                                    "java")
                    ),
                    List.of(
                            new PluginEntry.ConstructorInfo("FullCalendarOptions()", "Creates default calendar options")
                    ),
                    List.of(
                            new PluginEntry.MethodInfo("setInitialView", "FullCalendarOptions", "setInitialView(String)", "Set the initial view by name"),
                            new PluginEntry.MethodInfo("setHeaderToolbar", "FullCalendarOptions", "setHeaderToolbar(FullCalendarHeaderToolBarOptions)", "Configure header toolbar layout"),
                            new PluginEntry.MethodInfo("setEditable", "FullCalendarOptions", "setEditable(Boolean)", "Enable/disable event editing"),
                            new PluginEntry.MethodInfo("setSelectable", "FullCalendarOptions", "setSelectable(Boolean)", "Enable/disable date selection"),
                            new PluginEntry.MethodInfo("setSlotDuration", "FullCalendarOptions", "setSlotDuration(FullCalendarTimeSlot)", "Set time slot frequency"),
                            new PluginEntry.MethodInfo("setSlotMinTime", "FullCalendarOptions", "setSlotMinTime(FullCalendarTimeSlot)", "Set first time slot"),
                            new PluginEntry.MethodInfo("setSlotMaxTime", "FullCalendarOptions", "setSlotMaxTime(FullCalendarTimeSlot)", "Set last time slot"),
                            new PluginEntry.MethodInfo("setNowIndicator", "FullCalendarOptions", "setNowIndicator(Boolean)", "Toggle current time indicator"),
                            new PluginEntry.MethodInfo("setWeekends", "FullCalendarOptions", "setWeekends(Boolean)", "Show/hide weekend columns"),
                            new PluginEntry.MethodInfo("setDroppable", "FullCalendarOptions", "setDroppable(Boolean)", "Allow external drops"),
                            new PluginEntry.MethodInfo("setEvents", "FullCalendarOptions", "setEvents(FullCalendarEventsList)", "Set the events list"),
                            new PluginEntry.MethodInfo("setViews", "FullCalendarOptions", "setViews(FullCalendarViews)", "Configure named views"),
                            new PluginEntry.MethodInfo("setBusinessHours", "FullCalendarOptions", "setBusinessHours(List&lt;FullCalendarBusinessHours&gt;)", "Configure business hours emphasis")
                    ), null, null, null),

            new PluginEntry.ComponentInfo("FullCalendarEvent", "Event object — represents a single calendar event with title, dates, colors, drag/resize behavior, and resource association",
                    "com.jwebmp.plugins.fullcalendar.options",
                    List.of(
                            new PluginEntry.PropertyInfo("id", "String", null, "Unique event identifier"),
                            new PluginEntry.PropertyInfo("title", "String", null, "Text displayed on the event element"),
                            new PluginEntry.PropertyInfo("allDay", "Boolean", null, "Whether the event is an all-day event"),
                            new PluginEntry.PropertyInfo("start", "LocalDateTime", null, "Event start date/time"),
                            new PluginEntry.PropertyInfo("end", "LocalDateTime", null, "Event end date/time (exclusive)"),
                            new PluginEntry.PropertyInfo("editable", "Boolean", null, "Override master editable for this event"),
                            new PluginEntry.PropertyInfo("startEditable", "Boolean", null, "Override master eventStartEditable"),
                            new PluginEntry.PropertyInfo("durationEditable", "Boolean", null, "Override master eventDurationEditable"),
                            new PluginEntry.PropertyInfo("resourceEditable", "Boolean", null, "Override master eventResourceEditable"),
                            new PluginEntry.PropertyInfo("color", "String", null, "Background and border color"),
                            new PluginEntry.PropertyInfo("backgroundColor", "String", null, "Background color"),
                            new PluginEntry.PropertyInfo("borderColor", "String", null, "Border color"),
                            new PluginEntry.PropertyInfo("textColor", "String", null, "Text color"),
                            new PluginEntry.PropertyInfo("classNames", "List&lt;String&gt;", null, "CSS class names attached to the event element"),
                            new PluginEntry.PropertyInfo("overlap", "Boolean", null, "Override master eventOverlap"),
                            new PluginEntry.PropertyInfo("display", "String", null, "Rendering type: auto, block, list-item, background, inverse-background, none"),
                            new PluginEntry.PropertyInfo("groupId", "String", null, "Events sharing groupId are dragged/resized together"),
                            new PluginEntry.PropertyInfo("resourceId", "List&lt;String&gt;", null, "Resource IDs this event is associated with"),
                            new PluginEntry.PropertyInfo("rendering", "FullCalendarEventRenderingOptions", null, "Alternate rendering: background or inverse-background")
                    ),
                    List.of(
                            new PluginEntry.ExampleSnippet("Create Event",
                                    "Create a timed event with color.",
                                    "new FullCalendarEvent<>()\n    .setId(\"evt-1\")\n    .setTitle(\"Team Meeting\")\n    .setStart(LocalDateTime.of(2026, 5, 10, 14, 0))\n    .setEnd(LocalDateTime.of(2026, 5, 10, 15, 30))\n    .setColor(\"#2196F3\")\n    .setEditable(true);",
                                    "java"),
                            new PluginEntry.ExampleSnippet("All-Day Event",
                                    "Create an all-day event associated with a resource.",
                                    "new FullCalendarEvent<>()\n    .setTitle(\"Conference\")\n    .setAllDay(true)\n    .setStart(LocalDateTime.of(2026, 6, 1, 0, 0))\n    .setEnd(LocalDateTime.of(2026, 6, 3, 0, 0))\n    .setResourceId(List.of(\"room-a\"))\n    .setDisplay(\"background\");",
                                    "java")
                    ),
                    null,
                    List.of(
                            new PluginEntry.MethodInfo("setId", "J", "setId(String)", "Set the event ID"),
                            new PluginEntry.MethodInfo("setTitle", "J", "setTitle(String)", "Set the event title"),
                            new PluginEntry.MethodInfo("setStart", "J", "setStart(LocalDateTime)", "Set the start date/time"),
                            new PluginEntry.MethodInfo("setEnd", "J", "setEnd(LocalDateTime)", "Set the end date/time"),
                            new PluginEntry.MethodInfo("setAllDay", "J", "setAllDay(Boolean)", "Set whether the event is all-day"),
                            new PluginEntry.MethodInfo("setColor", "J", "setColor(String)", "Set background and border color"),
                            new PluginEntry.MethodInfo("setEditable", "J", "setEditable(Boolean)", "Override editable for this event"),
                            new PluginEntry.MethodInfo("setResourceId", "J", "setResourceId(List&lt;String&gt;)", "Associate event with resources"),
                            new PluginEntry.MethodInfo("setDisplay", "J", "setDisplay(String)", "Set the display/rendering type"),
                            new PluginEntry.MethodInfo("setGroupId", "J", "setGroupId(String)", "Set the group ID for linked dragging")
                    ), null, null, null)
    );

    public FullCalendarPluginPage()
    {
        super(PluginCatalog.getById("fullcalendar").orElseThrow());
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
