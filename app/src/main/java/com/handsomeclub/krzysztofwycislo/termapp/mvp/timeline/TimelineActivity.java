package com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;

import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.NavigatorActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.navigator.Navigator;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.fragment.TimelineFragment;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public class TimelineActivity extends NavigatorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        final ITimetableContract.IView timelineView = new TimelineFragment();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, (Fragment) timelineView);
        }


        ITimetableContract.IPresenter presenter = new TimelinePresenter(timelineView);

        timelineView.setPresenter(presenter);
    }

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, TimelineActivity.class);
    }

}
