package amazon.kclosest;

import java.util.PriorityQueue;
class Point implements Comparable<Point>{
    public int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int D() {
        return x*x+y*y;
    }
    @Override
    public int compareTo(Point o) {
        return o.D() - D();
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
public class Solution {

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        int cur = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->
             b.D() - a.D()
        );
        for (int[] point : points) {
            pq.add(new Point(point[0], point[1]));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            ans[cur][0] = p.x;
            ans[cur][1] = p.y;
            cur++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(1,1));
        pq.add(new Point(1,2));
        System.out.println(pq.poll());
    }
}
