package com.grokonez.jwtauthentication.DTO;
import com.grokonez.jwtauthentication.model.Status ;
import com.grokonez.jwtauthentication.model.RoleName  ;
import lombok.Data ;
import lombok.Getter ;
import lombok.Setter ;
import lombok.NoArgsConstructor ;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDto {



        private Long id;
        private String name;
        private String username;
        private String email;
        private String password;
        private String cin;
        private String phone;
        private Status status ;
    private RoleName Roles ;
    }

