package com.whd.system.service.mapstruct;

import com.whd.system.domain.Dict;
import com.whd.system.service.dto.DictSmallDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-13T15:33:38+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class DictSmallMapperImpl implements DictSmallMapper {

    @Override
    public Dict toEntity(DictSmallDto dto) {
        if ( dto == null ) {
            return null;
        }

        Dict dict = new Dict();

        dict.setId( dto.getId() );

        return dict;
    }

    @Override
    public DictSmallDto toDto(Dict entity) {
        if ( entity == null ) {
            return null;
        }

        DictSmallDto dictSmallDto = new DictSmallDto();

        dictSmallDto.setId( entity.getId() );

        return dictSmallDto;
    }

    @Override
    public List<Dict> toEntity(List<DictSmallDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dict> list = new ArrayList<Dict>( dtoList.size() );
        for ( DictSmallDto dictSmallDto : dtoList ) {
            list.add( toEntity( dictSmallDto ) );
        }

        return list;
    }

    @Override
    public List<DictSmallDto> toDto(List<Dict> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DictSmallDto> list = new ArrayList<DictSmallDto>( entityList.size() );
        for ( Dict dict : entityList ) {
            list.add( toDto( dict ) );
        }

        return list;
    }
}
