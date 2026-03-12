class Solution {

    public static int solution(String S) {
        // Tokens move exactly +3 positions, so positions with the same (index % 3)
        // form independent "lanes" that never interact with each other.
        int coins = 0;
        for (int r = 0; r < 3; r++) {
            // Within a lane, a coin is collectible if and only if at least one token
            // exists to its left — we can always maneuver tokens past each other since
            // we control move order, so no token is ever permanently blocked.
            int tokens = 0; // number of tokens seen so far in this lane
            for (int i = r; i < S.length(); i += 3) {
                char c = S.charAt(i);
                if (c == 'T') tokens++;
                else if (c == 'C' && tokens > 0) coins++; // reachable by a token to its left
            }
        }
        return coins;
    }
}
