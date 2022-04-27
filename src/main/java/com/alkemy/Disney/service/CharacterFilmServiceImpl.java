package com.alkemy.Disney.service;
        
import com.alkemy.Disney.model.Entity.CharacterFilm;
import com.alkemy.Disney.model.Entity.Image;
import com.alkemy.Disney.model.Entity.Movie;
import com.alkemy.Disney.model.mapper.CharacterMapper;
import com.alkemy.Disney.model.mapper.MovieMapper;
import com.alkemy.Disney.model.request.CharacterRequest;
import com.alkemy.Disney.model.request.FilterRequest;
import com.alkemy.Disney.model.response.CharacterDetails;
import com.alkemy.Disney.model.response.CharacterResponse;
import com.alkemy.Disney.repository.CharacterFilmRepository;
import com.alkemy.Disney.repository.especifications.CharacterSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.alkemy.Disney.service.abstraction.CharacterFilmService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
    @Autowired
    private MovieMapper muvieMapper;
    @Autowired
    private CharacterSpecification characterSpecification;
    
    @Transactional
    @Override
    public CharacterResponse save (CharacterRequest request, Image image){             
        request.setImage_character(image);
        CharacterFilm entitySaved = characterRepository.save(characterMapper.characterDTO2Entity(request));
        
        CharacterResponse result = characterMapper.characterEntity2DTO(entitySaved);
        return result;
    }
 

    public void delete(Long id) { 
        CharacterFilm characterId = characterRepository.findById(id).orElseThrow();
        characterId.setDeleted(true);
        characterRepository.save(characterId); 
    
    }
     @Override
    public void update(Long id, CharacterRequest request) {
        CharacterFilm characterId = characterRepository.findById(id).orElseThrow();              
        characterRepository.save(characterMapper.ToDto(characterId, request));
    }




    @Override
    public List<CharacterResponse> getAllCharacters() {
          return characterRepository.findAll().stream()
                .map( i -> characterMapper.characterEntity2DTO(i) )
                .collect(Collectors.toList());
    }

    @Override
    public CharacterDetails findById(Long id) {
        CharacterFilm chart=characterRepository.findById(id).orElseThrow();
        List movieList=new ArrayList();        
        for (Movie m : chart.getMovies()) {
            movieList.add(muvieMapper.toModelMovie(m));
        }
        return characterMapper.detailToDTO(chart,movieList);

    }

    @Override
    public List<CharacterResponse> getByFilters(String name_character, Integer age, Set<Long> idFilm) {        
        FilterRequest filtersDTO = new FilterRequest(name_character, age, idFilm);
        List<CharacterFilm> entities = characterRepository.findAll(characterSpecification.getFiltered(filtersDTO));
        return entities.stream()
                .map(i->characterMapper.characterEntity2DTO(i))
                .collect(Collectors.toList()); 
       
    }
}
