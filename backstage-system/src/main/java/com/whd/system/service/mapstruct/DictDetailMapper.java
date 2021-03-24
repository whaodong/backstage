package com.whd.system.service.mapstruct;

import com.whd.base.BaseMapper;
import com.whd.system.domain.DictDetail;
import com.whd.system.service.dto.DictDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {DictSmallMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailMapper extends BaseMapper<DictDetailDto, DictDetail> {

}