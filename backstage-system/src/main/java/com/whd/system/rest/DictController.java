package com.whd.system.rest;

import com.whd.exception.BadRequestException;
import com.whd.system.domain.Dict;
import com.whd.system.service.DictService;
import com.whd.system.service.dto.DictQueryCriteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Api(tags = "系统：字典管理")
@RequestMapping("/api/dict")
public class DictController {

    private final DictService dictService;
    private static final String ENTITY_NAME = "dict";

    @ApiOperation("导出字典数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, DictQueryCriteria criteria) throws IOException {
        dictService.download(dictService.queryAll(criteria), response);
    }

    @ApiOperation("查询字典")
    @GetMapping(value = "/all")
    public ResponseEntity<Object> queryAll(){
        return new ResponseEntity<>(dictService.queryAll(new DictQueryCriteria()),HttpStatus.OK);
    }

    @ApiOperation("查询字典")
    @GetMapping
    public ResponseEntity<Object> query(DictQueryCriteria resources, Pageable pageable){
        return new ResponseEntity<>(dictService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @ApiOperation("新增字典")
    @PostMapping
    public ResponseEntity<Object> create(@Validated @RequestBody Dict resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        dictService.create(resources);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("修改字典")
    @PutMapping
    public ResponseEntity<Object> update(@Validated(Dict.Update.class) @RequestBody Dict resources){
        dictService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ApiOperation("删除字典")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Set<Long> ids){
        dictService.delete(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}