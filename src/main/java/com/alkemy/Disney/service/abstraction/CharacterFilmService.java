package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterResponse;
import java.util.List;


public interface CharacterFilmService {
    
    public CharacterResponse save (CharacterRequest request, Image image);
    public List<CharacterResponse> getAllCharacters();
    void update(Long id, CharacterRequest request);
   // List<CharacterResponse> getAllIconsDetailed();
    void delete(Long id);
    //CharacterResponse update(Long id, CharacterRequest request);
    //List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> idFilm);
    public CharacterResponse findById(Long id);
}
