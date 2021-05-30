package com.company.t3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Server {
    int id;
    int weight;

    public Server(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public Server(int id, int weight, int okTime) {
        this.id = id;
        this.weight = weight;
        this.okTime = okTime;
    }

    int okTime;

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", weight=" + weight +
                ", okTime=" + okTime +
                '}';
    }
}
class Solution {

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n=servers.length,m=tasks.length;
        PriorityQueue<Server> queue = new PriorityQueue<Server> (n, new Comparator<Server>() {
            @Override
            public int compare(Server x, Server y) {
                return x.weight!=y.weight?x.weight-y.weight: x.id-y.id;
            }
        });
        int ans[] = new int[m];
        for (int i = 0; i < n; i++) {
            queue.add(new Server(i,servers[i]));
        }
        PriorityQueue<Server> busy = new PriorityQueue<>(n, new Comparator<Server>() {
            @Override
            public int compare(Server x, Server y) {
                return x.okTime!=y.okTime ? x.okTime-y.okTime :
                    (x.weight!=y.weight?x.weight-y.weight: x.id-y.id);
            }
        });
        for (int i=0;i<tasks.length;i++) {
            int time = i;
            Server s;
            while (!busy.isEmpty() && busy.peek().okTime<=i) {
                queue.offer(busy.poll());
            }
            if (queue.isEmpty()) {
                s = busy.poll();
                s.okTime= Math.max(time,s.okTime) + tasks[i];
                ans[i] = s.id;
                busy.offer(s);
            } else {
                s = queue.poll();
                s.okTime = time + tasks[i];
                ans[i] = s.id;
                busy.offer(s);
            }
        }
        return ans;
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = new int[]{3,3,2};
        int b[] = new int[]{1,2,3,2,1,2};
        System.out.println(Arrays.toString(s.assignTasks(a,b)));
        a = new int[]{5,1,4,3,2};
        b = new int[]{2,1,2,4,5,2,1};
        System.out.println(Arrays.toString(s.assignTasks(a,b)));
    }

}
