package com.grokonez.jwtauthentication.controller;


import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.RoleRepository;
import com.grokonez.jwtauthentication.repository.UserRepository;
import com.grokonez.jwtauthentication.security.jwt.JwtProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.grokonez.jwtauthentication.model.Role ;
import com.grokonez.jwtauthentication.model.RoleName ;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test/admin")
public class userAPIs {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @GetMapping("/afficher")
    public List<User> getAllUsers() { return userRepository.findAll();}

    // affichage avec condition pour amin etape 1 AFFICHE STAGAIRE
    //etape 2 test avec postman

    @GetMapping("/afficher Stagaire ")
   public List<User>findByRoles_NameEquals() { return userRepository.findByRoles_NameEquals(RoleName.ROLE_USER);}


    @DeleteMapping("/delete/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws org.springframework.data.rest.webmvc.ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("user not found for this id :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws org.springframework.data.rest.webmvc.ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("Employee not found for this id :: " + userId));
        return ResponseEntity.ok().body(user);
    }

}
