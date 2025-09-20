import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Domicilio {

    private String calle;
    private Integer numero;
    private Integer cp;
    private Localidad localidad;

    public Domicilio(String calle, Integer numero, Integer cp, Localidad localidad) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
    }

    public String mostrarDomicilio() {
        return "Se creó el domicilio: " + calle + numero + cp;
    }

}
