class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int current : asteroids) {

            boolean alive = true;

            // Collision can happen only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (alive && !stack.isEmpty()
                    && stack.peek() > 0 && current < 0) {

                int top = stack.peek();

                if (top < -current) {
                    // Stack asteroid explodes
                    stack.pop();
                }
                else if (top == -current) {
                    // Both explode
                    stack.pop();
                    alive = false;
                }
                else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.push(current);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }

        return result;
    }
}