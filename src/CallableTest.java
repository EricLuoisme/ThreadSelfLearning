//import java.util.concurrent.*;
//
///**
// * @author lykis
// */
//public class CallableTest implements Callable<Boolean> {
//    private String url;
//    private String name;
//
//
//    public CallableTest(String url, String name) {
//        this.url = url;
//        this.name = name;
//    }
//
//    @Override
//    public Boolean call() {
//        WebDownloader webDownloader = new WebDownloader();
//        webDownloader.downloader(url, name);
//        System.out.println("The name of downloaded file is : " + name);
//        return true;
//    }
//
//    public static void main(String[] args) {
//
//        String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1599155114382&di=c06efaa21ca2fddd0bfa20da5a08d099&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F3%2F51b691bd10e24.jpg";
//        String name = "cat";
//
//        CallableTest thread1 = new CallableTest(url, name + "1.jpg");
//        CallableTest thread2 = new CallableTest(url, name + "2.jpg");
//        CallableTest thread3 = new CallableTest(url, name + "3.jpg");
//
//        // 创建执行服务
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        // 提交执行
//        Future<Boolean> result1 = service.submit(thread1);
//        Future<Boolean> result2 = service.submit(thread2);
//        Future<Boolean> result3 = service.submit(thread3);
//        // 获取结构
//        try {
//            boolean rs1 = result1.get();
//            boolean rs2 = result2.get();
//            boolean rs3 = result3.get();
//
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//        // 关闭服务
//        service.shutdown();
//    }
//}
