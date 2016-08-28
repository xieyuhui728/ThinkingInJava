package collections;

import widetype.generator.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by 谢宇辉 on 2016/8/27 0027.
 * Queue队列的一些操作
 */

public class QueueBehavior {

    private static int count = 10;

    static <T> void test(Queue<T> queue,Generator<T> gen){
        for(int i =0;i<count;i++){
            queue.offer(gen.next());
        }
        while (queue.peek()!=null){
            System.out.print(queue.remove() + " ");
        }
    }
    static class Gen implements  Generator<String>{
        String[] s = "one two three four five six seven eight nine ten".split(" ");
        int i;
        @Override
        public String next() {
            return s[i++];
        }
    }

    public static void main(String[] args) {
        test(new LinkedList<String>(),new Gen());
        test(new PriorityQueue<String>(),new Gen());
        test(new ArrayBlockingQueue<String>(count),new Gen());
    }
}
