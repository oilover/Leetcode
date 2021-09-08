package hl.random.valid_num;


import java.lang.ref.SoftReference;
import java.util.*;

public class WH {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> softReference=new SoftReference<>(new byte[1024*1024*5]);
        SoftReference<byte[]> softReference2=new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference.get());
        System.gc(); Thread.sleep(1000);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> l = new ArrayList<>(pq);
        TreeMap<String,Integer> tm = new TreeMap<>();
        Queue q = new LinkedList();
//        System.out.println(softReference.get());
//        byte[] bytes=new byte[1024*1024*10];
        System.out.println(softReference2.get());
        Random r = new Random();
        WeakHashMap<Integer,Integer> map = new WeakHashMap<>();
        final int Lim = 100000;
        final int LIM = 1000000;
//        for (int i = 0; i < Lim; i++) {
//            map.put(r.nextInt(LIM),r.nextInt(LIM));
//        }
        System.out.println(map);
        System.out.println(map.size());
    }
}
