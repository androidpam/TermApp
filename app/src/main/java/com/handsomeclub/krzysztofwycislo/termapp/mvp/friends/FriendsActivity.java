package com.handsomeclub.krzysztofwycislo.termapp.mvp.friends;

import android.app.Fragment;
import android.os.Bundle;

import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.BaseActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.NavigatorActivity;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.friends.fragment.FriendListFragment;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class FriendsActivity extends NavigatorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        final IFriendsContract.IView timelineView = new FriendListFragment();
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, (Fragment) timelineView);
        }


        IFriendsContract.IPresenter presenter = new FriendsListPresenter(timelineView);

        timelineView.setPresenter(presenter);
    }
}
