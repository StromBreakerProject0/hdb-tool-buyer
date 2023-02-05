package Controller;

import Constant.ErrorConstant;
import Excetion.ApiException;
import Model.User;
import Service.UserLoginService;
import VO.ApiResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/login")
public class UserLoginController {

    private static Logger log = Logger.getLogger(UserLoginController.class);

    @Autowired
    UserLoginService userLoginService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserDetails(@PathVariable String id){
        User user = null;
        try {
            user = userLoginService.getUserDetails(id);
        }catch (ApiException e){
            log.error("Exception", e);
            return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            log.error("Exception", e);
            return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  new ResponseEntity<>(new ApiResponse(user, ErrorConstant.SUCESS), HttpStatus.OK);
    }


}
