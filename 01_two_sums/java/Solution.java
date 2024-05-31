import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}

