package com.disney.disney.auth.service.abstraction;

import com.disney.disney.auth.request.UserRegisterRequest;
import com.disney.disney.auth.response.UserRegisterResponse;
import org.springframework.web.multipart.MultipartFile;



public interface IRegisterUserService {

    UserRegisterResponse register(UserRegisterRequest request, MultipartFile[] file);
}
