package auto.gen.cfg;

import auto.gen.util.D;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午5:56
 * 包的启动类
 */
public class Launch {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.dir"));
        GenXmlAndCfg gen = new GenXmlAndCfg();

        gen.genAll(D.EXECEL_DIR);
    }
}
