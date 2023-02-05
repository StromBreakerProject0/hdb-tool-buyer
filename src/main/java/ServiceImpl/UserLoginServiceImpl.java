package ServiceImpl;

import Excetion.ApiException;
import Model.User;
import Repository.UserRepository;
import Service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User getUserDetails(String id) {
        User user = null;
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            user = new User();
            user = optionalUser.get();
        }else{
            throw new ApiException("No User Found With given User Id:"+id);
        }
        return user;
    }
}
