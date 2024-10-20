package com.morioucho.lifedexv2.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
@Setter
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
}
