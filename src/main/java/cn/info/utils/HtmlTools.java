package cn.info.utils;

import cn.info.bean.Episode;
import cn.info.bean.Video;
import cn.info.constant.Constant;
import cn.info.regex.RegexTools;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * HTML解析器
 * Created by Gao.WenLong on 2018/10/25.
 */
public class HtmlTools {


    /**
     * 获取页面上所有的链接
     * @param document
     * @return
     */
    public static void urls(Document document,Set<String> urls,LinkedBlockingQueue<String> queue) {
        if(document == null)return ;
        Elements elements = document.getElementsByTag("a");
        if(null != elements) {
            String href ;
            for(Element element : elements) {
                href = element.attr("href");
                if(!href.contains("http")) {
                    if(urls.add(href)) {
                        queue.offer(href);
                    }
                }
            }
        }
    }

    /**
     * 获取页面上所有的视频链接
     * @param document
     * @return
     */
    public static List<Episode> videoUrls(Document document) {
        if(document == null) return null;
        String title = title(document);
        if(StringUtil.isBlank(title))return null;
        List<Episode> list ;
        String urls = RegexTools.matchFirst(document.toString(),RegexTools.SCRIPT_REGEX);
        if(StringUtil.isBlank(urls))return null;
        urls = urls.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        try {
            urls = URLDecoder.decode(urls, "UTF-8");
            list = episodes(urls,title);
        } catch (UnsupportedEncodingException e) {
            //TODO 解析失败记录日志记录日志
            return null;
        }
        return list;
    }

    /**
     * 解析出视频的信息
     * @param document
     * @return
     */
    public static Video videoInfo(Document document) {
        if(document == null)return null;
        Video video = new Video();
        Elements elements = document.getElementsByClass(Constant.VIDEO_INFO_CLASS);
        if(null == elements)return null;
        //图片
        Elements imgEle = elements.select(".videopic");
        if(imgEle == null) return null;
        String style = imgEle.attr("style").toString();
        if(StringUtil.isBlank(style))return null;
        String img = RegexTools.matchFirst(style,RegexTools.IMG_REGEX);
        video.setImg(img);
        //title
        String title = title(document);
        if(StringUtil.isBlank(title))return null;
        video.setName(title);
        video.setMd5(DigestUtils.md5Hex(title));
        //电影/电视/信息
        Elements liEle = elements.select("li");
        if(liEle != null) {
            for (Element li : liEle ) {
                videoFiled(li.text().trim(),video);
            }
        }else {
            return null;
        }
        video.setSrc(Constant.DADATU_SRC);
        //TODO此处需要考虑下电影、电视、综艺三者的区别
        System.out.println(video.toString());
        return video;
    }

    /**
     * 解析数据赋值给video
     * @param field
     * @param video
     */
    private static void videoFiled(String field,Video video) {
        if(StringUtil.isBlank(field) || (field.indexOf("：") == -1))return;
        String desc = field.split("：")[1];
        if(field.contains(Constant.VIDEO_STATUS)) {
            video.setStatus(desc);
        }
        if(field.contains(Constant.VIDEO_DIRECTOR)) {
            video.setDirector(desc);
        }
        if(field.contains(Constant.VIDEO_ACTORS)) {
            video.setActors(desc);
        }
        if(field.contains(Constant.VIDEO_LOCATION)) {
            video.setLocation(desc);
        }
        if(field.contains(Constant.VIDEO_CATEGORY)) {
            video.setCategory(desc);
        }
        if(field.contains(Constant.VIDEO_LANGUAGE)) {
            video.setLanguage(desc);
        }
        if(field.contains(Constant.VIDEO_DESC)) {
            video.setDesc(desc);
        }
    }

    /**
     * 获取url和描述
     * @param url
     */
    public static List<Episode> episodeMovie(String url, String name) {
        String []tags = url.split("#");
        Episode episode;
        String src = "";
        List<Episode> list = new ArrayList<>();
        for(String str : tags) {
            if(!StringUtil.isBlank(str)) {
                episode = new Episode();
                if(str.contains(Constant.SPLIT_SIGN)) {//第一个特殊处理
                    String []arr = str.split("\\$");
                    src = arr[0];
                    episode.setClarity(arr[2]);
                    episode.setUrl(arr[3]);
                    episode.setSign(arr[4]);
                    episode.setMd5(DigestUtils.md5Hex(name));
                    episode.setSrc(arr[0]);
                }else {
                    String []arr = str.split("\\$");
                    episode.setClarity(arr[0]);
                    episode.setUrl(arr[1]);
                    episode.setSign(arr[2]);
                    episode.setMd5(DigestUtils.md5Hex(name));
                    episode.setSrc(src);
                }
                System.out.println(episode.toString());
                list.add(episode);
            }
        }
        return list;
    }


    /**
     * 获取url和描述
     * @param url
     */
    public static List<Episode> episodeTv(String url, String name) {
       String []arr = url.split("\\$\\$\\$");
       List<Episode> list = new ArrayList<>();
       for(String str : arr) {
           if(!StringUtil.isBlank(str)) {
               //System.out.println(str);
               list.addAll(episodeMovie(str,name));
           }
       }
       return list;
    }

    /**
     * 解析出播放信息
     * @param addr
     * @param name
     * @return
     */
    public static List<Episode> episodes(String addr,String name) {
        if(StringUtil.isBlank(addr) || !addr.contains("#") || !addr.contains("$"))
            return null;
        if(addr.contains("$$$")) {//电视剧
            return episodeTv(addr,name);
        }else{
            return episodeMovie(addr,name);
        }
    }

    public static String title(Document document) {
        if(document == null)return null;
        String title = document.title();
        if(StringUtil.isBlank(title) || !title.contains("《"))return null;
        title = RegexTools.matchFirst(title,RegexTools.TITLE_REGEX);
        return title;
    }

    public static void main(String[] args) {
        String regex = ".*《(.*)》.*";
        String title = "《天乩之白蛇传说》全集免费在线观看_电视剧_达达兔电影网";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(title);
        System.out.println(RegexTools.matchFirst(title,regex));
    }


}
