package cn.info.service;

import cn.info.bean.Video;
import cn.info.dao.VideoDao;

/**
 * Created by gaowenlong on 2018/10/27.
 */
public class VideoService {


    /**
     * 插入视频信息
     * @param video
     */
    public synchronized static void insertVideo(Video video) {
        if(video == null) return;
        Video video1 = VideoDao.queryVideo(video.getMd5());
        if(video1 == null) {
            VideoDao.insertVideo(video);
        }
    }


    /**
     * 更新视频信息
     * @param video
     */
    public static void updateVideo(Video video) {
        if(video == null || video.getId() == null)return;
        VideoDao.updateVideo(video);
    }

    /**
     * 查询视频信息
     * @param md5
     * @return
     */
    public static Video queryVideo(String md5) {
        return VideoDao.queryVideo(md5);
    }











}
