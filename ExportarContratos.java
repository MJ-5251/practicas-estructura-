import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class ExportarContratos {
    public void ExportarArchivo(LinkedList<ContratoRenting> VectorContratos)
    {
         if(VectorContratos.isEmpty())
         {
            System.out.println("LA LISTA ESTA VACIA NO SE PUEDE EXPORTAR EL ARCHIVO");
            return;
         } else{
            try(FileWriter e = new FileWriter("Contratos.txt"))
            {
                for (ContratoRenting o : VectorContratos) {
                    e.write("ID_CONTRATO:" + o.getIdContrato() + "\n");
                    e.write("CEDULA_CLIENTE:" + o.getCedulaCliente() + "\n");
                    e.write("PLACA_VEHICULO:" + o.getPlacaVehiculo() + "\n");
                    e.write("FECHA_INICIO:" + o.getFechaInicio() + "\n");
                    e.write("FECHA_FIN:" + o.getFechaFin() + "\n");
                    e.write("TOTAL_DIAS:" + o.getTotalDias() + "\n");
                    e.write("VALOR_TOTAL:" + o.getValorTotal() + "\n");
                    e.write("ESTADO:" + o.getEstado() + "\n");
                    e.write("------------------------------\n");
                }
                System.out.println("ARCHIVO EXPORTADO CORRECTAMENTE ");
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
         }
    }
}
