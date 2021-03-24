package com.whd.system.service.mapstruct;

import com.whd.base.BaseMapper;
import com.whd.system.domain.Dict;
import com.whd.system.service.dto.DictDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDto, Dict> {

}