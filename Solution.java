import java.util.Scanner;

class Solution {
    static int solution(String board) {
        int coins = 0;
        for (int r = 0; r < 3; r++) {
            int tokens = 0;
            for (int i = r; i < board.length(); i += 3) {
                char c = board.charAt(i);
                if (c == 'T') tokens++;
                else if (c == 'C' && tokens > 0) coins++;
            }
        }
        return coins;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print(solution(in.next()));
    }
}
