package UnsafeThread;

// 同一时间, 多个线程向同一个资源操作, 导致获取的数据可能是刚好被其它线程操作过, 但还没更新的
public class UnsafeBuyTickets {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "1").start();
        new Thread(buyTicket, "2").start();
        new Thread(buyTicket, "3").start();
    }
}

class BuyTicket implements Runnable {

    private int ticketNums = 10;

    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    private void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + " get the " + this.ticketNums-- + " ticket");
    }
}