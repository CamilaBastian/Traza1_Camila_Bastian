import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class Localidad {

    public String nombre;
    private List<Domicilio> domicilio = new ArrayList<>();

    public Localidad(String nombre) {
        this.nombre = nombre;
        this.domicilio = new ArrayList<>();
    }


    public void agregarDomiicilio(Domicilio domicilio) {
        this.domicilio.add(domicilio);
    }

    public String mostrarLocalidad() {
        return "\n⦿Se creó la localidad: " + nombre + " con domicilios: \n" + domicilio + " ; ";
    }

    @Override
    public String toString() {
        return nombre;
    }


}
