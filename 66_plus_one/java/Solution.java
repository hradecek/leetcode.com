import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        final var result = new int[1 + digits.length];
        Arrays.fill(result, 0);
        result[0] = 1;
        return result;
    }
}
