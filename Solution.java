import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

class Solution {
    static int solution(Integer[] A) {
        // TreeMap: key = current min height of a row, value = count of rows with that min
        TreeMap<Integer, Integer> rows = new TreeMap<>();

        for (int h : A) {
            // Find the row with the smallest minimum that is still > h (tightest fit)
            Integer key = rows.higherKey(h);
            if (key != null) {
                // Join this row; update its min from key to h
                int count = rows.get(key);
                if (count == 1) rows.remove(key);
                else rows.put(key, count - 1);
                rows.merge(h, 1, Integer::sum);
            } else {
                // No valid row exists, create a new one
                rows.merge(h, 1, Integer::sum);
            }
        }

        return rows.values().stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Scanner in = new Scanner(System.in);
        Integer[] A = getIntegerArray(in.next());

        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
