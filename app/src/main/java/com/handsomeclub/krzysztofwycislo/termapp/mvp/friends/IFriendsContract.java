package com.handsomeclub.krzysztofwycislo.termapp.mvp.friends;

import com.handsomeclub.krzysztofwycislo.termapp.data.User;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBaseView;

import java.util.List;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public interface IFriendsContract {

    interface IView extends IBaseView {

        void initializeUsers(List<User> user);

    }

    interface IPresenter extends IBasePresenter {

        List<User> getFrindsList();

    }
}
