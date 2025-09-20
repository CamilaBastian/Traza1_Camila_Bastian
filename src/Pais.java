import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString


public class Pais {

    private String nombre;
    private List<Provincia> provincias = new ArrayList<>();


    public Pais(String nombre) { //constructor
        this.nombre = nombre;
        this.provincias = new ArrayList<>();
    }

    public void agregarProvincia(Provincia provincia) {
        this.provincias.add(provincia);
    }

    public String mostrarPais() {
        return  "\n⦿Se creo el país: " + nombre + " y las provincias de este país son: \n" + provincias;
    }

}
