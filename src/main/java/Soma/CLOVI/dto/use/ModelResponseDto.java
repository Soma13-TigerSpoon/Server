package Soma.CLOVI.dto.use;

import Soma.CLOVI.domain.Model;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
public class ModelResponseDto {

    private Long id;
    private String name;
    private float height_cm;
    private float weight_kg;
    private String gender;

    public ModelResponseDto(Model model){
        this.id = model.getId();
        this.name = model.getName();
        this.height_cm = model.getHeight_cm();
        this.weight_kg = model.getWeight_kg();
        this.gender = model.getGender().name();
    }
}
