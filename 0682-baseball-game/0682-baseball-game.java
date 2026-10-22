import java.util.Stack;

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {

            if (op.equals("C")) {
                // Remove the last score
                stack.pop();
            }
            else if (op.equals("D")) {
                // Double the last score
                stack.push(2 * stack.peek());
            }
            else if (op.equals("+")) {
                // Sum of the previous two scores
                int last = stack.pop();
                int secondLast = stack.peek();

                stack.push(last);
                stack.push(last + secondLast);
            }
            else {
                // Convert the string to an integer and push it
                stack.push(Integer.parseInt(op));
            }
        }

        // Calculate the total score
        int sum = 0;

        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}