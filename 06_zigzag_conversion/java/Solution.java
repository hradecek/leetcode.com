import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Objects;

public class Solution {

    public String convert(String s, int numRows) {
        final var result = new StringBuilder[numRows];
        boolean isDiagonal = false;
        int row = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (result[row] == null) {
                result[row] = new StringBuilder();
            }
            result[row].append(c);
            if (row == 0) {
                isDiagonal = false;
            }

            if (numRows > 1) {
                if (isDiagonal) {
                    --row;
                } else {
                    ++row;
                }
            }
            if (row == numRows - 1) {
                isDiagonal = true;
            }
        }

        return Arrays.stream(result).filter(Objects::nonNull).map(StringBuilder::toString).collect(Collectors.joining(""));
    }
}

