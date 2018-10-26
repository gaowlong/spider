package cn.info.regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Gao.WenLong on 2018/10/23.
 */
public class RegexTools {

    /**
     * 用来解析页面中的videoUrl的内容
     */
    public final static String SCRIPT_REGEX = "unescape\\(\"(.*)\"\\)";

    /**
     * 提取页面中图片地址
     */
    public final static String IMG_REGEX = "url\\((.*)\\)";

    /**
     * 提取页面中title
     */
    public final static String TITLE_REGEX = ".*《(.*)》.*";


    /**
     * 返回所有匹配正则的字符串
     * @param str
     * @param regex
     * @return
     */
    public static List<String> matchs(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int i = 1;
        List<String> list = new ArrayList<>();
        while(matcher.find()) {
            list.add(matcher.group(i));
            i++;
        }
        return list;
    }


    /**
     * 返回匹配的最新一个
     * @param str
     * @param regex
     * @return
     */
    public static String matchFirst(String str,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

}
