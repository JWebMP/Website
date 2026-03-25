package com.jwebmp.website;

import com.jwebmp.webawesome.components.icon.IconFamily;
import com.jwebmp.webawesome.components.icon.IconVariant;
import com.jwebmp.webawesome.components.icon.WaIcon;

public class Icon extends WaIcon<Icon> {
    public Icon() {
        setFamily(IconFamily.Jelly_Duo.toString());
    }

    public Icon(String iconName) {
        super(iconName);
        setFamily(IconFamily.Jelly_Duo.toString());
    }

    public Icon(String iconName, String family) {
        super(iconName, family);
        setFamily(IconFamily.Jelly_Duo.toString());
    }

    public Icon(String iconName, String family, IconVariant variant) {
        super(iconName, family, variant);
        setFamily(IconFamily.Jelly_Duo.toString());
    }
}
