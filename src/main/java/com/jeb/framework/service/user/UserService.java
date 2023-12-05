package com.jeb.framework.service.user;

import com.github.pagehelper.PageHelper;
import com.jeb.framework.mapper.UserMapper;
import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.response.PageInfo;
import com.jeb.framework.response.PageParam;
import com.jeb.framework.service.BaseService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 2023-12-03 22:50
 * @Author GuYue
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;



    public PageInfo<User> list(UserReqDTO userReqDTO) {
        PageHelper.startPage(userReqDTO.getPageNum(), userReqDTO.getPageSize());
        List<User> pageVos = userMapper.list();
        return new PageInfo<>(pageVos);
    }


}
