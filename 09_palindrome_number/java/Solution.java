class Solution {

    public boolean isPalindrome(int x) {
        // Negative and single digit case
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        // Reverse just the second half of the 'x'
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        // Compare first half with the reversed second half of the 'x'
        // In case of odd number, get rid of the middle
        return x == reversed || x == reversed / 10;
    }
}

