package com.alkemy.Disney.controller;

import com.alkemy.Disney.model.Entity.Role;
import com.alkemy.Disney.model.Entity.User;
import com.alkemy.Disney.model.request.UserRequest;
import com.alkemy.Disney.service.abstraction.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
@Api(value = "User Controller", description = "Crud basic for users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/me")
    @ApiOperation(value = "Get info user", notes = "Return a user info")
    public ResponseEntity<?> getMyUser() {
        try {
          User userInstance = (User) userService.getInfoUser();      
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(userInstance.getId()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }   
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user by id", notes = "Return a user by id")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {   
        return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
    }
    
    @GetMapping("/all")
    @ApiOperation(value = "Get all users", notes = "Return list users")
    public ResponseEntity<?> getAllUser() {     
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Update user", notes = "Return a user updated" )
    public ResponseEntity<?> update(@PathVariable Long id, 
            @RequestPart(value = "user", required = true) UserRequest request) throws NotFoundException {            
        return ResponseEntity.ok().body(userService.update(id, request));
    }
    @PostMapping("/rolesuser/{id}")
    @ApiOperation(value = "Update role user", notes = "Return a rol user updated" )
    public ResponseEntity<?> updateRoles(@PathVariable Long id, 
            @RequestBody List<Role> roleName) throws NotFoundException { 
        return ResponseEntity.ok().body(userService.updateRoles(id, roleName));
    }
    
   @GetMapping("/filter")
    public ResponseEntity<?> getDetailByFilters(
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String first_name,
            @RequestParam(required = false) String last_name,
            @RequestParam(required = false) String dni

    ){         
        return ResponseEntity.ok().body( userService.getByFilters(email,first_name,last_name,dni));
    }
    
}
