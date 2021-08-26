package com.grokonez.jwtauthentication.DTO;
import com.grokonez.jwtauthentication.model.RoleName;
import lombok.Data ;
import lombok.Getter ;
import lombok.Setter ;
import lombok.NoArgsConstructor ;

@Data
@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private Long id;
    private RoleName name;

}
