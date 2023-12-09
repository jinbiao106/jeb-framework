package com.jeb.framework.model.mapstruct;

import com.jeb.framework.enums.SexEnum;
import com.jeb.framework.model.domain.User;
import com.jeb.framework.model.dto.user.UserReqDTO;
import com.jeb.framework.model.dto.user.UserRespDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.control.DeepClone;
import org.mapstruct.factory.Mappers;

/**
 * @Date 2023-12-08 15:22
 * @Author GuYue
 */
@Mapper
// @Mapper(mappingControl = DeepClone.class)  深度克隆，适用于对象嵌套
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  @Mapping(target = "sex", expression = "java(mapStatus(user.getSex()))")
  UserRespDTO toRespDTO(User user);

  default Integer mapStatus(SexEnum sexEnum) {
    // 处理空指针，返回合适的默认值或空字符串
    return sexEnum != null ? sexEnum.getCode() : null;
  }

}
