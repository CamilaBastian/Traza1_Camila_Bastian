import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Setter
@Getter
@NoArgsConstructor
@ToString

public class Sucursal {

    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private boolean es_Casa_Matriz;
    private Domicilio domicilio;

    public Sucursal(String nombre, LocalTime horarioApertura, LocalTime horarioCierre, boolean es_Casa_Matriz, Domicilio domicilio) {
        this.nombre = nombre;
        this.horarioApertura = horarioApertura;
        this.horarioCierre = horarioCierre;
        this.es_Casa_Matriz = es_Casa_Matriz;
        this.domicilio = domicilio;
    }

    public String mostrarSucursal() {
        return "Se creó la sucursal: " + nombre + " (Localidad: " + domicilio.getLocalidad().getNombre() + ")";
    }

    @Override
    public String toString() {
        return nombre;
    }
}
