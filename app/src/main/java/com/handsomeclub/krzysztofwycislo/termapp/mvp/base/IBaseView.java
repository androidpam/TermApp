package com.handsomeclub.krzysztofwycislo.termapp.mvp.base;


import com.handsomeclub.krzysztofwycislo.termapp.data.Communicate;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public interface IBaseView {

    void setPresenter(IBasePresenter presenter);

    void showCommunicate(Communicate communicate);
}
