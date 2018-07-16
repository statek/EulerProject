package mst.euler.solutions;

import mst.euler.Solution;

public class s033 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s033().run());
    }

    @Override
    public String solve() {

        Factor f;
        Factor product = new Factor(1,1);
        for (int i=10;i<100;i++) {
            for (int j = 10; j < i; j++) {
                f = new Factor(j,i);
                if (f.isDigitCancelling()) {
                    System.out.println(f.toString());
                    product.multiply(f);
                }
            }
        }
        product.shortcut();
        return product.d;
    }

    class Factor {
        String n,d;
        double value;
        Factor(int n,int d) {
            this(n+"",d+"");
        }
        Factor(String n,String d){
            this.n=n;
            this.d=d;
            this.value = Double.parseDouble(n)/Double.parseDouble(d);
        }
        private boolean isDigitCancelling(){
            for(char i='1'; i<='9';i++){
                if(d.contains(i+"") && n.contains(i+""))
                {
                    Factor f = new Factor(n.replaceFirst(i+"",""),d.replaceFirst(i+"",""));
                    if(f.value==this.value) return true;
                }
            }
            return false;
        }
        public String toString(){
            return n+"/"+d+" = "+value;
        }
        private void multiply(Factor f){
            this.d=Integer.parseInt(this.d)*Integer.parseInt(f.d)+"";
            this.n=Integer.parseInt(this.n)*Integer.parseInt(f.n)+"";
            this.value = Double.parseDouble(n)/Double.parseDouble(d);
        }

        private void shortcut(){
            int d = Integer.parseInt(this.d);
            int n = Integer.parseInt(this.n);

            for(int i=2; i<d; i++)
                if (d%i==0 && n%i==0) {
                    d/=i;
                    n/=i;
                    i--;
                }
            this.d=d+"";
            this.n=n+"";
            this.value = Double.parseDouble(this.n)/Double.parseDouble(this.d);
        }
    }
}
