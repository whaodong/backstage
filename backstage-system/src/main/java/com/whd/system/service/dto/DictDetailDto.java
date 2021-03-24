package com.whd.system.service.dto;

import com.whd.base.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class DictDetailDto extends BaseDTO implements Serializable {

    private Long id;

    private DictSmallDto dict;

    private String label;

    private String value;

    private Integer dictSort;
}