package mst.euler.solutions;

import mst.euler.Solution;

public class s039 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s039().run());
    }

    @Override
    public String solve() {
    int count=0, maxp = 0,tmpc;
        for (int p=3; p<1_000; p++){
        tmpc=countPossibleRightTriangles(p);
        if(tmpc>count){
            maxp=p;
            count=tmpc;
        }
    }
        return String.valueOf(maxp);
    }

    private int countPossibleRightTriangles(int perimeter) {
        int count = 0;
        for (int i = 1; i < perimeter; i++) {
            for (int j = 1; j <= i; j++) {
                if (i * i + j * j == (perimeter - i - j)*(perimeter - i - j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
