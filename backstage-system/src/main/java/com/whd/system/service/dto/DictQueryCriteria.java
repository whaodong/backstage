package com.whd.system.service.dto;

import com.whd.annotation.Query;
import lombok.Data;

@Data
public class DictQueryCriteria {

    @Query(blurry = "name,description")
    private String blurry;
}
