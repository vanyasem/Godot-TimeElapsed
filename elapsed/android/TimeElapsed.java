package org.godotengine.godot;

import android.app.Activity;

public class TimeElapsed extends Godot.SingletonBase {

    static public Godot.SingletonBase initialize(Activity pActivity) {
        return new TimeElapsed(pActivity);
    }

    public TimeElapsed(Activity pActivity) {
        //register class name and functions to bind
        registerClass("TimeElapsed", new String[] {
                "getNanoTimeInSeconds", "getNanoTimeInMinutes", "getNanoTimeInHours",
                "getDifferenceSeconds", "getDifferenceMinutes", "getDifferenceHours"
        });
    }

    private long getNanoTime() {
        return System.nanoTime();
    }


    public int getNanoTimeInSeconds() {
        return (int) (getNanoTime() / 1000000000L);
    }

    public int getNanoTimeInMinutes() {
        return (int) (getNanoTime() / 60000000000L);
    }

    public int getNanoTimeInHours() {
        return (int) (getNanoTime() / 3600000000000L);
    }


    public int getDifferenceSeconds(final int prevSecs) {
        return getNanoTimeInSeconds() - prevSecs;
    }

    public int getDifferenceMinutes(final int prevMins) {
        return getNanoTimeInMinutes() - prevMins;
    }

    public int getDifferenceHours(final int prevHours) {
        return getNanoTimeInHours() - prevHours;
    }
}
