package com.whd.system.service.mapstruct;

import com.whd.system.domain.User;
import com.whd.system.service.dto.UserDto;
import com.whd.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
}
