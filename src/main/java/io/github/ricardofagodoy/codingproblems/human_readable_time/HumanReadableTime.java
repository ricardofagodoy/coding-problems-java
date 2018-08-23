package io.github.ricardofagodoy.codingproblems.human_readable_time;

// https://www.codewars.com/kata/52685f7382004e774f0001f7/train/java

public class HumanReadableTime {

    private static final int MAX_SECONDS = 359999;
    private static final int MINUTE = 60;
    private static final int HOUR = MINUTE * 60;

    public static String makeReadable(int seconds) {

        if (seconds < 0 || seconds > MAX_SECONDS)
            throw new IllegalArgumentException("Invalid seconds parameter.");

        int remainingSeconds = seconds;
        int hours = 0;
        int minutes = 0;

        if (remainingSeconds >= HOUR) {
            hours = remainingSeconds / HOUR;
            remainingSeconds %= HOUR;
        }

        if (remainingSeconds >= MINUTE) {
            minutes = remainingSeconds / MINUTE;
            remainingSeconds %= MINUTE;
        }

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}