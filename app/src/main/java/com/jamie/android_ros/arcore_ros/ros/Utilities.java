package com.jamie.android_ros.arcore_ros.ros;

import org.ros.message.Time;

import std_msgs.Header;

/**
 * Created by jamiecho on 2/4/17.
 */

public class Utilities {
    public static void setHeader(Header h, String frame){
        // utility function to populate the header
        // timestamp obtained by curret time
        // frame-id is all going to be "android"
        h.setStamp(Time.fromMillis(System.currentTimeMillis()));
        h.setFrameId(frame);
    }
    public static void setHeader(Header h){
        setHeader(h, "android");
    }

    public static double[] makeDiagonal3x3Matrix(double e11, double e22, double e33) {
        return new double[] {
                e11, 0, 0,
                0, e22, 0,
                0, 0, e33
        };
    }
}
