import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@ToString


public class Provincia {

    private String nombre;
    private List<Localidad> localidad = new ArrayList<>();

    public Provincia(String nombre) {
        this.nombre = nombre;
        this.localidad = new ArrayList<>();
    }

    public void agregarLocalidad(Localidad localidad){
        this.localidad.add(localidad);
    }

    public String mostrarProvincia() {
        return "\n⦿Se creó la provincia: " + nombre + " y sus localidades son: \n" + localidad + "";
    }

    @Override
    public String toString() {
        return nombre;
    }


}
