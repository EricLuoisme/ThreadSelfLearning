/**
 * @author lykis
 */
public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany wc = new WeddingCompany(new You());
        wc.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

/**
 * 真实方法
 */
class You implements Marry {
    @Override
    public void HappyMarry() {
        System.out.println("Happy Marry");
    }
}

/**
 * 代理方法
 */
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("decorating the wedding ceremony");
    }

    private void after() {
        System.out.println("cleaning after wedding ceremony");
    }


}
