package io.github.ricardofagodoy.codingproblems.closing_index;

public class ClosingIndex {

    // https://www.codewars.com/kata/5a24254fe1ce0ec2eb000078
    public static int solve(String str, int index) {

        if (str == null || str.length() == 0 || index < 0 ||
                index >= str.length() || str.charAt(index) != '(')
            return -1;

        int bracketsCount = 0;

        for(int i = index; i < str.length(); i++) {

            char c = str.charAt(i);

            if (c == '(')
                bracketsCount++;
            else if (c == ')')
                bracketsCount--;

            if (bracketsCount == 0)
                return i;
        }

        return -1;
    }
}