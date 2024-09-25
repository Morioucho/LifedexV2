package com.morioucho.lifedexv2.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ViewStatistic {
    private long allTimeViews;
    private long weeklyViews;
    private long dailyViews;

    private ZonedDateTime currentDateEnd;
    private ZonedDateTime currentWeekEnd;

    public ViewStatistic(){
        ZoneId zoneId = ZoneId.of("America/Los_Angeles") ;
        LocalDate today = LocalDate.now(zoneId) ;

        this.currentDateEnd = today.plusDays(1).atStartOfDay(zoneId);
        this.currentWeekEnd = today.plusDays(7).atStartOfDay(zoneId);
    }

    public void view(LocalDateTime time){
        checkViewClears(time.atZone(ZoneId.of("America/Los_Angeles")));

        dailyViews++;
        weeklyViews++;
        allTimeViews++;
    }

    public void view(){
        checkViewClears(ZonedDateTime.now());

        dailyViews++;
        weeklyViews++;
        allTimeViews++;
    }

    private void checkViewClears(ZonedDateTime now){
        if(now.isAfter(currentWeekEnd)){
            currentWeekEnd = currentWeekEnd.plusDays(7);
            currentDateEnd = currentDateEnd.plusDays(1);

            this.weeklyViews = 0;
            this.dailyViews = 0;

            return;
        }

        if(now.isAfter(currentDateEnd)){
            currentDateEnd = currentDateEnd.plusDays(1);

            this.dailyViews = 0;
        }
    }

    public long getAllTimeViews() {
        return allTimeViews;
    }

    public void setAllTimeViews(long allTimeViews) {
        this.allTimeViews = allTimeViews;
    }

    public long getWeeklyViews() {
        return weeklyViews;
    }

    public void setWeeklyViews(long weeklyViews) {
        this.weeklyViews = weeklyViews;
    }

    public long getDailyViews() {
        return dailyViews;
    }

    public void setDailyViews(long dailyViews) {
        this.dailyViews = dailyViews;
    }
}
