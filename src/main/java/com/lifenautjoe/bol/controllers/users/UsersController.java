package com.lifenautjoe.bol.controllers.users;

import com.lifenautjoe.bol.Mappings;
import com.lifenautjoe.bol.controllers.ApiResponse;
import com.lifenautjoe.bol.controllers.users.requests.LoginRequestBody;
import com.lifenautjoe.bol.controllers.users.responses.IsLoggedInResponse;
import com.lifenautjoe.bol.controllers.users.responses.LoginResponseBody;
import com.lifenautjoe.bol.domain.User;
import com.lifenautjoe.bol.services.users.UserAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = Mappings.API_USERS)
public class UsersController {

    private UserAuthenticationService userAuthenticationService;

    @Autowired
    public UsersController(UserAuthenticationService userAuthenticationService) {
        this.userAuthenticationService = userAuthenticationService;
    }

    @RequestMapping(path = Mappings.API_USERS_LOGIN, method = RequestMethod.POST)
    public ResponseEntity<Object> login(@Validated @RequestBody LoginRequestBody body, HttpSession httpSession) {

        String userName = body.getUserName();

        ResponseEntity response;

        if (userAuthenticationService.isLoggedInForSession(httpSession)) {
            response = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("Already logged in"));
        } else if (userAuthenticationService.userWithNameExists(userName)) {
            response = ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(new ApiResponse("User name already taken"));
        } else {
            User user = userAuthenticationService.loginUserForSession(body.getUserName(), httpSession);
            response = ResponseEntity.ok().body(new LoginResponseBody(user.getName()));
        }

        return response;
    }

    @RequestMapping(path = Mappings.API_USERS_LOGOUT, method = RequestMethod.POST)
    public ResponseEntity<Object> logout(HttpSession httpSession) {

        ResponseEntity response;

        if (userAuthenticationService.isLoggedInForSession(httpSession)) {
            userAuthenticationService.logoutUserForSession(httpSession);
            response = ResponseEntity.ok().body(new ApiResponse("User successfully logged out"));
        } else {
            response = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse("User not logged in"));
        }

        return response;
    }

    @RequestMapping(path = Mappings.API_USERS_IS_LOGGED_IN, method = RequestMethod.POST)
    public ResponseEntity<IsLoggedInResponse> isLoggedIn(HttpSession httpSession) {

        ResponseEntity response;

        boolean isLoggedIn = userAuthenticationService.isLoggedInForSession(httpSession);

        if (isLoggedIn) {
            User user = userAuthenticationService.getLoggedInUserForSession(httpSession);
            return ResponseEntity.ok().body(new IsLoggedInResponse(isLoggedIn, user.getName()));
        }

        return ResponseEntity.ok().body(new IsLoggedInResponse(isLoggedIn));
    }
}
