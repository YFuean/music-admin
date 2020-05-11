package com.soft1851.music.admin.mapper;

import com.soft1851.music.admin.domain.dto.TimeDto;
import com.soft1851.music.admin.domain.entity.Song;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhChen
 * @since 2020-04-21
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据时间段查询数据
     * @return
     */
    List<SysUser> getSongByTimeParagraph(@Param("timeDto") TimeDto timeDto);

}
