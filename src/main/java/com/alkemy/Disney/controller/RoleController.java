package com.alkemy.Disney.controller;

import com.alkemy.Disney.service.abstraction.IRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/role")
@Api(value = "Role Controller", description = "Crud basic for roles")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all roles", notes = "Return listroless")
    public ResponseEntity<?> getAllRole() {
        return ResponseEntity.status(HttpStatus.OK).body(roleService.findAll());
    }
}
