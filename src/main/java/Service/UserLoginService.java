package Service;

import Model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserLoginService {
    User getUserDetails(String id);
}
