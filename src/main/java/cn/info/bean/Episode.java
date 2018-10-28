package cn.info.bean;

/**
 * 电视剧
 * Created by Gao.WenLong on 2018/10/26.
 */
public class Episode {

    private Long id;
    /**
     * 清晰度用
     */
    private String clarity;

    /**
     * 来源
     */
    private String src;

    /**
     * 清晰度对应的url
     */
    private String url;

    /**
     * 标记
     */
    private String sign;

    /**
     * 是否有效,0-有效
     */
    private Integer usable = 0;

    /**
     * 名称的md5值用来关联几张表的数据
     */
    private String md5 ;

    /**
     * 当前视频链接的md5码用来确定唯一性
     */
    private String md55;


    public String getClarity() {
        return clarity;
    }

    public void setClarity(String clarity) {
        this.clarity = clarity;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getUsable() {
        return usable;
    }

    public void setUsable(Integer usable) {
        this.usable = usable;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMd55() {
        return md55;
    }

    public void setMd55(String md55) {
        this.md55 = md55;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", clarity='" + clarity + '\'' +
                ", src='" + src + '\'' +
                ", url='" + url + '\'' +
                ", sign='" + sign + '\'' +
                ", usable=" + usable +
                ", md5='" + md5 + '\'' +
                ", md55='" + md55 + '\'' +
                '}';
    }
}
