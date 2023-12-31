package alledrogo.service.implementation;

import alledrogo.data.entity.UserEntity;
import alledrogo.data.repository.UserRepository;
import alledrogo.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * UserService Implementation class.
 * Overrides methods from UserService introducing further logic.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public UserEntity findByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() ->
                new EntityNotFoundException("User not found with username: " + username));
    }
    @Override
    public UserEntity findById(Long id){
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with id: " + id));
    }
    @Override
    public boolean existsByUsername(String username){return userRepository.existsByUsername(username);}
    @Override
    public boolean createUser(UserEntity userEntity){
        if (userRepository.existsByUsername(userEntity.getUsername())){
            return false;
        }else {
            return userEntity == userRepository.save(userEntity);
        }
    }
    @Override
    public boolean updateUser(UserEntity userEntity){
        if (userRepository.existsById(userEntity.getId())){
            return userEntity == userRepository.save(userEntity);
        }else {
            return false;
        }
    }
    @Override
    public boolean deleteUser(UserEntity userEntity){
        if (userRepository.existsById(userEntity.getId())) {
            userRepository.delete(userEntity);
            return true;
        }else {
            return false;
        }
    }

}
