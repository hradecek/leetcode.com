public class Solution {

    public String clearDigits(String s) {
        final var sb = new StringBuilder();
        for (var c : s.toCharArray()) {
            if (Character.isDigit(c) && !sb.isEmpty()) {
                sb.setLength(sb.length() - 1);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
