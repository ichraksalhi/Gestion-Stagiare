package com.grokonez.jwtauthentication.DTO;
import org.springframework.format.annotation.DateTimeFormat ;
import lombok.Data ;
import lombok.Getter ;
import lombok.Setter ;
import lombok.NoArgsConstructor ;

@Data
@Getter
@Setter
@NoArgsConstructor
public class StageDto {
    private long Id_Stage ;
    private String TitreStage;
    private String DescriptionStage;
    private DateTimeFormat DateD ;
    private  int PeriodStage;
}
