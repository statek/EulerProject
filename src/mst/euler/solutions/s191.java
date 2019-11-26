package mst.euler.solutions;

import mst.euler.Solution;

public class s191 extends Solution {

    private static final String[] SIGNS = {"A", "L", "O"};
    private static final String[] SIGNS_WITHOUT_LATE = {"A", "O"};
    private int period = 30;
    private Long prizeStringsCount = 0l;

    public static void main(String[] args) {
        System.out.println(new s191().run());
    }

    @Override
    public String solve() {

        generatePrizeString("");
        return String.valueOf(prizeStringsCount);
    }

    private void generatePrizeString(final String prizeString) {
        if (prizeString.endsWith("AAA")) {
            return;
        }

        if (prizeString.length() == period) {
            prizeStringsCount++;
            System.out.println("\t\t\t\t" + prizeString+"\t"+prizeStringsCount);
            return;
        }
        for (String s : SIGNS) {
            if (s.equals("L")) {
                generatePrizeStringIfAlreadyLate(prizeString + s);
            } else {
                generatePrizeString(prizeString + s);
            }
        }
    }

    private void generatePrizeStringIfAlreadyLate(final String prizeString) {
        if (prizeString.endsWith("AAA")) {
            return;
        }

        if (prizeString.length() == period) {
            prizeStringsCount++;
            return;
        }

        for (String s : SIGNS_WITHOUT_LATE) {
            generatePrizeStringIfAlreadyLate(prizeString + s);
        }
    }

    public void setPeriod(final int period) {
        this.period = period;
    }
}
