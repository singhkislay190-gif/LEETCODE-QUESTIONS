
import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision occurs when the previous asteroid moves right
            // and the current asteroid moves left
            while (!stack.isEmpty() &&
                   stack.peek() > 0 && asteroid < 0) {

                if (stack.peek() < -asteroid) {
                    // Previous asteroid is smaller
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids have equal size
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Current asteroid is smaller
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack into an array
        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}
