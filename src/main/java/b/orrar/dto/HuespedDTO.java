package b.orrar.dto;

import java.util.List;

import b.orrar.model.Reserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HuespedDTO {
    
    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private List<Reserva> reservas;
}
