package com.jwebmp.website.pages.plugins.components;
import com.jwebmp.core.base.angular.client.annotations.angular.NgComponent;
import com.jwebmp.core.base.angular.client.annotations.routing.NgRoutable;
import com.jwebmp.website.pages.plugins.PluginComponentPage;
import com.jwebmp.website.pages.plugins.FullCalendarPluginPage;
@NgComponent("jwebmp-pcomp-full-calendar")
@NgRoutable(path = "plugins/fullcalendar/full-calendar")
public class FullCalendarPluginCompPage extends PluginComponentPage<FullCalendarPluginCompPage>
{
    public FullCalendarPluginCompPage()
    {
        super("fullcalendar", "FullCalendar", FullCalendarPluginPage.COMPONENTS.get(0));
    }
}

