package mst.euler.solutions;

import mst.euler.Solution;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class s019 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s019().run());
    }

    @Override
    public String solve() {
        int sundayCount = 0;
        for(LocalDate date = LocalDate.of(1901, 1, 1);
            date.isBefore(LocalDate.of(2001, 1, 1));
            date=date.plusMonths(1)){
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                sundayCount++;
            }
        }
        return String.valueOf(sundayCount);
    }
}

