package com.whd.system.service.mapstruct;

import com.whd.base.BaseMapper;
import com.whd.system.domain.Log;
import com.whd.system.service.dto.LogErrorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogErrorMapper extends BaseMapper<LogErrorDTO, Log> {

}