package com.handsomeclub.krzysztofwycislo.termapp.mvp.timeline;

/**
 * Created by KrzysztofWycislo on 1/14/2018.
 *
 */

class TimelinePresenter implements ITimetableContract.IPresenter {

    private final ITimetableContract.IView timelineView;

    TimelinePresenter(ITimetableContract.IView timelineView) {
        this.timelineView = timelineView;
    }

    @Override
    public void initializeTimetable() {

    }

    @Override
    public void addEvent() {

    }

    public ITimetableContract.IView getTimelineView() {
        return timelineView;
    }
}
