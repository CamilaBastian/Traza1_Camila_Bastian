import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;
    private List<Sucursal> sucursal = new ArrayList<>();

    public Empresa(String nombre, String razonSocial, Integer cuit, String logo) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.logo = logo;
        this.sucursal = new ArrayList<>();
    }

    public void agregarSucursal(Sucursal sucursal) {
        this.sucursal.add(sucursal);
    }

    public String mostrarEmpresa() {
        return "\n⦿Se creó la empresa: " + nombre + " con sucursales: \n" + sucursal + " ; ";
    }

    @Override
    public String toString() {
        return nombre;
    }
}