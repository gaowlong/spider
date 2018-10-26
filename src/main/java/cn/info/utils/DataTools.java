package cn.info.utils;

import org.jsoup.helper.StringUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gao.WenLong on 2018/10/23.
 */
public class DataTools  {

    private static String url1 = "https://www.dadatu.co/dz/direnjiezhichiyouxueteng/play-0-1.html";

    /**
     * Unicode转 汉字字符串
     *
     * @param str \u6728
     * @return '木' 26408
     */
    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\%u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }


    /**
     * 获取当前url的层级，用来判断是否收集当前url的有效信息
     * @param url
     * @return
     */
    public static int urlLevel(String url) {
        if(StringUtil.isBlank(url) || (url.lastIndexOf("/") == -1)) return 0;
        if(url.endsWith("/"))url = url.substring(0,url.length()-1);
        int length = url.split("\\/").length;
        System.out.println(length);
        if(length <= 3)return 1;
        return length -3;
    }


}
