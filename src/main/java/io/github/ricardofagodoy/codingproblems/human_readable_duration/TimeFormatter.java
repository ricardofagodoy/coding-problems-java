package io.github.ricardofagodoy.codingproblems.human_readable_duration;

import java.util.ArrayList;
import java.util.List;

// https://www.codewars.com/kata/52742f58faf5485cae000b9a/train/java
public class TimeFormatter {

    private static final int MINUTE = 60;
    private static final int HOUR = MINUTE * 60;
    private static final int DAY = HOUR * 24;
    private static final int YEAR = DAY * 365;

    public static String formatDuration(int seconds) {

        if (seconds <= 0)
            return "now";

        List<String> durations = new ArrayList<>();

        if (seconds >= YEAR) {
            durations.add(pluralIfNeeded(seconds / YEAR, "year"));
            seconds %= YEAR;
        }

        if (seconds >= DAY) {
            durations.add(pluralIfNeeded(seconds / DAY, "day"));
            seconds %= DAY;
        }

        if (seconds >= HOUR) {
            durations.add(pluralIfNeeded(seconds / HOUR, "hour"));
            seconds %= HOUR;
        }

        if (seconds >= MINUTE) {
            durations.add(pluralIfNeeded(seconds / MINUTE, "minute"));
            seconds %= MINUTE;
        }

        if (seconds > 0) {
            durations.add(pluralIfNeeded(seconds, "second"));
        }

        return assemblePrettyString(durations);
    }

    private static String assemblePrettyString(List<String> durations) {

        if (durations.size() == 1)
            return durations.get(0);

        String result = durations.get(0);

        for (int i = 1; i < durations.size() - 1; i++)
            result += ", " + durations.get(i);

        return result + " and " + durations.get(durations.size() - 1);
    }

    static String pluralIfNeeded(int amount, String message) {
        return amount + " " + message + (amount > 1 ? "s" : "");
    }
}