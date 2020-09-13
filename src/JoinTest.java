public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("vip");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();

        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                thread.join();
            }
            System.out.println("main " + i);
        }
    }
}
