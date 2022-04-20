package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.request.UserAuthenticatedRequest;
import com.alkemy.Disney.model.response.UserAuthenticatedResponse;


public interface IAuthenticationService {
    UserAuthenticatedResponse authentication(UserAuthenticatedRequest request);
}
