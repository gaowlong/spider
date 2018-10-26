package cn.info;

import cn.info.utils.HttpConnectionTools;

import java.util.concurrent.*;

/**
 * Created by gaowenlong on 2018/10/22.
 */
public class Spider {


    private static String url1 = "https://www.dadatu.co/dz/direnjiezhichiyouxueteng/play-0-1.html";

    private static String url2 = "https://www.dadatu.co/dz/diezhongdie6/play-0-1.html";

    private static String url3 = "https://www.dadatu.co/dz/diezhongdie6/";

    private static String url4 = "https://www.dadatu.co/gc/yanxigonglue/play-0-0.html";

    private static String url5 = "https://www.dadatu.co/gc/tianjizhibaishechuanshuo/";

    private static String url6 = "https://www.dadatu.co/gc/tianjizhibaishechuanshuo/play-0-0.html";

    /**
     * 默认开10个线程处理
     */
    private static Executor threadPool = new ThreadPoolExecutor(2, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public static void main(String[] args) throws Exception {
        System.out.println(HttpConnectionTools.document(url6));
    }











}
