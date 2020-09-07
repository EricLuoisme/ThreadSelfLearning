/**
 * 模拟龟兔赛跑
 *
 * @author lykis
 */
public class Race implements Runnable {

    private static String winner = null;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++){
            if ("Rabbit".equals(Thread.currentThread().getName()) && i % 10 == 0){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag) {
                break;
            }
            System.out.println(Thread.currentThread().getName() + "--> ran " + i + "steps");
        }
    }

    private boolean gameOver(int steps) {
        // 判断是否有胜利者
        if (winner != null) {
            return true;
        } else {
            if (steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("The winner is " + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "Rabbit").start();
        new Thread(race, "Tortoise").start();
    }
}
