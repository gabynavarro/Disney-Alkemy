package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.repository.GenderRepository;
import com.alkemy.Disney.service.abstraction.GenderService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenderServiceImpl implements GenderService {
    
    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;
    
    @Transactional
    @Override
    public GenderResponse save(GenderRequest request, Image image) {
        request.setImage_gender(image);           
        return genderMapper.genderToResponse(genderRepository.save(genderMapper.toGender(request)));
    }
    
    

    @Override
    public List<GenderResponse> getGenders() {
        return genderRepository.findAll().stream()
                .map( i -> genderMapper.genderToResponse(i) )
                .collect(Collectors.toList());
    }

    @Override
    public void update(Long id, GenderRequest request) {
        Gender denderId = genderRepository.findById(id).orElseThrow();
        denderId.setName_gender(request.getName_gender());
       genderRepository.save(denderId);
    }

    
    @Override
    public void delete(Long id) {
        Gender genderId = genderRepository.findById(id).orElseThrow();
        genderId.setDeleted(true);
        genderRepository.save(genderId);
    }

    @Override
    public GenderResponse getGender(Long Id) {
       return genderMapper.genderToResponse(genderRepository.findById(Id).orElseThrow());
    }
    
}
