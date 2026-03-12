class Solution {

    public static int solution(String S) {
        int coins = 0;
        for (int r = 0; r < 3; r++) {
            int tokens = 0;
            for (int i = r; i < S.length(); i += 3) {
                char c = S.charAt(i);
                if (c == 'T') tokens++;
                else if (c == 'C' && tokens > 0) coins++;
            }
        }
        return coins;
    }
}
