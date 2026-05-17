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
                for (Vehiculo o : VectorVehiculos) {
                    e.write("PLACA: " + o.getPlaca() + "\n");
                    e.write("MARCA: : " + o.getMarca() + "\n");
                    e.write("MODELO: " + o.getModelo() + "\n");
                    e.write("PRECIO_DIARIO: " + o.getPrecioDiario() + "\n");
                    e.write("ESTADO: " + o.getEstado() + "\n");

                    if (o instanceof CarrosSedan)
                    {
                      CarrosSedan s = (CarrosSedan) o;
                    e.write("TIPO_COMBUSTIBLE: " + s.getTipoCombustible() + "\n");
                    e.write("TRANSMISION: " + s.getTransmision() + "\n");
                    }
                    else if (o instanceof CamionetaSUV)
                    {
                      CamionetaSUV s = (CamionetaSUV) o;
                    e.write("TRACCION: " + s.getTraccion() + "\n");
                    e.write("CAPACIDAD_MALETERO: " + s.getCapacidadMaletero() + "\n");
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
