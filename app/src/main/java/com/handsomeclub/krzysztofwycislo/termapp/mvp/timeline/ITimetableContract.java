package com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline;

import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBaseView;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public interface ITimetableContract {

    interface IView extends IBaseView{

        void initializeWeekView();

    }

    interface IPresenter extends IBasePresenter{

        void initializeTimetable();

        void addEvent();

    }
}
