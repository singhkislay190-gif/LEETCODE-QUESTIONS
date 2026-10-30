
import java.util.*;

class RecentCounter {
    Queue<Integer> q = new ArrayDeque<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        q.add(t);

        while (q.peek() < t - 3000) {
            q.remove();
        }

        return q.size();
    }
}
