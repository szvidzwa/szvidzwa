class Solution {

    public static int solution(int[] A) {
        int best = 1; // at minimum we can always pick one element

        // Try each digit 0–9 as the "shared digit".
        // Any group of numbers that all contain digit d is valid,
        // so count how many numbers in A contain d and take the max.
        for (int d = 0; d <= 9; d++) {
            int count = 0;
            for (int num : A) {
                int tens = num / 10; // tens digit (1–9 for two-digit numbers)
                int ones = num % 10; // ones digit (0–9)
                if (tens == d || ones == d) count++;
            }
            best = Math.max(best, count);
        }

        return best;
    }
}
