package mst.euler.solutions;

import mst.euler.Solution;

public class s026 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s026().run());
    }

    @Override
    public String solve() {
        int maxd = 0, maxc = 0, c;
        for (int d = 2; d < 1000; d++) {
            c = new Factor(1, d).countReciprocalLenght();
            if (c > maxc) {
                maxc = c;
                maxd = d;
            }
        }
        return String.valueOf(maxd);
    }


    static class Factor {

        int n, d;

        Factor(int n, int d) {
            this.n = n;
            this.d = d;
        }

        private int countReciprocalLenght() {
            StringBuilder list = new StringBuilder();
            String cycle, full;
            int tmpn = n, v;
            for (int i = 0; i < 2*d; i++) {
                v = tmpn * 10 / d;
                list.append(v);
                tmpn = tmpn * 10 % d;
                if (tmpn == 0) {
                    return 0;
                }
            }
            full = list.toString();
            for (int j = 0; j < full.length(); j++) {
                for (int c = String.valueOf(d).length(); c <= (full.length() - j) / 2; c++) {
                    cycle = full.substring(j, c + j);
                    if (full.contains(cycle + cycle)) {
                        return c;
                    }
                }
            }
            return -1;
        }
    }
}