package cn.info;


import cn.info.constant.Constant;
import cn.info.utils.HttpConnectionTools;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
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

    private static String url7 = "https://www.dadatu.co/zy/index.html";

    private static String url8 = "https://www.dadatu.co/zy/huoxingqingbaojudisanji/";

    private static String url9 = "https://www.dadatu.co/zy/huoxingqingbaojudisanji/play-0-0.html";

    private static String url10 = "https://www.dadatu.co/xj/kuaibawogedaizou/play-0-0.html";

    /**
     * 在爬取数据时用来存储获取的链接(非重复的)
     */
    private Set<String> urls = Collections.synchronizedSet(new HashSet<String>());

    /**
     * 用于存放所有的url，同时在处理时从队列中弹出
     */
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

    private final static Integer MAX_LENGTH = 5000;

    /**
     * 默认开10个线程处理
     */
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(6, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>());


    public static void main(String[] args) throws Exception {
        new Spider().run(Constant.HOME);
    }


    /**
     * 开始执行爬取任务
     * @param url
     */
    public void run(String url) {
        urls.add(url);
        queue.offer(url);
        threadPool.execute(new SpiderTask(urls,threadPool,queue));
    }


}
