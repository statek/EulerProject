package mst.euler.solutions;

import mst.euler.Solution;

import java.util.*;

public class s062 extends Solution {

    private Long generationIterator = 1L;
    private int cubeGenerationDigits = 7;

    public static void main(String[] args) {
        System.out.println(new s062().run());
    }

    @Override
    public String solve() {
        Set<Long> resultSet = findNpermutationCube(5);
        System.out.println(resultSet);
        return String.valueOf(resultSet.stream().mapToLong(Long::longValue).min().getAsLong());
    }

    private Set<Long> findNpermutationCube(int n) {


        Set<Long> permCubes = new HashSet<>();

        while (true) {
            Set<Long> cubes = generateNdigitCubes(cubeGenerationDigits);
            for (long c1 : cubes) {
                permCubes.clear();
                permCubes.add(c1);
                for (long c2 : cubes) {
                    if (c2 == c1) continue;
                    if (isPermutation(c1, c2)) permCubes.add(c2);
                }
                if (permCubes.size() >= n)
                    return permCubes;
            }
        }

    }

    private Set<Long> generateNdigitCubes(int n) {
        Set<Long> cubes = new TreeSet<>();
        Long cube;
        do {
            cube = generationIterator * generationIterator * generationIterator;
            if (cube.toString().length() == n) cubes.add(cube);
            generationIterator++;
        } while (cube.toString().length() <= n);
        generationIterator--;
        cubeGenerationDigits++;
        return cubes;
    }

    private boolean isPermutation(Long l1, Long l2) {
        List<String> s1 = new ArrayList<>(Arrays.asList(l1.toString().split("")));
        List<String> s2 = new ArrayList<>(Arrays.asList(l2.toString().split("")));
        Collections.sort(s1);
        Collections.sort(s2);
        return s1.equals(s2);
    }
}
