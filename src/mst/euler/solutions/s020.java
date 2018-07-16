package mst.euler.solutions;

import mst.euler.Solution;

import java.util.ArrayList;
import java.util.List;

import static mst.euler.Lib.sumDigits;


public class s020 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s020().run());
    }

    @Override
    public String solve() {
        return String.valueOf(factorialDigitSum(100));
    }

    private String multiplyString(String s1, String s2) {
        String m1 = (s1.length()>s2.length()) ? s1 : s2, m2 = (s1.length()>s2.length()) ? s2 : s1;
        int size = s1.length()+s2.length();
        String tempR,r;
        List<String> tempRs = new ArrayList<>();
        int reminder;

        for (int i2=m2.length()-1; i2>=0; i2--) {
            tempR = "";
            reminder = 0;
            for (int i1 = m1.length() - 1; i1 >= 0; i1--) {
                int tmp = Integer.parseInt(m2.charAt(i2) + "") * Integer.parseInt(m1.charAt(i1) + "")+ reminder;
                int digit = tmp % 10;
                tempR = digit + tempR;
                reminder = tmp / 10;
            }
            tempR = (reminder>0) ? reminder + tempR : tempR;
            tempRs.add(leftPad(rightPadAdd(tempR,m2.length()-1-i2),size));
        }
        r=trimBackZeros(trimLeadingZeros(sumString(tempRs)));
        return r;
    }

    private String trimLeadingZeros(String s) {
        int c=0;
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i)=='0') c++;
            else break;
        }
        return s.substring(c);
    }
    private String trimBackZeros(String s) {
        int c=0;
        for (int i = s.length()-1; i>0; i--) {
            if (s.charAt(i)=='0') c++;
            else break;
        }
        return s.substring(0,s.length()-c);
    }

    private String sumString(List<String> s) {
        List<String> r = new ArrayList<>(s);
        int sum;
        String sumResult="";
        for (int i = r.get(0).length() - 1; i >= 0; i--) {
            sum=0;
            for (String num:r){
                sum+=Integer.parseInt(""+num.charAt(i));
            }
            String sumStr = ""+sum;
            sumStr = rightPadAdd(sumStr,r.get(0).length()-1-i);
            sumStr = leftPad(sumStr,r.get(0).length());
            r.add(sumStr);
            sumResult=sumStr.charAt(i)+sumResult;
        }
        return sumResult;
    }

    private String rightPadAdd(String s,int n) {
        String str = s;
        for (int i=0;i<n;i++){
            str+="0";
        }
        return str;
    }
    private String leftPad(String s,int n) {
        String str = "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000" + s;
        return str.substring(str.length()-n);
    }

    private int factorialDigitSum(int n) {
        String product="1";
        int prod=1;
        for (int i = 1; i <= n; ++i) {
            product=multiplyString(product,""+i);
            prod = prod*i;
        }
        return sumDigits(product);
    }
}
