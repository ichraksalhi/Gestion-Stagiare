package com.grokonez.jwtauthentication.DTO;
import lombok.Data ;
import lombok.Getter ;
import lombok.Setter ;
import lombok.NoArgsConstructor ;

@Data
@Getter
@Setter
@NoArgsConstructor
public class SujetDto {

    private long Id_Sujet;
    private String Titre_Sujet ;
    private String Description_Sujet;
}
