package com.whd.system.service.mapstruct;

import com.whd.system.domain.User;
import com.whd.system.service.dto.UserDto;
import common.base.BaseMapper;
import org.mapstruct.Mapper;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
}
