package com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator;

import com.handsomeclub.krzysztofwycislo.termapp.mvp.friends.FriendsActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.TimelineActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public class NavigatorConfiguration {

    private static final Config config = createConfig();

    private static Config createConfig(){
        List<NavigatorItemModel> navigatorItems = new ArrayList<>();

        NavigatorItemModel item = new NavigatorItemModel("TimeLine", TimelineActivity.class, android.R.drawable.toast_frame);
        navigatorItems.add(item);

        item = new NavigatorItemModel("Friends List", FriendsActivity.class, android.R.drawable.ic_menu_info_details);
        navigatorItems.add(item);

        return new Config(navigatorItems);
    }

    public static Config getConfig() {
        return config;
    }

    public static class Config {
        private static List<NavigatorItemModel> navigatorItems = new ArrayList<>();

        private Config(List<NavigatorItemModel> listDataHeader) {
            Config.navigatorItems = listDataHeader;
        }

        public List<NavigatorItemModel> getNavigatorItems() {
            return navigatorItems;
        }

    }
}
