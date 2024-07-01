public class Solution {

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        var result = "1";
        for (int i = 2; i <= n; ++i) {
            result = rle(result);
        }
        return result;
    }

    public String rle(String string) {
        if (string.isEmpty()) {
            return "";
        }

        final var result = new StringBuilder();
        int count = 1;
        char curr = string.charAt(0);
        for (int i = 1; i < string.length(); ++i) {
            if (curr == string.charAt(i)) {
                ++count;
            } else {
                result.append(count).append(curr);
                curr = string.charAt(i);
                count = 1;
            }
        }

        result.append(count).append(curr);
        return result.toString();
    }
}
