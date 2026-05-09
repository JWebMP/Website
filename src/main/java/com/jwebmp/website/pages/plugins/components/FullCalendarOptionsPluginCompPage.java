package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FullCalendarPluginPage;
@NgComponent("jwebmp-pcomp-full-calendar-options")
@NgRoutable(path = "plugins/fullcalendar/full-calendar-options")
public class FullCalendarOptionsPluginCompPage extends PluginComponentPage<FullCalendarOptionsPluginCompPage>
{
    public FullCalendarOptionsPluginCompPage()
    {
        super("fullcalendar", "FullCalendar", FullCalendarPluginPage.COMPONENTS.get(1));
    }
}

