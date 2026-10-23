
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Initially, take the sum of the first three numbers
        int closestSum = nums[0] + nums[1] + nums[2];

        // Step 2: Fix the first number
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Find the closest sum using two pointers
            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                // If the sum is closer to target, update it
                if (Math.abs(sum - target) <
                    Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Exact match found
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    // Increase sum
                    left++;
                }
                else {
                    // Decrease sum
                    right--;
                }
            }
        }

        return closestSum;
    }
}
