package mst.euler.solutions;

import mst.euler.Solution;

import static java.lang.Math.pow;

public class s030 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s030().run());
    }

    @Override
    public String solve() {

        int sum = 0;
        for (int i = 10; i < 6 * pow(9, 5); i++) {
            if (isPowersDigit(i, 5)) {
                sum += i;
            }
        }
        return String.valueOf(sum);
    }

    private boolean isPowersDigit(int num, int ex) {
        String number = String.valueOf(num);
        int sum = 0;
        for (int i = 0; i < number.length(); ++i) {
            sum += pow(Integer.parseInt(number.charAt(i) + ""), ex);
        }
        return sum == num;
    }
}
