package com.alkemy.Disney.service;
        
import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.mapper.CharacterMapper;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.response.CharacterResponse;
import com.alkemy.Disney.repository.CharacterFilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.alkemy.Disney.service.abstraction.CharacterFilmService;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class CharacterFilmServiceImpl implements CharacterFilmService{
    
    @Autowired
    private CharacterMapper characterMapper;
     @Autowired
    private CharacterFilmRepository characterRepository;
//    @Autowired
//    private CharacterSpecification characterSpecification;
  
    @Transactional
    @Override
    public CharacterResponse save (CharacterRequest request, Image image){             
        request.setImage_character(image);
        CharacterFilm entitySaved = characterRepository.save(characterMapper.characterDTO2Entity(request));
        
        CharacterResponse result = characterMapper.characterEntity2DTO(entitySaved);
        return result;
    }
 

//    public List<ResponseCharacter> getAllIconsDetailed() {
//        List<CharacterEntity> entities = characterRepository.findAll();
//        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, true);
//        return result;
//    }

    public void delete(Long id) { 
        CharacterFilm characterId = characterRepository.findById(id).orElseThrow();
        characterId.setDeleted(true);
        characterRepository.save(characterId); 
    
    }
     @Override
    public void update(Long id, CharacterRequest request) {
        CharacterFilm denderId = characterRepository.findById(id).orElseThrow();
//        denderId.setName_gender(request.getName_gender());
        characterRepository.save(denderId);
    }



//    public List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> idFilm) {
//        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, idFilm);
//        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
//        List<CharacterDTO> dtos = characterMapper.characterEntityList2DTOList(entities, true);
//        return dtos;
//    }

    @Override
    public List<CharacterResponse> getAllCharacters() {
          return characterRepository.findAll().stream()
                .map( i -> characterMapper.characterEntity2DTO(i) )
                .collect(Collectors.toList());
    }

    @Override
    public CharacterResponse findById(Long id) {
        return characterMapper.characterEntity2DTO(characterRepository.findById(id).orElseThrow());

    }
}
