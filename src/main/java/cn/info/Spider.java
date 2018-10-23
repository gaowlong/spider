package cn.info;

import cn.info.bean.Video;
import cn.info.constant.Constant;
import cn.info.regex.RegexTools;
import org.apache.commons.codec.digest.Md5Crypt;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gaowenlong on 2018/10/22.
 */
public class Spider {


    public static void main(String[] args) throws Exception {
        //狄仁杰
        //String url = "https://www.dadatu.co/dz/direnjiezhichiyouxueteng/play-0-1.html";
       //碟中谍3
        //String url = "https://www.dadatu.co/dz/diezhongdie6/play-0-1.html";
        String url = "https://www.dadatu.co/dz/diezhongdie6/";
        //延禧攻略
        //String url = "https://www.dadatu.co/gc/yanxigonglue/play-0-0.html";
        //String url = "https://www.dadatu.co/gc/tianjizhibaishechuanshuo/";
        Connection conn = HttpConnection.connect(url);
        Document document = conn.get();
        videoInfo(document);
        //System.out.println(document.toString());
        //urls(document);

    }


    /**
     * 获取首页上所有的链接
     * @param document
     * @return
     */
    private static Set<String> urls(Document document) {
        if(document == null)return null;
        Set<String> sets = new HashSet<>();
        Elements elements = document.getElementsByTag("a");
        if(null != elements) {
            String href ;
            for(Element element : elements) {
                href = element.attr("href");
                if(!href.contains("http")) {
                    sets.add(href);
                }
            }
        }
        return sets;
    }


    /**
     * 获取页面上所有的视频链接
     * @param document
     * @return
     */
    public static Set<String> videoUrls(Document document) {
        if(document == null) return null;
        Set<String> sets = new HashSet<>();
        String urls = RegexTools.matchFirst(document.toString(),RegexTools.SCRIPT_REGEX);
        if(StringUtil.isBlank(urls))return null;
        urls = urls.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
        try {
            urls = URLDecoder.decode(urls, "UTF-8");
            for(String str : urls.split("\\$")) {
                if(str.contains("https")) {
                    sets.add(str);
                }
            }
        } catch (UnsupportedEncodingException e) {
            //TODO 解析失败记录日志记录日志
            return null;
        }
        return sets;
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
        Elements imgEle = elements.select(".videopic");
        String style = imgEle.attr("style").toString();
        String img = RegexTools.matchFirst(style,RegexTools.IMG_REGEX);
        video.setImg(img);
        Elements nameEle = elements.select("h3");
        if(nameEle != null) {
            String name = nameEle.text();
            video.setName(name.trim());
            video.setMd5(Md5Crypt.md5Crypt(name.trim().getBytes()));
        }
        Elements liEle = elements.select("li");
        if(liEle != null) {
            for (Element li : liEle ) {
                videoFiled(li.text().trim(),video);
            }
        }
        video.setSrc(Constant.DADATU_SRC);
        //TODO此处需要考虑下电影、电视、综艺三者的区别
        return video;
    }

    /**
     * 解析数据赋值给video
     * @param field
     * @param video
     */
    private static void videoFiled(String field,Video video) {
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

}
