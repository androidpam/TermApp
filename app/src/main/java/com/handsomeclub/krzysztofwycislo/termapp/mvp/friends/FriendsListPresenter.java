package com.handsomeclub.krzysztofwycislo.termapp.mvp.friends;

import com.handsomeclub.krzysztofwycislo.termapp.data.User;

import java.util.List;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class FriendsListPresenter implements IFriendsContract.IPresenter{

    private final IFriendsContract.IView friendsListView;

    public FriendsListPresenter(IFriendsContract.IView friendsListView) {
        this.friendsListView = friendsListView;
    }

    @Override
    public List<User> getFrindsList() {
        return null;
    }
}
