package com.disney.disney.auth.service.abstraction;

import com.disney.disney.auth.request.UserAuthenticatedRequest;
import com.disney.disney.auth.response.UserAuthenticatedResponse;


public interface IAuthenticationService {
    UserAuthenticatedResponse authentication(UserAuthenticatedRequest request);
}
