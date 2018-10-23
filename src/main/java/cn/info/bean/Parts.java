package cn.info.bean;

/**
 * 集
 * Created by Gao.WenLong on 2018/10/23.
 */
public class Parts {

    private Long id;

    /**
     * 视频ID
     */
    private Long videoId;

    /**
     * 第几集
     */
    private Integer num;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
