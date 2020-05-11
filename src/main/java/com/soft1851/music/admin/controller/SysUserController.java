package com.soft1851.music.admin.controller;


import com.soft1851.music.admin.domain.entity.Song;
import com.soft1851.music.admin.domain.entity.SysUser;
import com.soft1851.music.admin.service.SongService;
import com.soft1851.music.admin.service.SysUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService userService;

    @GetMapping("/list")
    public List<SysUser> selectAll() {
        return userService.selectAll();
    }

    @GetMapping("/page")
    public List<SysUser> getPage(@Param("currentPage") int currentPage, @Param("size") int size) {
        return userService.getPage(currentPage, size);
    }

    @GetMapping("/blur")
    public List<SysUser> getSongBy(@Param("field") String field) {
        return userService.getSongBy(field);
    }

    @GetMapping("/paragraph")
    public List<SysUser> getSongByTime(@Param("flag") String flag) {
        return userService.getSongByDate(flag);
    }
}
