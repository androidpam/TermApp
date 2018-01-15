package com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.fragment;

import android.app.Fragment;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alamkanak.weekview.MonthLoader;
import com.alamkanak.weekview.WeekView;
import com.alamkanak.weekview.WeekViewEvent;
import com.handsomeclub.krzysztofwycislo.termapp.R;
import com.handsomeclub.krzysztofwycislo.termapp.data.Communicate;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.base.IBasePresenter;
import com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline.ITimetableContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

public class TimelineFragment extends Fragment implements ITimetableContract.IView {


    @BindView(R.id.weekView)
    WeekView mWeekView;

    private ITimetableContract.IPresenter presenter;


    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_timeline, container, false);
        ButterKnife.bind(this, fragmentView);

        initializeWeekView();

        return fragmentView;
    }

    public void initializeWeekView() {

        // The week view has infinite scrolling horizontally. We have to provide the list of a
        // month every time the month changes on the week view.
        MonthLoader.MonthChangeListener mMonthChangeListener = new MonthLoader.MonthChangeListener() {
            @Override
            public List<WeekViewEvent> onMonthChange(int newYear, int newMonth) {
                // Populate the week view with some list.
                return getList(newYear, newMonth);
            }
        };

        mWeekView.setMonthChangeListener(mMonthChangeListener);


        WeekView.EventClickListener onClickListener =  new WeekView.EventClickListener() {
            @Override
            public void onEventClick(WeekViewEvent event, RectF eventRect) {
                Toast.makeText(getActivity(), event.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        // Set an action when any event is clicked.
        mWeekView.setOnEventClickListener(onClickListener);

        // Set long press listener for list.
        mWeekView.setEventLongPressListener(null);
    }

    private List<WeekViewEvent> getList(int newYear, int newMonth) {
        System.out.println(newYear + "    " + newMonth);
        List<WeekViewEvent> list = new ArrayList<>();

        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        Calendar endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        WeekViewEvent event = new WeekViewEvent(10, "111111", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 4);
        endTime.set(Calendar.MINUTE, 30);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(10, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 4);
        startTime.set(Calendar.MINUTE, 20);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.set(Calendar.HOUR_OF_DAY, 5);
        endTime.set(Calendar.MINUTE, 0);
        event = new WeekViewEvent(10, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 30);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 2);
        endTime.set(Calendar.MONTH, newMonth-1);
        event = new WeekViewEvent(2, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 5);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        startTime.add(Calendar.DATE, 1);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        endTime.set(Calendar.MONTH, newMonth - 1);
        event = new WeekViewEvent(3, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 15);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(4, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, 1);
        startTime.set(Calendar.HOUR_OF_DAY, 3);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        startTime = Calendar.getInstance();
        startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH));
        startTime.set(Calendar.HOUR_OF_DAY, 15);
        startTime.set(Calendar.MINUTE, 0);
        startTime.set(Calendar.MONTH, newMonth-1);
        startTime.set(Calendar.YEAR, newYear);
        endTime = (Calendar) startTime.clone();
        endTime.add(Calendar.HOUR_OF_DAY, 3);
        event = new WeekViewEvent(5, "XDDDD", startTime, endTime);
        event.setColor(getResources().getColor(R.color.colorPrimaryDark));
        list.add(event);

        return list;
    }

    @Override
    public void setPresenter(IBasePresenter presenter) {
        this.presenter = (ITimetableContract.IPresenter) presenter;

    }

    @Override
    public void showCommunicate(Communicate communicate) {

    }
}
