package UnsafeThread;

import java.util.ArrayList;
import java.util.List;

// 同一时间, 线程对list同一位置添加, 所以导致覆盖, 最终总数不足
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> list.add(Thread.currentThread().getName())).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
