package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterDetails;
import com.alkemy.Disney.model.response.CharacterResponse;
import java.util.List;
import java.util.Set;


public interface CharacterFilmService {
    
    public CharacterResponse save (CharacterRequest request, Image image);
    public List<CharacterResponse> getAllCharacters();
    void update(Long id, CharacterRequest request);
    void delete(Long id);
    public CharacterDetails findById(Long id);
    public List<CharacterResponse> getByFilters(String name, Integer age, Set<Long> idFilm);
}
