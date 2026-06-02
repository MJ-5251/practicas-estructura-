import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InformeGeneral {
    
    public void imprimir(cliente c) {
        System.out.println("Cedula: " + c.getCedula());
        System.out.println("Nombre: " + c.getNombre() + " " + c.getApellido());
        System.out.println("Telefono: " + c.getTelefono());
        System.out.println("Direccion: " + c.getDireccion());
        System.out.println("Licencia: " + c.getLicenciaConduccion());
    }

    public void imprimir(Vehiculo v) {
        System.out.println("Placa: " + v.getPlaca());
        System.out.println("Marca: " + v.getMarca());
        System.out.println("Modelo: " + v.getModelo());
        System.out.println("Precio Diario: " + v.getPrecioDiario());
        System.out.println("Estado: " + v.getEstado());

        if (v instanceof CarrosSedan) {

            CarrosSedan s = (CarrosSedan) v;
            System.out.println("Tipo: sedan");
            System.out.println("Combustible: " + s.getTipoCombustible());
            System.out.println("Transmision: " + s.getTransmision());

        } else if (v instanceof CamionetaSUV) {
            CamionetaSUV s = (CamionetaSUV) v;
            System.out.println("Tipo: SUV");
            System.out.println("Traccion: " + s.getTraccion());
            System.out.println("Capacidad Maletero: " + s.getCapacidadMaletero());
        }
    }

    public void imprimir(ContratoRenting cr) {

        System.out.println("ID contrato: " + cr.getIdContrato());
        System.out.println("Cedula cliente: " + cr.getCedulaCliente());
        System.out.println("Placa vehiculo: " + cr.getPlacaVehiculo());
        System.out.println("Fecha inicio: " + cr.getFechaInicio());
        System.out.println("Fecha fin: " + cr.getFechaFin());
        System.out.println("Total dias: " + cr.getTotalDias());
        System.out.println("Valor Total: " + cr.getValorTotal());
        System.out.println("Estado: " + cr.getEstado());
    }
    
    public void GenerarInforme(Stack<cliente> VectorClientes,
                               Queue<Vehiculo> VectorVehiculos,
                               LinkedList<ContratoRenting> VectorContratos) {

        System.out.println("============================================================");
        System.out.println("           INFORME GENERAL - SISTEMA DE RENTING");
        System.out.println("============================================================");

        // SECCION 1: CLIENTES
        System.out.println("------------------------------------------------------------");
        System.out.println("Clientes Registrados:");
        System.out.println("------------------------------------------------------------");
        int totalClientes = 0;
        for (cliente c : VectorClientes) {
            if (!c.isEliminado()) {
                totalClientes++;
                System.out.println("------------------------------");
                imprimir(c);
            }
        }
        if (totalClientes == 0) {
            System.out.println("NO HAY CLIENTES REGISTRADOS");
        } else {
            System.out.println("Total clientes: " + totalClientes);
        }

        // SECCION 2: VEHICULOS
        System.out.println("------------------------------------------------------------");
        System.out.println("Vehiculos Registrados:");
        System.out.println("------------------------------------------------------------");
        int totalVehiculos = 0;
        int disponibles = 0;
        int alquilados = 0;
        for (Vehiculo v : VectorVehiculos) {
            if (!v.isEliminado()) {
                totalVehiculos++;
                System.out.println("------------------------------");
                imprimir(v);
                if (v.getEstado().equalsIgnoreCase("disponible")) {
                    disponibles++;
                } else {
                    alquilados++;
                }
            }
        }
        if (totalVehiculos == 0) {
            System.out.println("NO HAY VEHICULOS REGISTRADOS");
        } else {
            System.out.println("Total vehiculos: " + totalVehiculos);
            System.out.println("Disponibles: " + disponibles);
            System.out.println("Alquilados: " + alquilados);
        }

        // SECCION 3: CONTRATOS ACTIVOS
        System.out.println("------------------------------------------------------------");
        System.out.println("Contratos Activos:");
        System.out.println("------------------------------------------------------------");
        int contActivos = 0;
        float ingresoActivos = 0;
        for (ContratoRenting cr : VectorContratos) {
            if (!cr.isEliminado() && cr.getEstado().equalsIgnoreCase("ACTIVO")) {
                contActivos++;
                ingresoActivos += cr.getValorTotal();
                System.out.println("------------------------------");
                imprimir(cr);
            }
        }
        if (contActivos == 0) {
            System.out.println("NO HAY CONTRATOS ACTIVOS");
        } else {
            System.out.println("Total contratos activos: " + contActivos);
        }

        
        System.out.println("------------------------------------------------------------");
        System.out.println("Contratos Finalizados:");
        System.out.println("------------------------------------------------------------");
        int contFinalizados = 0;
        float ingresoFinalizados = 0;
        for (ContratoRenting cr : VectorContratos) {
            if (!cr.isEliminado() && cr.getEstado().equalsIgnoreCase("FINALIZADO")) {
                contFinalizados++;
                ingresoFinalizados += cr.getValorTotal();
                System.out.println("------------------------------");
                imprimir(cr);
            }
        }
        if (contFinalizados == 0) {
            System.out.println("NO HAY CONTRATOS FINALIZADOS");
        } else {
            System.out.println("Total contratos finalizados: " + contFinalizados);
        }

        
        System.out.println("------------------------------------------------------------");
        System.out.println("Resumen de Ingresos:");
        System.out.println("------------------------------------------------------------");
        System.out.println("Ingresos contratos activos: " + ingresoActivos);
        System.out.println("Ingresos contratos finalizados: " + ingresoFinalizados);
        System.out.println("Total ingresos: " + (ingresoActivos + ingresoFinalizados));
        System.out.println("============================================================");
        System.out.println("                    FIN DEL INFORME");
        System.out.println("============================================================");
    }
}