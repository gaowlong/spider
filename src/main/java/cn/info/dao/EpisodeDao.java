package cn.info.dao;

import cn.info.bean.Episode;
import cn.info.db.DbPool;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 视频链接解析
 * Created by gaowenlong on 2018/10/27.
 */
public class EpisodeDao {


    /**
     * 查询地址是否已经存在
     * @param md5
     */
    public static Episode queryEpisode(String md5, String md55) {
        String sql = "select * from episode where md5=? and md55=?";
        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,md5);
            ps.setString(2,md55);
            rs = ps.executeQuery();
            if(rs.next()) {
                Episode episode = new Episode();
                episode.setId(rs.getLong("id"));
                episode.setClarity(rs.getString("clarity"));
                episode.setSrc(rs.getString("src"));
                episode.setUrl(rs.getString("url"));
                episode.setSign(rs.getString("sign"));
                episode.setUsable(rs.getInt("usable"));
                episode.setMd5(rs.getString("md5"));
                episode.setMd55(rs.getString("md55"));
                return episode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                if(rs != null) {
                    rs.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 插入Episode信息
     * @param episode
     */
    public static void insertEpisode(Episode episode) {

        String sql  = "insert into episode(clarity,src,url,sign," +
                      "usable,md5,md55) values(?,?,?,?,?,?,?)" ;

        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,episode.getClarity());
            ps.setString(2,episode.getSrc());
            ps.setString(3,episode.getUrl());
            ps.setString(4,episode.getSign());
            ps.setInt(5,episode.getUsable());
            ps.setString(6,episode.getMd5());
            ps.setString(7,episode.getMd55());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 更新episode
     * @param episode
     */
    public static void updateEpisode(Episode episode) {
        String sql  = "update episode set clarity=?,src=?,url=?,sign=?," +
                "usable=?,md5=?,md55=? where id=?" ;

        DbPool dbPool = DbPool.getInstance();
        DruidPooledConnection connection = null;
        PreparedStatement ps = null;
        try {
            connection = dbPool.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1,episode.getClarity());
            ps.setString(2,episode.getSrc());
            ps.setString(3,episode.getUrl());
            ps.setString(4,episode.getSign());
            ps.setInt(5,episode.getUsable());
            ps.setString(6,episode.getMd5());
            ps.setString(7,episode.getMd55());
            ps.setLong(8,episode.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(ps != null) {
                    ps.close();
                }
                if(connection != null) {
                    connection.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Episode episode = new Episode();
        episode.setMd55("1");
        episode.setMd5("2");
        episode.setSrc("1");
        episode.setUsable(1);
        episode.setSign("1");
        episode.setClarity("1");
        episode.setUrl("1");
        insertEpisode(episode);
    }

}
