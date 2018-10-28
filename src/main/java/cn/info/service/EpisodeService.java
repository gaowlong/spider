package cn.info.service;

import cn.info.bean.Episode;
import cn.info.dao.EpisodeDao;

import java.util.List;

/**
 * Created by gaowenlong on 2018/10/27.
 */
public class EpisodeService {


    /**
     * 批量插入视频信息，去除重复
     * @param list
     */
    public synchronized static void insertEpisode(List<Episode> list) {
        if(null == list || list.size() == 0) {
            return;
        }
        for(Episode episode : list) {
            Episode episode1 = EpisodeDao.queryEpisode(episode.getMd5(),episode.getMd55());
            if(null == episode1) {
                EpisodeDao.insertEpisode(episode);
            }
        }

    }

    /**
     * 更新视频信息
     * @param episode
     */
    public static void updateEpisode(Episode episode) {
        if(null == episode)return;
        EpisodeDao.updateEpisode(episode);
    }











}
