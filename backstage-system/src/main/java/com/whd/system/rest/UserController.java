package com.whd.system.rest;

import com.whd.system.service.UserService;
import com.whd.system.service.dto.UserDto;
import com.whd.system.service.dto.UserQueryCriteria;
import common.utils.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "系统：用户管理")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ApiOperation("查询用户")
    @GetMapping
    public ResponseEntity<Object> query(UserQueryCriteria criteria, Pageable pageable){
        List<UserDto> userDtos = userService.queryAll(criteria);
        return new ResponseEntity<>(PageUtil.toPage(userDtos,0),HttpStatus.OK);
    }
}
