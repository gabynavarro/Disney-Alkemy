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
    //remplazar por buscar MovieId
//    public List<Movie> listMovie(Long id){
//        
//        
//    }

//    public List<CharacterBasicDTO> getAllIcons() {
//        List<CharacterEntity> entities = characterRepository.findAll();
//        List<CharacterBasicDTO> result = characterMapper.characterEntityList2BasicDTOList(entities);
//        return result;
//    }

//    public List<CharacterDTO> getAllIconsDetailed() {
//        List<CharacterEntity> entities = characterRepository.findAll();
//        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, true);
//        return result;
//    }

    public void delete(Long id) { characterRepository.deleteById(id); }

//    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
//        Optional<CharacterEntity> entity = characterRepository.findById(id);
//        if (!entity.isPresent()) {
//            throw new ParamNotFound("Error: Invalid character id");
//        }
//        characterMapper.characterEntityRefreshValues(entity.get(), characterDTO);
//        CharacterEntity entitySaved = characterRepository.save(entity.get());
//        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved, false);
//        return result;
//    }

//    public List<CharacterDTO> getByFilters(String name, Integer age, Set<Long> idFilm) {
//        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, idFilm);
//        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
//        List<CharacterDTO> dtos = characterMapper.characterEntityList2DTOList(entities, true);
//        return dtos;
//    }
}
