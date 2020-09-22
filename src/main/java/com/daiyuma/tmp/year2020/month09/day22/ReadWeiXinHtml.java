package com.daiyuma.tmp.year2020.month09.day22;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;

/**
 * 读取微信订阅号内容
 * 最终目的：生成与原文章一样的html字符串，并且符合wordpress格式
 */
public class ReadWeiXinHtml {

    //图片保存路径
    private static final String LOCAL_IMG_SAVE_PATH = "C://imgs";
    //github上传图片路径
    private static final String GIT_IMG_PATH = "/2020/09/";
    //日期格式
    private static final String DATE_FORMATTER = "yyyyMMdd";
    //时间格式
    private static final String TIME_FORMATTER = "HHmmss";

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://mp.weixin.qq.com/s/qr9tTHVm6mcKO7BnHbCgGQ");
        Document doc = Jsoup.parse(url, 5000);
        //文章板块
        Element js_article = doc.getElementById("js_article");
        //标题
        String title = js_article.getElementById("activity-name").html();
        //文章内容
        Element js_content = js_article.getElementById("js_content");
        Elements elements = js_content.getAllElements();
        StringBuilder wp = new StringBuilder();
        for (Element e : elements) {
            if ("p".equals(e.tagName())) {
                wp.append("<!-- wp:paragraph -->");
                wp.append("<p>");
                wp.append(e.text());
                wp.append("</p>");
                wp.append("<!-- /wp:paragraph -->");
            } else if ("img".equals(e.tagName())) {
                wp.append("<!-- wp:image {\"sizeSlug\":\"large\"} -->");
                wp.append(imgHandler(e));
                wp.append("<!-- /wp:image -->");
            } else if ("h2".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h2>");
                wp.append(e.text());
                wp.append("</h2>");
                wp.append("<!-- /wp:heading -->");
            }
        }
        System.out.println(wp.toString());
    }

    /**
     * 处理公众号里面的图片
     *
     * @param e
     * @return
     * @throws IOException
     */
    public static String imgHandler(Element e) throws IOException {
        String imgSrc = e.attr("data-src");
        URL imgUrl = new URL(imgSrc);
        URLConnection conn = imgUrl.openConnection();
        InputStream is = conn.getInputStream();
        String imageOldName = imgSrc.substring(imgSrc.lastIndexOf("/") + 1, imgSrc.length());
        OutputStream os = new FileOutputStream(new File(LOCAL_IMG_SAVE_PATH, "?"));
        byte[] buf = new byte[1024];
        int p = 0;
        while ((p = is.read(buf)) != -1) {
            os.write(buf, 0, p);
        }
        StringBuilder str = new StringBuilder();
        str.append("<figure class=\"wp-block-image size-large\">");
        str.append("<img src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master ");
        str.append(GIT_IMG_PATH);

        ///2020/09/20200918_001_161630_tech.png\"  alt="哼哼哈嘿"  />
        str.append("</figure>");
        return "";
    }

    public StringBuilder getImgName() {
        StringBuilder str = new StringBuilder();
        str.append(TimeUtils.getDate());
        str.append("_");
        str.append("?");
        str.append("_");
        str.append(TimeUtils.getTime());
        str.append("_");
        str.append("?");
        str.append("?");
        return str;
    }
}