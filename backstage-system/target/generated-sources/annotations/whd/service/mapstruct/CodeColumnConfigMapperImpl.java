package whd.service.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import whd.domain.CodeColumnConfig;
import whd.service.dto.CodeColumnConfigDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-14T16:47:59+0800",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_191 (Oracle Corporation)"
)
@Component
public class CodeColumnConfigMapperImpl implements CodeColumnConfigMapper {

    @Override
    public CodeColumnConfig toEntity(CodeColumnConfigDto dto) {
        if ( dto == null ) {
            return null;
        }

        CodeColumnConfig codeColumnConfig = new CodeColumnConfig();

        codeColumnConfig.setColumnId( dto.getColumnId() );
        codeColumnConfig.setTableName( dto.getTableName() );
        codeColumnConfig.setColumnName( dto.getColumnName() );
        codeColumnConfig.setColumnType( dto.getColumnType() );
        codeColumnConfig.setDictName( dto.getDictName() );
        codeColumnConfig.setExtra( dto.getExtra() );
        codeColumnConfig.setFormShow( dto.getFormShow() );
        codeColumnConfig.setFormType( dto.getFormType() );
        codeColumnConfig.setKeyType( dto.getKeyType() );
        codeColumnConfig.setListShow( dto.getListShow() );
        codeColumnConfig.setNotNull( dto.getNotNull() );
        codeColumnConfig.setQueryType( dto.getQueryType() );
        codeColumnConfig.setRemark( dto.getRemark() );
        codeColumnConfig.setDateAnnotation( dto.getDateAnnotation() );

        return codeColumnConfig;
    }

    @Override
    public CodeColumnConfigDto toDto(CodeColumnConfig entity) {
        if ( entity == null ) {
            return null;
        }

        CodeColumnConfigDto codeColumnConfigDto = new CodeColumnConfigDto();

        codeColumnConfigDto.setColumnId( entity.getColumnId() );
        codeColumnConfigDto.setTableName( entity.getTableName() );
        codeColumnConfigDto.setColumnName( entity.getColumnName() );
        codeColumnConfigDto.setColumnType( entity.getColumnType() );
        codeColumnConfigDto.setDictName( entity.getDictName() );
        codeColumnConfigDto.setExtra( entity.getExtra() );
        codeColumnConfigDto.setFormShow( entity.getFormShow() );
        codeColumnConfigDto.setFormType( entity.getFormType() );
        codeColumnConfigDto.setKeyType( entity.getKeyType() );
        codeColumnConfigDto.setListShow( entity.getListShow() );
        codeColumnConfigDto.setNotNull( entity.getNotNull() );
        codeColumnConfigDto.setQueryType( entity.getQueryType() );
        codeColumnConfigDto.setRemark( entity.getRemark() );
        codeColumnConfigDto.setDateAnnotation( entity.getDateAnnotation() );

        return codeColumnConfigDto;
    }

    @Override
    public List<CodeColumnConfig> toEntity(List<CodeColumnConfigDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CodeColumnConfig> list = new ArrayList<CodeColumnConfig>( dtoList.size() );
        for ( CodeColumnConfigDto codeColumnConfigDto : dtoList ) {
            list.add( toEntity( codeColumnConfigDto ) );
        }

        return list;
    }

    @Override
    public List<CodeColumnConfigDto> toDto(List<CodeColumnConfig> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CodeColumnConfigDto> list = new ArrayList<CodeColumnConfigDto>( entityList.size() );
        for ( CodeColumnConfig codeColumnConfig : entityList ) {
            list.add( toDto( codeColumnConfig ) );
        }

        return list;
    }
}
