package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

public class s068 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s068().run());
    }

    @Override
    public String solve() {
        Ngon ngon = new Ngon(5);
        ngon.findSolutions();
        System.out.println(ngon.getSolutions());

        return String.valueOf(ngon.getSolutions().keySet().stream().filter(s -> s.length()==16).mapToLong(Long::parseLong).max().getAsLong());
    }

    class Ngon {
        int n, sum;
        Set<Integer> values = new TreeSet<>();
        List<Integer> outer = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Map<String,Integer> solutions = new HashMap<>();

        public Map<String, Integer> getSolutions() {
            return solutions;
        }

        Ngon(int n) {
            this.n = n;
            for (int i = 1; i <= n; i++) {
                values.add(i);
                values.add(i + n);
            }
        }

        private boolean isValid() {
            boolean isValid = true;
            sum = outer.get(n - 1) + inner.get(n - 1) + inner.get(0);
            for (int i = 0; i < n - 1; i++) {
                isValid &= sum == outer.get(i) + inner.get(i) + inner.get((i + 1));
            }
            return isValid;
        }

        private void findSolutions() {
            if (inner.size() == n) {
                if (isValid()) saveSolution();
            } else {
                for (int v : values) {
                    if (outer.contains(v) || inner.contains(v)) continue;
                    if (outer.size() < n) outer.add(v);
                    else inner.add(v);
                    findSolutions();
                    outer.remove((Integer) v);
                    inner.remove((Integer) v);
                }
            }
        }

        private void saveSolution() {
            String sol="";
            for (int i = 0; i < n ; i++) {
                sol += ""+ outer.get(i) + inner.get(i) + inner.get((i+1)%n);
            }
            int solutionCut = sol.indexOf(String.valueOf(outer.stream().mapToInt(Integer::intValue).min().getAsInt()));
            sol = sol.substring(solutionCut)+sol.substring(0,solutionCut);

            solutions.put(sol, sum);
        }
    }
}
