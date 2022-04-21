package com.alkemy.Disney.service.abstraction;

import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterResponse;
import org.springframework.web.multipart.MultipartFile;


public interface CharacterFilmService {
    
    public CharacterResponse save (CharacterRequest request, Image image);
    //List<CharacterBasicDTO> getAllIcons();
   // List<CharacterResponse> getAllIconsDetailed();
    void delete(Long id);
    //CharacterResponse update(Long id, CharacterRequest request);
    //List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> idFilm);
}
