package BaseAlgorithm.Java;

import java.io.File;

public class TestMd5 {
    public static void main(String[] args) {
        String md5 = MD5Algorithm.md5(new File("/Users/notzuonotdied/DevelopProjects/Android/iQIYI/iqiyi/app/QYVideoClient/src/main/assets/pluginapp/com.qiyi.game.live.plugin.apk"));
        System.out.println(md5);
        System.out.println(md5.equals("edceae1ffd3baaf5df71fc5878c85bf5"));
    }
}
