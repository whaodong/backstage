package com.whd.system.service.mapstruct;

import com.whd.base.BaseMapper;
import com.whd.system.domain.Log;
import com.whd.system.service.dto.LogSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends BaseMapper<LogSmallDTO, Log> {

}