package com.disney.disney.auth.controller;



import com.disney.disney.auth.request.UserAuthenticatedRequest;
import com.disney.disney.auth.request.UserRegisterRequest;
import com.disney.disney.auth.service.abstraction.IAuthenticationService;
import com.disney.disney.auth.service.abstraction.IRegisterUserService;
import com.disney.disney.auth.service.abstraction.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@Api(value = "Authentication controller", description = "This API has a Authenticated for users")
public class AuthenticationController {

    @Autowired
    private IRegisterUserService registerUserService;
//
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;
//
    @PostMapping("/register")
    @ApiOperation(value = "Register user", notes = "Return a user register" )
    public ResponseEntity<?> register(@RequestPart(value = "user", required = true) UserRegisterRequest request, 
            @RequestPart(value = "image", required = false) MultipartFile[] file) {       
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUserService.register(request, file));
    }      
    
    @PostMapping("/login")
    @ApiOperation(value = "Login user", notes = "Return email, role and token" )
    public ResponseEntity<?> login(@Valid @RequestBody UserAuthenticatedRequest request){       
        return ResponseEntity.ok(authenticationService.authentication(request));
    }

}
