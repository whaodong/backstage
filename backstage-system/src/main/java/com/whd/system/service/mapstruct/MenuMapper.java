package com.whd.system.service.mapstruct;

import com.whd.system.domain.Menu;
import com.whd.system.service.dto.MenuDto;
import com.whd.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends BaseMapper<MenuDto, Menu> {
}
