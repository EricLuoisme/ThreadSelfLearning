/**
 * @author lykis
 */
public class ThreadTest4 implements Runnable {

    private int ticketNums = 20;

    @Override
    public void run() {
        while (--ticketNums > 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " get the " + this.ticketNums + " ticket");
        }
    }

    public static void main(String[] args) {
        ThreadTest4 t4 = new ThreadTest4();

        // 多个线程操作同一个数据时，会导致数据紊乱，不安全
        new Thread(t4, "people1").start();
        new Thread(t4, "people2").start();
        new Thread(t4, "people3").start();
    }
}
