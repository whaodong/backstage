package com.whd.system.service.mapstruct;

import com.whd.system.domain.DictDetail;
import com.whd.system.service.dto.DictDetailDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T15:33:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DictDetailMapperImpl implements DictDetailMapper {

    @Autowired
    private DictSmallMapper dictSmallMapper;

    @Override
    public DictDetail toEntity(DictDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setCreateBy( dto.getCreateBy() );
        dictDetail.setCreateTime( dto.getCreateTime() );
        dictDetail.setUpdateTime( dto.getUpdateTime() );
        dictDetail.setId( dto.getId() );
        dictDetail.setDict( dictSmallMapper.toEntity( dto.getDict() ) );
        dictDetail.setLabel( dto.getLabel() );
        dictDetail.setValue( dto.getValue() );
        dictDetail.setDictSort( dto.getDictSort() );

        return dictDetail;
    }

    @Override
    public DictDetailDto toDto(DictDetail entity) {
        if ( entity == null ) {
            return null;
        }

        DictDetailDto dictDetailDto = new DictDetailDto();

        dictDetailDto.setCreateBy( entity.getCreateBy() );
        dictDetailDto.setCreateTime( entity.getCreateTime() );
        dictDetailDto.setUpdateTime( entity.getUpdateTime() );
        dictDetailDto.setId( entity.getId() );
        dictDetailDto.setDict( dictSmallMapper.toDto( entity.getDict() ) );
        dictDetailDto.setLabel( entity.getLabel() );
        dictDetailDto.setValue( entity.getValue() );
        dictDetailDto.setDictSort( entity.getDictSort() );

        return dictDetailDto;
    }

    @Override
    public List<DictDetail> toEntity(List<DictDetailDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DictDetail> list = new ArrayList<DictDetail>( dtoList.size() );
        for ( DictDetailDto dictDetailDto : dtoList ) {
            list.add( toEntity( dictDetailDto ) );
        }

        return list;
    }

    @Override
    public List<DictDetailDto> toDto(List<DictDetail> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DictDetailDto> list = new ArrayList<DictDetailDto>( entityList.size() );
        for ( DictDetail dictDetail : entityList ) {
            list.add( toDto( dictDetail ) );
        }

        return list;
    }
}
