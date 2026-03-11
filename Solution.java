import java.util.Scanner;
import java.util.stream.Stream;

class Solution {
    static int solution(Integer[] A) {
        int total = 0;
        for (int x : A) total += x;

        // dp[s] = true if subset sum s is achievable
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for (int x : A) {
            for (int s = total; s >= x; s--) {
                if (dp[s - x]) dp[s] = true;
            }
        }

        // Find largest achievable sum <= total/2
        int bestSum = 0;
        for (int s = total / 2; s >= 0; s--) {
            if (dp[s]) { bestSum = s; break; }
        }

        return total - 2 * bestSum;
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
