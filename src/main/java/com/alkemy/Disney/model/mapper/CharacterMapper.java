package com.alkemy.Disney.model.mapper;

import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {
   
    @Autowired
    private ImageMapper imageMapper;

    public CharacterFilm characterDTO2Entity(CharacterRequest request) {
      
       return  CharacterFilm.builder()
               .age(request.getAge())
               .deleted(Boolean.FALSE)
               .history(request.getHistory())
               .image_character(request.getImage_character())
               .associated_movies(null)
               .weight(request.getWeight())
               .name_character(request.getName_character())
               .build();  
       }

    public CharacterResponse characterEntity2DTO(CharacterFilm entity) {
        
        return CharacterResponse.builder()
                .id(entity.getId())
                .deleted(entity.isDeleted())
                .age(entity.getAge())
                .history(entity.getHistory())
                .name_character(entity.getName_character())
                .weight(entity.getWeight())
                .image_character(imageMapper.imageEntity2ModelImage(entity.getImage_character()))
                .associated_movies(null)                
                .build();      
      
      }

//    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
//        List<CharacterBasicDTO> dtos = new ArrayList<>();
//        CharacterBasicDTO basicDTO;
//        for (CharacterEntity entity : entities) {
//            basicDTO = new CharacterBasicDTO();
//            basicDTO.setId(entity.getId());
//            basicDTO.setImage(entity.getImage());
//            basicDTO.setName(entity.getName());
//            dtos.add(basicDTO);
//        }
//        return dtos;
//    }
//
//    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadFilms) {
//        List<CharacterDTO> dtos = new ArrayList<>();
//        for (CharacterEntity entity : entities) {
//            dtos.add(characterEntity2DTO(entity, loadFilms));
//        }
//        return dtos;
//    }
//
//    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtos) {
//        List<CharacterEntity> charactersEntities = new ArrayList<>();
//        for (CharacterDTO dto : dtos){
//            charactersEntities.add(characterDTO2Entity(dto, false));
//        }
//        return charactersEntities;
//    }
//
//    public void characterEntityRefreshValues(CharacterEntity characterEntity, CharacterDTO dto) {
//        characterEntity.setImage(dto.getImage());
//        characterEntity.setName(dto.getName());
//        characterEntity.setAge(dto.getAge());
//        characterEntity.setWeight(dto.getWeight());
//        characterEntity.setHistory(dto.getHistory());
//    }
}
