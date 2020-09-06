import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 实现多线程同步的图片下载
 *
 * @author lykis
 */
public class ThreadTest2 implements Runnable {

    private String url;
    private String name;


    public ThreadTest2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("The name of downloaded file is : " + name);
    }

    public static void main(String[] args) {

        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599155114382&di=c06efaa21ca2fddd0bfa20da5a08d099&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F51b691bd10e24.jpg";
        String name = "cat";

        ThreadTest2 thread1 = new ThreadTest2(url, name + "1.jpg");
        ThreadTest2 thread2 = new ThreadTest2(url, name + "2.jpg");
        ThreadTest2 thread3 = new ThreadTest2(url, name + "3.jpg");

        // they did not download follow the order of how they were created
        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();

    }

}

/**
 * 下载器
 */
class WebDownloader {

    /**
     * 下载方法
     */
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
