package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterDetails;
import com.alkemy.Disney.model.response.CharacterResponse;
import com.alkemy.Disney.model.response.ModelMovie;
import com.alkemy.Disney.model.response.ReponseCharMovie;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    @Autowired
    private ImageMapper imageMapper;

    public CharacterFilm characterDTO2Entity(CharacterRequest request) {
        return CharacterFilm.builder()
                .age(request.getAge())
                .deleted(Boolean.FALSE)
                .history(request.getHistory())
                .image_character(request.getImage_character())
                .movies(null)
                .weight(request.getWeight())
                .name_character(request.getName_character())
                .build();
    }

    public CharacterResponse characterEntity2DTO(CharacterFilm entity) {
        return CharacterResponse.builder()
                .id(entity.getId())             
                .name_character(entity.getName_character())               
                .image_character(imageMapper.imageEntity2ModelImage(entity.getImage_character()))                
                .build();
    }

    public CharacterFilm ToDto(CharacterFilm c, CharacterRequest request) {
        c.setAge(request.getAge());
        c.setHistory(request.getHistory());    
        c.setName_character(request.getName_character());
        c.setWeight(request.getWeight());
        //  c.setMovies();
        return c;
    }
    public ReponseCharMovie generateToCharacterMovie(CharacterFilm c){
        return ReponseCharMovie.builder()
                .id(c.getId())
                .name_character(c.getName_character())
                .build();
    }
    public CharacterDetails detailToDTO(CharacterFilm character, List<ModelMovie> movies){
        return CharacterDetails.builder()
                .id(character.getId())
                .name_character(character.getName_character())
                .age(character.getAge())
                .history(character.getHistory())
                .image_character(imageMapper.imageEntity2ModelImage(character.getImage_character()))
                .movies(movies)
                .build();
    }
}
