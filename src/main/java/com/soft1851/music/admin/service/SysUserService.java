package com.soft1851.music.admin.service;

import com.soft1851.music.admin.domain.entity.Song;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhChen
 * @since 2020-04-21
 */
public interface SysUserService extends IService<SysUser> {
    /**
     * 查询所有
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 分页查询歌曲
     *
     * @param current
     * @param size
     * @return
     */
    List<SysUser> getPage(int current, int size);

    /**
     * 模糊查
     *
     * @return
     */
    List<SysUser> getSongBy(String filed);

    /**
     * 查询一段时间内
     *
     * @return
     */
    List<SysUser> getSongByDate(String flag);
}
