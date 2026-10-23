
class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            // Find the shorter line
            int h = Math.min(height[left], height[right]);

            // Calculate area = width * height
            int width = right - left;
            int area = h * width;

            // Store the maximum area
            maxWater = Math.max(maxWater, area);

            // Move the pointer at the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
