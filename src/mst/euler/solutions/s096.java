package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;
import java.util.stream.Collectors;

import static mst.euler.Lib.readFile;

public class s096 extends Solution {

    public static void main(String[] args) {
        System.out.println(new s096().run());
    }

    @Override
    public String solve() {
        long sum = 0;
        List<String> fileContent = readFile("src/mst/euler/resources/p096_sudoku.txt");
        for (int lineNr = 0; lineNr < fileContent.size(); lineNr += 10) {
            Sudoku s = new Sudoku(fileContent.subList(lineNr + 1, lineNr + 10));
            s.backtrackingSolve();
            long first3 = s.get(0) * 100 + s.get(1) * 10 + s.get(2);
            sum += first3;
        }
        return String.valueOf(sum);
    }

    class Sudoku {
        Set<Integer> digits = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> table = new ArrayList<>();
        int emptyPlaces = 0;

        Sudoku(List<String> sudoku) {
            for (String aSudokuLine : sudoku) {
                List<Integer> list = Arrays.asList(aSudokuLine.split("")).stream().map(m -> Integer.parseInt(m)).collect(Collectors.toList());
                table.addAll(list);
                emptyPlaces += list.stream().filter(s -> s == 0).count();
            }
        }

        public String toString() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < table.size(); i++) {
                if (i % 9 == 0) s.append("\n");
                s.append(table.get(i));
            }
            return s.toString();
        }

        public int get(int i) {
            return table.get(i);
        }

        private int getIndex(int r, int c) {
            return r * 9 + c;
        }

        private Set<Integer> getRow(int r, int c) {
            return new HashSet<>(table.subList(getIndex(r, 0), getIndex(r + 1, 0)));
        }

        private Set<Integer> getColumn(int r, int c) {
            Set<Integer> column = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                column.add(table.get(getIndex(row, c)));
            }
            return column;
        }

        private Set<Integer> getSquare(int r, int c) {
            Set<Integer> square = new HashSet<>();
            int sqR = r / 3 * 3;
            int sqC = c / 3 * 3;
            square.addAll(table.subList(getIndex(sqR, sqC), getIndex(sqR, sqC + 3)));
            square.addAll(table.subList(getIndex(sqR + 1, sqC), getIndex(sqR + 1, sqC + 3)));
            square.addAll(table.subList(getIndex(sqR + 2, sqC), getIndex(sqR + 2, sqC + 3)));
            return square;
        }

        private Set<Integer> getPossibilities(int r, int c) {
            Set<Integer> p = new HashSet<>(digits);
            p.removeAll(getRow(r, c));
            p.removeAll(getSquare(r, c));
            p.removeAll(getColumn(r, c));
            return p;
        }

        private void backtrackingSolve(int i) {
            if (i == 81) return;
            if (table.get(i) == 0) {
                Set<Integer> possibilities = getPossibilities(i);
                if (possibilities.size() == 0) return;
                for (int p : possibilities) {
                    table.set(i, p);
                    emptyPlaces--;
                    backtrackingSolve(i + 1);
                    if (emptyPlaces == 0) return;
                    table.set(i, 0);
                    emptyPlaces++;
                }
            } else {
                backtrackingSolve(i + 1);
            }
        }

        private Set<Integer> getPossibilities(int i) {
            return getPossibilities(i / 9, i % 9);
        }

        public void backtrackingSolve() {
            backtrackingSolve(0);
        }
    }
}
