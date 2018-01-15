package com.handsomeclub.krzysztofwycislo.termapp.mvp.friends.fragment;

import android.app.Fragment;
import android.widget.Toast;

import com.handsomeclub.krzysztofwycislo.termapp.data.Communicate;
import com.handsomeclub.krzysztofwycislo.termapp.data.User;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.friends.IFriendsContract;

import java.util.List;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class FriendListFragment extends Fragment implements IFriendsContract.IView {

    private IFriendsContract.IPresenter presenter;


    @Override
    public void setPresenter(IBasePresenter presenter) {
        this.presenter = (IFriendsContract.IPresenter) presenter;

    }

    @Override
    public void showCommunicate(Communicate communicate) {
        Toast.makeText(getActivity(), communicate.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initializeUsers(List<User> user) {
        List<User> users = presenter.getFrindsList();
    }
}
