
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Store number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Find the number needed to reach target
            int complement = target - nums[i];

            // Check whether that number is already in the map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }

            // Store current number with its index
            map.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }
}
