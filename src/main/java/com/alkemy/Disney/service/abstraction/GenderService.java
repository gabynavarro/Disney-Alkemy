package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import java.util.List;


public interface GenderService {
    GenderResponse save(GenderRequest request, Image image );

    List<GenderResponse> getGenders();

    void update(Long id, GenderRequest request);

    void delete(Long id);

    GenderResponse getGender(Long Id);
}
