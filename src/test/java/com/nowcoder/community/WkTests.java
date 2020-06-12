package com.nowcoder.community;

import java.io.IOException;

public class WkTests {

    public static void main(String[] args) {
        String cmd = "c:/work/wkhtmltopdf/bin/wkhtmltoimage --quality 75  https://www.nowcoder.com c:/work/data/wk-images/3.png";
        try {
            Runtime.getRuntime().exec(cmd);// 调用本地操作系统执行，异步、并发
            System.out.println("ok.");// 因此程序会立即向下执行，不会等待本地操作完成，先输出ok，再看到图片生成
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
