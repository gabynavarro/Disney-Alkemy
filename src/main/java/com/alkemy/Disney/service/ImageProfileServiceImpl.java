package com.alkemy.Disney.service;

import com.alkemy.Disney.service.abstraction.IImageProfileService;
import org.springframework.stereotype.Service;


@Service
public class ImageProfileServiceImpl implements IImageProfileService {

//    private static final String IMAGE_PROFILE_NOT_FOUND_MESSAGE = "Image not found.";
//
//    @Autowired
//    private ImageMapper imageMapper;
//    @Autowired
//    private IImageProfileRepository imageProfileRepository;
//
//    @Override
//    public ImageProfileRequest save(ImageProfileRequest imageProfileRequest) {
//        ImageProfile entity = imageMapper.imageProfileDto2Entity(imageProfileRequest);
//        ImageProfile entitySaved = imageProfileRepository.save(entity);
//        ImageProfileRequest result = imageMapper.imageProfileEntity2Dto(entitySaved);
//        return result;
//    }
//
//    @Override
//    public ImageProfile getImageProfile(String imageProfileId) {
//        Optional<ImageProfile> imageProfileOptional = imageProfileRepository.findByName(imageProfileId);
//        if (imageProfileOptional.isEmpty()) {
//            throw new EntityNotFoundException(IMAGE_PROFILE_NOT_FOUND_MESSAGE);
//        }
//        return imageProfileOptional.get();
//    }
//
//    @Override
//    public ImageProfile getImage(ImageProfile imageProfile) {
//        return null;
//    }




}
