package com.soft1851.music.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.soft1851.music.admin.domain.dto.TimeDto;
import com.soft1851.music.admin.domain.entity.Song;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.soft1851.music.admin.mapper.SysUserMapper;
import com.soft1851.music.admin.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhChen
 * @since 2020-04-21
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectAll() {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        return sysUserMapper.selectList(wrapper);
    }

    @Override
    public List<SysUser> getPage(int current, int size) {
        Page<SysUser> page = new Page<>(current, size);
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        IPage<SysUser> iPage = sysUserMapper.selectPage(page, wrapper);
        return iPage.getRecords();
    }

    @Override
    public List<SysUser> getSongBy(String filed) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", filed)
                .or()
                .like("nick_name", filed)
                .or()
                .like("address",filed)
                .or()
                .like("phone",filed)
                .or()
                .like("email",filed)
                .or()
                .eq("user_id", filed);
        return sysUserMapper.selectList(wrapper);
    }

    @Override
    public List<SysUser> getSongByDate(String flag) {
        //判断flag是什么标志（周、月等）
        TimeDto timeDto = new TimeDto();
        switch (flag) {
            case "week":
                timeDto.setWeek(flag);
                break;
            case "month":
                timeDto.setMonth(flag);
                break;
            case "quarter":
                timeDto.setQuarter(flag);
                break;
            default:
                timeDto.setYesterday(flag);
                break;
        }
        return sysUserMapper.getSongByTimeParagraph(timeDto);
    }
}
