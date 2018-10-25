package cn.info.utils;

import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Gao.WenLong on 2018/10/25.
 */
public class HttpConnectionTools {

    /**
     * 获取http连接
     * @param url
     * @return
     */
    public static Connection connection(String url) {
            return HttpConnection.connect(url);
    }

    /**
     * 获取需要解析的document
     * @param url
     * @return
     */
    public static Document document(String url) {
        Connection connection = connection(url);
        try {
            return connection.get();
        } catch (IOException e) {
            return null;
        }
    }









}
