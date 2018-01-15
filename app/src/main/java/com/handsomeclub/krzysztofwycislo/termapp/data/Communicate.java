package com.handsomeclub.krzysztofwycislo.termapp.data;

/**
 * Created by KrzysztofWycislo on 1/7/2018.
 *
 */

public enum Communicate {

    API_ERROR(CommunicateType.ERROR, "ApiError"),
    SOME_INFO(CommunicateType.INFO, "someInfo");

    Communicate(CommunicateType error, String apiError) {
    }
}
