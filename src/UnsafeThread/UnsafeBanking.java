package UnsafeThread;

// 多个线程同时对银行进行扣款, 由于同时获取到资源, 导致扣款过多
public class UnsafeBanking {
    public static void main(String[] args) {
        Account account = new Account(100, "money1");
        Drawing you = new Drawing(account, 50, "yourself");
        Drawing yourgf = new Drawing(account, 100, "your gf");

        you.start();
        yourgf.start();
    }
}

class Account {
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {

    Account account;

    int drawingMoney;

    int havingMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        if (account.money - drawingMoney < 0) {
            System.out.println(Thread.currentThread().getName() + " have no enough money");
            return;
        }

        // sleep 放大问题发生情况
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        account.money = account.money - drawingMoney;
        havingMoney = havingMoney + drawingMoney;

        System.out.println(account.name + " still have " + account.money + " in bank");
        System.out.println(this.getName() + " having " + havingMoney + " in hand");
    }

}