package cn.info.bean;

/**
 * 清晰度
 * Created by Gao.WenLong on 2018/10/23.
 */
public class Clarity {

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
     * 是否有效
     */
    private Integer usable;

    /**
     * 视频ID
     */
    private Long videoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }
}
