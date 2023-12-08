package com.jeb.framework.controller.user;

import com.jeb.framework.enums.SexEnum;
import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.common.response.BaseController;
import com.jeb.framework.common.response.PageInfo;
import com.jeb.framework.common.response.ResultData;
import com.jeb.framework.model.dto.user.UserRespDTO;
import com.jeb.framework.service.user.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Date 2023-12-03 22:47
 * @Author GuYue
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Tag(name = "用户信息管理", description = "用户信息管理描述")
public class UserController extends BaseController {


    @Autowired
    private UserService userService;
    @PostMapping("/save")
    @Operation(summary = "保存用户")
    public ResultData<String> save(@Validated @RequestBody UserReqDTO userReqDTO){
         userService.save(userReqDTO);
        return success("保存成功");
    }

    @PostMapping("/selectOne")
    @Operation(summary = "获取用户")
    public ResultData<UserRespDTO> selectOne(@RequestBody Long id){
        User user = userService.selectOne(id);
        UserRespDTO respDTO = new UserRespDTO();
        BeanUtils.copyProperties(user, respDTO);
        respDTO.setSex(user.getSex().getCode());
        return success(respDTO);
    }


    @PostMapping("/listPage")
    @Operation(summary = "获取用户列表")
    public ResultData<PageInfo<User>> listPage(@Validated @RequestBody UserReqDTO userReqDTO){
       PageInfo<User> page = userService.list(userReqDTO);
        return success(page);
    }

    @PostMapping("/selectBatch")
    @Operation(summary = "批量获取用户")
    public ResultData<List<User>> selectBatch(@RequestBody List<Long> ids){
        List<User> list = userService.selectBatch(ids);
        return success(list);
    }

    @PostMapping("/selectCursor")
    @Operation(summary = "通过游标获取数据")
    public void selectCursor(){
        userService.selectCursor();
    }

    /**
     * mysql默认不开启批处理，需要在jdbc url设置 rewriteBatchedStatements=true
     * @param count
     */
    @PostMapping("insertBatchByStatement")
    @Operation(summary = "批量插入数据")
    public void insertBatchByStatement(int count){
        StopWatch watch = new StopWatch();
        watch.start();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setAddress("address" + i);
            user.setAge(i);
            user.setName("name" + i);
            users.add(user);
        }
        userService.batchInsert(users);
        watch.stop();
        log.info("耗时:{}", watch.getTotalTimeMillis());
    }

    @PostMapping("batchInsertByForeach")
    @Operation(summary = "批量插入数据")
    public void batchInsertByForeach(int count){
        StopWatch watch = new StopWatch();
        watch.start();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setAddress("address" + i);
            user.setAge(i);
            user.setName("name" + i);
            users.add(user);
        }
        userService.batchInsertByForeach(users);
        watch.stop();
        log.info("耗时:{}", watch.getTotalTimeMillis());
    }

    @PostMapping("batchUpdate")
    @Operation(summary = "批量更新")
    public void batchUpdate(){
        List<User> users = userService.selectBatch(Arrays.asList(1L, 2L, 3L));
        users.forEach(user -> user.setAddress("address" + user.getId()));
        userService.batchUpdate(users);

    }


}
