package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.request.UserRegisterRequest;
import com.alkemy.Disney.model.response.UserRegisterResponse;
import org.springframework.web.multipart.MultipartFile;



public interface IRegisterUserService {

    UserRegisterResponse register(UserRegisterRequest request, MultipartFile[] file);
}
