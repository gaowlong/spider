package cn.info.dao;

import cn.info.bean.Video;
import cn.info.db.DbPool;
import cn.info.db.DbTools;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 视频链接解析
 * Created by gaowenlong on 2018/10/27.
 */
public class VideoDao {


    /**
     * 查询视频是否已经存在
     * @param md5
     */
    public static Video queryVideo(String md5) {
        String sql = "select * from video where md5=?";
        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,md5);
            rs = ps.executeQuery();
            if(rs.next()) {
                Video video = new Video();
                video.setId(rs.getLong("id"));
                video.setActors(rs.getString("actors"));
                video.setCategory(rs.getString("category"));
                video.setStory(rs.getString("story"));
                video.setClassify(rs.getString("classify"));
                video.setDirector(rs.getString("director"));
                video.setFinished(rs.getInt("finished"));
                video.setImg(rs.getString("img"));
                video.setLanguage(rs.getString("language"));
                video.setLastNum(rs.getString("lastNum"));
                video.setLocation(rs.getString("location"));
                video.setMd5(rs.getString("md5"));
                video.setName(rs.getString("name"));
                video.setRemark(rs.getString("remark"));
                video.setStatus(rs.getString("status"));

                return video;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if(connection !=null) {
                    connection.close();
                }
                if(null !=rs) {
                    rs.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 插入video信息
     * @param video
     */
    public static void insertVideo(Video video) {

        String sql  = "insert into video(md5,name,director,year," +
                      "actors,location,classify,category,language," +
                      "story,img,remark,src,finished,lastnum,status)" +
                      " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,video.getMd5());
            ps.setString(2,video.getName());
            ps.setString(3,video.getDirector());
            ps.setString(4,video.getYear());
            ps.setString(5,video.getActors());
            ps.setString(6,video.getLocation());
            ps.setString(7,video.getClassify());
            ps.setString(8,video.getCategory());
            ps.setString(9,video.getLanguage());
            ps.setString(10,video.getStory());
            ps.setString(11,video.getImg());
            ps.setString(12,video.getRemark());
            ps.setString(13,video.getSrc());
            ps.setInt(14,video.getFinished());
            ps.setString(15,video.getLastNum());
            ps.setString(16,video.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if(connection !=null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新video信息
     * @param video
     */
    public static void updateVideo(Video video) {
        String sql = "update video set md5=?,name=?,director=?,year=?," +
                     "actors=?,location=?,classify=?,category=?,language=?," +
                     "story=?,img=?,remark=?,src=?,finished=?,lastnum=?,status=?" +
                     " where id=?";
        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,video.getMd5());
            ps.setString(2,video.getName());
            ps.setString(3,video.getDirector());
            ps.setString(4,video.getYear());
            ps.setString(5,video.getActors());
            ps.setString(6,video.getLocation());
            ps.setString(7,video.getClassify());
            ps.setString(8,video.getCategory());
            ps.setString(9,video.getLanguage());
            ps.setString(10,video.getStory());
            ps.setString(11,video.getImg());
            ps.setString(12,video.getRemark());
            ps.setString(13,video.getSrc());
            ps.setInt(14,video.getFinished());
            ps.setString(15,video.getLastNum());
            ps.setString(16,video.getStatus());
            ps.setLong(17,video.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if(connection !=null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Video{id=null, md5='a21976fc9beeb724bf9d2172c3b643f6', name='我不是药神', director='文牧野', year=null, actors='徐峥 王传君 周一围 谭卓 章宇', location='内地', classify='null', category='喜剧片', language='国语', desc='喜剧', img='https://wx1.sinaimg.cn/mw690/b771bb24gy1fsyb59mw2bj207g0afjs1.jpg', remark='null', src='dadatu', finished=0, lastNum=null, status='高清抢先版'}

        Video video = new Video();
        video.setMd5("a21976fc9beeb724bf9d2172c3b643f6");
        video.setName("我不是药神");
        video.setDirector("文牧野");
        video.setActors("徐峥 王传君 周一围 谭卓 章宇");
        video.setLocation("内地");
        video.setCategory("喜剧片");
        video.setLanguage("国语");
        video.setStory("喜剧");
        video.setImg("https://wx1.sinaimg.cn/mw690/b771bb24gy1fsyb59mw2bj207g0afjs1.jpg");
        video.setSrc("dadatu");
        video.setStatus("高清抢先版");

        insertVideo(video);

    }
}
