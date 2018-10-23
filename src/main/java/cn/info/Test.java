package cn.info;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gao.WenLong on 2018/10/23.
 */
public class Test {

    public static void main(String[] args) {
        String str = "background: url(https://wx1.sinaimg.cn/mw690/b771bb24gy1ftsbq2u5krj207g0bndgc.jpg)  no-repeat; background-position:50% 50%; background-size: cover;";
        String regex = "url\\((.*)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.group(1));
    }
}
