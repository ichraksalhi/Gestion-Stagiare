package com.grokonez.jwtauthentication.DTO;
import java.util.Date ;
import lombok.Data ;
import lombok.Getter ;
import lombok.Setter ;
import lombok.NoArgsConstructor ;

@Data
@Getter
@Setter
@NoArgsConstructor
public class TechnologieDto {
    private long Id_Techno;
    private String titre_techno ;
    private String Description_techno ;
    private Date Date_Techno ;
}
