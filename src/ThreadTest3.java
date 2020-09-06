/**
 * 使用Runnable接口实现创建线程
 *
 * @author lykis
 */
public class ThreadTest3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("看代码");
        }
    }

    public static void main(String[] args) {

        // 创建runnable接口的实现类对象
        ThreadTest3 t3 = new ThreadTest3();

        // 创建thread对象，通过线程对象来开启我们的线程
        Thread th = new Thread(t3);
        th.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("写代码" + i);
        }
    }
}
