package cn.info.bean;

/**
 * 电影实体
 * Created by Gao.WenLong on 2018/10/23.
 */
public class Video {


    private Long id;

    /**
     * md5值
     */
    private String md5;

    /**
     * 片名
     */
    private String name;

    /**
     * 导演
     */
    private String director;

    /**
     * 年份
     */
    private int year;

    /**
     * 主演
     */
    private String actors;

    /**
     * 地区：内地、港台
     */
    private String location;

    /**
     * 分类：电影、电视、动漫
     */
    private String classify;

    /**
     * 类型：国产剧、美剧
     */
    private String category;

    /**
     * 语言：中文、粤语
     */
    private String language;

    /**
     * 剧情：古装、爱情
     */
    private String desc;

    /**
     * 图片
     */
    private String img;

    /**
     * 详情：剧情介绍
     */
    private String remark;

    /**
     * 来源
     */
    private String src;

    /**
     * 是否完结
     */
    private Integer finished;

    /**
     * 最近的一集
     */
    private Integer lastNum;

    /**
     * 状态
     */
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Integer getLastNum() {
        return lastNum;
    }

    public void setLastNum(Integer lastNum) {
        this.lastNum = lastNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", md5='" + md5 + '\'' +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", year=" + year +
                ", actors='" + actors + '\'' +
                ", location='" + location + '\'' +
                ", classify='" + classify + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", desc='" + desc + '\'' +
                ", img='" + img + '\'' +
                ", remark='" + remark + '\'' +
                ", src='" + src + '\'' +
                ", finished=" + finished +
                ", lastNum=" + lastNum +
                ", status='" + status + '\'' +
                '}';
    }
}
