/**
 * @author lykis
 */
public class ThreadTest extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("看代码");
        }
    }

    public static void main(String[] args) {

        ThreadTest tt = new ThreadTest();
        tt.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("写代码" + i);
        }
    }
}
