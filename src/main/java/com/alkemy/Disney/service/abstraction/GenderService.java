package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.ImageProfile;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import java.util.List;


public interface GenderService {
    GenderResponse save(GenderRequest request, ImageProfile image );

    List<GenderResponse> getGenders();

    void update(Long id, GenderRequest request);

    void delete(Long id);

    Gender getGender(Long Id);
}
