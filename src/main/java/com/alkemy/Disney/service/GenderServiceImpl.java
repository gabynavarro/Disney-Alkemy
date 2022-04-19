package com.alkemy.Disney.service;

import com.alkemy.Disney.model.Entity.Gender;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.mapper.GenderMapper;
import com.alkemy.Disney.model.request.GenderRequest;
import com.alkemy.Disney.model.response.GenderResponse;
import com.alkemy.Disney.repository.GenderRepository;
import com.alkemy.Disney.service.abstraction.GenderService;
import java.util.List;
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
    private GenderRepository GenderRepository;
    
    @Transactional
    @Override
    public GenderResponse save(GenderRequest request, Image image) {
        request.setImage_gender(image);    
        return genderMapper.GenderToResponse(GenderRepository.save(genderMapper.toGender(request)));
    }
    
    

    @Override
    public List<GenderResponse> getGenders() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Long id, GenderRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Gender getGender(Long Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
