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

    //图片本地缓存 - 新机器一次修改即可
    private static final String LOCAL_IMG_SAVE_PATH = "D://today";
    //当天文章序号 - 每次运行都需要+1
    private static final String TODAY_ARTICLE_ORDER = "001";

    public static void main(String[] args) throws IOException, InterruptedException {
        /**
         * 运行前请修改参数
         */
        wxArticleSpider("https://mp.weixin.qq.com/s/3Mi13ffINyICvk6gneA25g", ArticleCategoryEnum.HEALTH);
    }

    /**
     * 微信公众号爬虫
     */
    public static void wxArticleSpider(String s, ArticleCategoryEnum cat) throws IOException, InterruptedException {
        URL url = new URL(s);
        Document doc = Jsoup.parse(url, 10000);
        //文章板块
        Element js_article = doc.getElementById("js_article");
        //标题
        String title = js_article.getElementById("activity-name").text();
        System.out.println("===文章标题："+title);
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
                wp.append(imgHandler(e, title, cat));
                wp.append("<!-- /wp:image -->");
            } else if ("h1".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h1>");
                wp.append(e.text());
                wp.append("</h1>");
                wp.append("<!-- /wp:heading -->");
            }else if ("h2".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h2>");
                wp.append(e.text());
                wp.append("</h2>");
                wp.append("<!-- /wp:heading -->");
            }else if ("h3".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h3>");
                wp.append(e.text());
                wp.append("</h3>");
                wp.append("<!-- /wp:heading -->");
            }else if ("h4".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h4>");
                wp.append(e.text());
                wp.append("</h4>");
                wp.append("<!-- /wp:heading -->");
            }else if ("h5".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h5>");
                wp.append(e.text());
                wp.append("</h5>");
                wp.append("<!-- /wp:heading -->");
            }else if ("h6".equals(e.tagName())) {
                wp.append("<!-- wp:heading -->");
                wp.append("<h6>");
                wp.append(e.text());
                wp.append("</h6>");
                wp.append("<!-- /wp:heading -->");
            }
        }
        System.out.println(wp.toString());
    }

    /**
     * 处理公众号里面的图片
     * 返回数据格式举例: <figure class="wp-block-image size-large">
     *                    <img src="https://cdn.jsdelivr.net/gh/wecdn/red01@master/2020/09/20200919_001_201009_web.png"
     *                         alt="哼哼哈嘿" />
     *                </figure>
     * @param e
     * @param title
     * @return
     * @throws IOException
     */
    public static StringBuilder imgHandler(Element e, String title, ArticleCategoryEnum cat) throws IOException, InterruptedException {
        String imgSrc = e.attr("data-src");
        String imgFormat = e.attr("data-type");
        URL imgUrl = new URL(imgSrc);
        URLConnection conn = imgUrl.openConnection();
        InputStream is = conn.getInputStream();
        String imgName = getImgName(imgFormat, cat).toString();
        OutputStream os = new FileOutputStream(new File(LOCAL_IMG_SAVE_PATH, imgName));
        byte[] buf = new byte[1024];
        int p = 0;
        while ((p = is.read(buf)) != -1) {
            os.write(buf, 0, p);
        }
        StringBuilder str = new StringBuilder();
        str.append("<figure class=\"wp-block-image size-large\">");
        str.append("<img src=\"https://cdn.jsdelivr.net/gh/wecdn/red01@master");
        //git目录
        str.append(TimeUtils.getGitDatePath());
        //图片名称
        str.append(imgName);
        str.append("\"");
        str.append("alt=\"");
        str.append(title);
        str.append("\"");
        str.append("/>");
        str.append("</figure>");
        return str;
    }

    /**
     * 获取图片名称
     * 图片名称格式举例：20200922_001_230215_web.png
     * @param imgFormat
     * @param cat
     * @return
     */
    public static StringBuilder getImgName(String imgFormat, ArticleCategoryEnum cat) throws InterruptedException {
        StringBuilder str = new StringBuilder();
        //日期
        str.append(TimeUtils.getDate());
        str.append("_");
        //序号
        str.append(TODAY_ARTICLE_ORDER);
        str.append("_");
        //时间
        str.append(TimeUtils.getTime());
        str.append("_");
        //文章类型
        str.append(cat.getType());
        //图片格式
        str.append(".");
        str.append(imgFormat);
        Thread.sleep(2000);
        return str;
    }
}