/**
 * @author lykis
 */
public class YieldTest {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "A").start();
        new Thread(myYield, "B").start();
    }

}
class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread is running");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " thread stop now");
    }
}
