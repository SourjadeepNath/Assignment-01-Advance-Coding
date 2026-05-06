import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();

        int n = s.length();
        String t = s + s;

        int[] freq = new int[26];
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < 2 * n; right++) {
            int ch = t.charAt(right) - 'a';
            freq[ch]++;
            currentSum += ch + 1;

            while (freq[ch] > 1 || right - left + 1 > n) {
                int leftCh = t.charAt(left) - 'a';
                freq[leftCh]--;
                currentSum -= leftCh + 1;
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}
