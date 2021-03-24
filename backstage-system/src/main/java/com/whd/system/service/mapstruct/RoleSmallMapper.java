package com.whd.system.service.mapstruct;

import com.whd.system.domain.Role;
import com.whd.system.service.dto.RoleSmallDto;
import common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends BaseMapper<RoleSmallDto, Role> {

}
