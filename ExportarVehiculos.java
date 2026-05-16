import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExportarVehiculos {
    public void ExportarArchivo(Queue<Vehiculo> VectorVehiculos)
    {
         if(VectorVehiculos.isEmpty())
         {
            System.out.println("LA LISTA ESTA VACIA NO SE PUEDE EXPORTAR EL ARCHIVO");
            return;
         } else{
            try(FileWriter e = new FileWriter("Vehiculos.txt"))
            {
                for (cliente o : VectorVehiculos) {
                    e.write("PLACA: " + o.getPlaca() + "\n");
                    e.write("MARCA: : " + o.getMarca() + "\n");
                    e.write("MODELO: " + o.getModelo() + "\n");
                    e.write("PRECIO_DIARIO: " + o.getPrecioDiario() + "\n");
                    e.write("ESTADO: " + o.getEstado() + "\n");

                    if (vehiculo instanceof CarrosSedan)
                    {
                      CarrosSedan s = (CarrosSedan) vehiculo;
                    e.write("TIPO_COMBUSTIBLE: " + o.getTipoCombustible() + "\n");
                    e.write("TRANSMISION: " + o.getTransmision() + "\n");
                    }
                    else if (vehiculo instanceof CamionetaSUV)
                    {
                      CamionetaSUV s = (CamionetaSUV) vehiculo;
                    e.write("TRACCION: " + o.getTraccion() + "\n");
                    e.write("CAPACIDAD_MALETERO: " + o.getCapacidadMaletero() + "\n");
                    }
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
