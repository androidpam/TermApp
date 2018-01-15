package com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator;

import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.BaseActivity;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 * Class for keeping headers. If iconImg is not provided it is by assumed -1. What means that icon's
 * visibility is gone. To make it invisibility set IconImg to 0.
 */

public class NavigatorItemModel {

    private final Class<? extends BaseActivity> intent;
    private final String name;

    // menu icon resource id
    private final int iconImg;

    NavigatorItemModel(String name, Class<? extends BaseActivity> intent, int iconImg) {
        this.intent = intent;
        this.name = name;
        this.iconImg = iconImg;
    }

    public NavigatorItemModel(String name, Class intent) {
        this.intent = intent;
        this.name = name;
        this.iconImg = -1;
    }

    public String getName() {
        return name;
    }

    int getIconImg() {
        return iconImg;
    }

    public Class<? extends BaseActivity> getIntent() {
        return intent;
    }
}
