package com.alkemy.Disney.service;

import com.alkemy.Disney.auth.exception.ParamNotFound;
import com.alkemy.Disney.auth.service.JwtUtil;
import com.alkemy.Disney.model.mapper.UserMapper;
import com.alkemy.Disney.model.Entity.ListRole;
import com.alkemy.Disney.model.Entity.Role;
import com.alkemy.Disney.model.Entity.User;
import com.alkemy.Disney.repository.IUserRepository;
import com.alkemy.Disney.model.request.UserAuthenticatedRequest;
import com.alkemy.Disney.model.request.UserRegisterRequest;
import com.alkemy.Disney.model.request.UserRequest;
import com.alkemy.Disney.model.response.UserAuthenticatedResponse;
import com.alkemy.Disney.model.response.UserRegisterResponse;
import com.alkemy.Disney.model.response.UserResponse;
import com.alkemy.Disney.model.response.UserRoleResponse;
import com.alkemy.Disney.service.abstraction.EmailService;
import com.alkemy.Disney.service.abstraction.IAuthenticationService;
import com.alkemy.Disney.service.abstraction.IRegisterUserService;
import com.alkemy.Disney.service.abstraction.IRoleService;
import com.alkemy.Disney.service.abstraction.IUserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl  implements UserDetailsService, IRegisterUserService, IAuthenticationService, IUserService  {
//   
    private static final String USER_NOT_FOUND_MESSAGE = "User not found.";
    private static final String USER_EMAIL_ERROR = "Email address is already used.";
    private static final String USER_LIST_ERROR = "Empty user list";

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private EmailService emailService;

    @Override
    public UserRegisterResponse register(UserRegisterRequest request, MultipartFile[] file) {
        if(userRepository.findByEmail(request.getEmail()) != null){
            throw new RuntimeException(USER_EMAIL_ERROR);
        }
        User user = (User) userMapper.userDto2Entity(request, file);  
        List<Role> roles = new ArrayList<>();     
        roles.add(roleService.findBy(ListRole.USER.getFullRoleName()));
        user.setRoles(roles);         
        User userCreate = userRepository.save(user);
         if (userCreate != null) {
            emailService.sendWelcomeEmail(userCreate.getUsername());
        }
        UserRegisterResponse userRegisterResponse = userMapper.userEntity2Dto(userCreate);
        userRegisterResponse.setToken(jwtUtil.generateTokenUser((UserDetails) userCreate));
        return userRegisterResponse;      
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return (UserDetails) getUser(email);
    }

    private User getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new EntityNotFoundException(USER_NOT_FOUND_MESSAGE);
        }
        return userOptional.get();
    }
//
    private User getUser(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE);
        }        
        return user;
    }

    @Override
    public UserAuthenticatedResponse authentication(UserAuthenticatedRequest request) {
       
        User user = getUser(request.getEmail());       
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        return new UserAuthenticatedResponse(jwtUtil.generateToken(user), user.getEmail(), user.getAuthorities());
    }

    //TODO: user me - info usuario log
    @Override
    public User getInfoUser() throws NotFoundException {
        Object userInstance = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(userInstance instanceof User){
            String username = ((User) userInstance).getUsername();//            
        }else{
            String username = userInstance.toString();
      }
        System.out.println("EL USSS ES: "+ userInstance.toString());
        return userRepository.findByEmail(userInstance.toString());
    }

    @Override
    public void delete(Long id) throws EntityNotFoundException {
        User user = getUser(id);
//        user.setDeleted(true);
       //auditoria
        userRepository.save(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest request) throws NotFoundException {
        Optional<User> entity = userRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("error: id Username is not valido");
        }       
        User entitySaved = userRepository.save(userMapper.userDtoEntity(entity.get(), request));
        return userMapper.convertTo(entitySaved);
    }

    
    @Override
    public UserRoleResponse updateRoles(Long id, List<Role> roleNames){
          Optional<User> entity = userRepository.findById(id);        
          if(!entity.isPresent()){
            throw new ParamNotFound("error: id Username is not valido");
          }          
        List<Role> rolesNew = new ArrayList<>();   
        for (Role role :roleNames){       
             rolesNew.add(roleService.findById(role.getId()));           
        }
           entity.get().setRoles(rolesNew);                    
          return userMapper.convertToUserRole(userRepository.save(entity.get()));
    }
    
    @Override
    public List<UserResponse> getByFilters(String email, String first_name, String last_name, String dni) {
        UserRegisterRequest filtersDto = new UserRegisterRequest(email,first_name,last_name,dni);
        
        List<UserResponse> response = new ArrayList<>();
//        List<User> users = (List<User>)  userRepository.findAll();        
//           for (User p: users){
//               if(p.getEmail().equals(filtersDto.getEmail()) ||
//                  p.getFirstName().equals(filtersDto.getFirst_name()) ||
//                  p.getLastName().equals(filtersDto.getLast_name()) || 
//                  p.getDni().equals(filtersDto.getDni())){
//                   
//                   response.add( userMapper.convertTo(p));
//               }
//           }
        return response;
    }
    
    
    @Override
    public UserResponse getById(Long id) {
        User user= getUser(id);
        return userMapper.convertTo(user);
    }
    
    @Transactional
    @Override
    public List<UserResponse> getAllUser() {
       return listAllUser(userRepository.findAll());
        
    }

    
    public List<UserResponse> listAllUser(List<User> entities) {
        List<UserResponse> listResponse = new ArrayList<>();
        if (entities.size() == 0) {
            throw new EntityNotFoundException(USER_LIST_ERROR);
        }
        for (User entity : entities) {
            listResponse.add(userMapper.convertTo(entity));
        }
        return listResponse;
    }
}
