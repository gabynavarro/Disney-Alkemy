package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterDetails;
import com.alkemy.Disney.model.response.CharacterResponse;
import java.util.List;


public interface CharacterFilmService {
    
    public CharacterResponse save (CharacterRequest request, Image image);
    public List<CharacterResponse> getAllCharacters();
    void update(Long id, CharacterRequest request);
    void delete(Long id);
    public CharacterDetails findById(Long id);
}
