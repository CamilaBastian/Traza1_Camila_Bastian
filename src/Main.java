import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Main {

    // Declara e inicializa el repositorio
    private static InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();

    public static void main(String[] args) {

        //Creacion de pais
        Pais Argentina = new Pais("Argentina");



        //Creacion de provincias y agregar
        Provincia BuenosAires = new Provincia("Buenos Aires");
        Argentina.agregarProvincia(BuenosAires);

        Provincia Cordoba = new Provincia("Córdoba");
        Argentina.agregarProvincia(Cordoba);


        //Creacion de localidades y agregar

        Localidad CABA = new Localidad("CABA");
        BuenosAires.agregarLocalidad(CABA);
        Localidad laPlata = new Localidad("La Plata");
        BuenosAires.agregarLocalidad(laPlata);

        Localidad cordobaCapital = new Localidad("Cordoba Capital");
        Cordoba.agregarLocalidad(cordobaCapital);
        Localidad villaCarlosPaz = new Localidad("Villa Carlos Paz");
        Cordoba.agregarLocalidad(villaCarlosPaz);



        //Creacion de domicilios

        Domicilio domicilioCABA = new Domicilio("Avenida Siempre Viva", 123, 5500, CABA);
        CABA.agregarDomiicilio(domicilioCABA);
        Domicilio domicilioLaPlata = new Domicilio("Calle Falsa",321,5600, laPlata);
        laPlata.agregarDomiicilio(domicilioLaPlata);

        Domicilio domicilioCordobaCapital = new Domicilio("Avenida de Mentira", 546, 2200, cordobaCapital);
        cordobaCapital.agregarDomiicilio(domicilioCordobaCapital);
        Domicilio domicilioVillaCP = new Domicilio("Callejon Sin Salida", 333, 2210, villaCarlosPaz);
        villaCarlosPaz.agregarDomiicilio(domicilioVillaCP);

        //Creacion de Sucursales
        Sucursal sucursal1 = new Sucursal("Lugar 1", LocalTime.parse("08:00"), LocalTime.parse("18:00"), true, domicilioCABA);
        Sucursal sucursal2 = new Sucursal("Lugar 2", LocalTime.parse("08:00"), LocalTime.parse("18:00"), false, domicilioLaPlata);
        Sucursal sucursal3 = new Sucursal("Lugar 3", LocalTime.parse("08:00"), LocalTime.parse("18:00"), true, domicilioCordobaCapital);
        Sucursal sucursal4 = new Sucursal("Lugar 4", LocalTime.parse("08:00"), LocalTime.parse("18:00"), false, domicilioVillaCP);

        //Creacion de empresas
        Empresa empresa1 = new Empresa("Empresa Uno", "Razon Social 1", 1234, "Logo 1"); //buscar nombres
        empresa1.agregarSucursal(sucursal1);
        empresa1.agregarSucursal(sucursal2);

        Empresa empresa2 = new Empresa("Empresa Dos", "Razon Social 2", 5678, "Logo 2"); //buscar nombres
        empresa2.agregarSucursal(sucursal3);
        empresa2.agregarSucursal(sucursal4);

        //Pais
        System.out.println("------------------------Argentina------------------------");
        System.out.println(Argentina.mostrarPais());

        //Buenos Aires
        System.out.println("------------------------Buenos Aires------------------------");
        System.out.println(BuenosAires.mostrarProvincia());
        System.out.println(CABA.mostrarLocalidad());
        System.out.println(sucursal1.mostrarSucursal());
        System.out.println(laPlata.mostrarLocalidad());
        System.out.println(sucursal2.mostrarSucursal());

        //Cordoba
        System.out.println("------------------------Cordoba------------------------");
        System.out.println(Cordoba.mostrarProvincia());
        System.out.println(cordobaCapital.mostrarLocalidad());
        System.out.println(sucursal3.mostrarSucursal());
        System.out.println(villaCarlosPaz.mostrarLocalidad());
        System.out.println(sucursal4.mostrarSucursal());

        //Empresas
        System.out.println("------------------------Empresas------------------------");
        System.out.println(empresa1.mostrarEmpresa());
        System.out.println(empresa2.mostrarEmpresa());


        // Guardar empresas en el repositorio
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        // Mostrar todas las empresas
        System.out.println("------------------------Todas las empresas------------------------");
        mostrarTodasLasEmpresas();



        // Buscar empresa por ID
        System.out.println("\n----Buscar por ID----");
        Long idEmpresa = 1L;
        Optional<Empresa> empresaBuscadaPorId = buscarEmpresaPorId(idEmpresa);
        empresaBuscadaPorId.ifPresent(empresa ->
                System.out.println("\nEmpresa encontrada por ID: " + empresa.mostrarEmpresa())
        );

        // Buscar empresa por nombre
        System.out.println("\n----Buscar por Nombre----");
        String nombreEmpresa = "Empresa Uno";
        List<Empresa> empresasPorNombre = buscarEmpresaPorNombre(nombreEmpresa);
        System.out.println("\nEmpresas encontradas por nombre:");
        empresasPorNombre.forEach(empresa ->
                System.out.println(empresa.mostrarEmpresa())
        );


        // Actualizar empresa
        System.out.println("\n----Actualizacion de datos de la empresa----");
        Empresa empresaActualizada = new Empresa("Empresa Uno Actualizada", "Razon Social Actualizada", 4321, "Logo Actualizado");
        Optional<Empresa> empresaActualizadaResult = actualizarEmpresa(idEmpresa, empresaActualizada);
        empresaActualizadaResult.ifPresent(empresa ->
                System.out.println("\nEmpresa actualizada: " + empresa.mostrarEmpresa())
        );

        // Eliminar empresa
        System.out.println("\n----Eliminar Empresa----");
        Optional<Empresa> empresaEliminada = eliminarEmpresa(idEmpresa);
        empresaEliminada.ifPresent(empresa ->
                System.out.println("Empresa eliminada con éxito")
        );
    }

    // Mostrar todas las empresas
    public static void mostrarTodasLasEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        empresas.forEach(empresa ->
                System.out.println(empresa.mostrarEmpresa())
        );
    }

    // Buscar empresas por ID
    public static Optional<Empresa> buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    // Buscar empresa por nombre
    public static List<Empresa> buscarEmpresaPorNombre(String nombre) {
        return empresaRepository.genericFindByField("nombre", nombre);
    }

    // Actualizar empresa
    public static Optional<Empresa> actualizarEmpresa(Long id, Empresa empresaActualizada) {
        return empresaRepository.genericUpdate(id, empresaActualizada);
    }

    // Eliminar empresa
    public static Optional<Empresa> eliminarEmpresa(Long id) {
        return empresaRepository.genericDelete(id);


    }
}