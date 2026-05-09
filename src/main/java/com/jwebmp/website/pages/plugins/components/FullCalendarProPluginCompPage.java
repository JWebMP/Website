package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FullCalendarProPluginPage;
@NgComponent("jwebmp-pcomp-full-calendar-pro")
@NgRoutable(path = "plugins/fullcalendar-pro/full-calendar-pro")
public class FullCalendarProPluginCompPage extends PluginComponentPage<FullCalendarProPluginCompPage>
{
    public FullCalendarProPluginCompPage()
    {
        super("fullcalendar-pro", "FullCalendar Pro", FullCalendarProPluginPage.COMPONENTS.get(0));
    }
}

