import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImportarVehiculos {
    public Queue<Vehiculo> Importar()
    {
        String RutaArchivo = "Vehiculos.txt";
        Queue<Vehiculo> VectorVehiculos = new LinkedList<>();

        File Archivo = new File(RutaArchivo);
        if(Archivo.exists())
        {
        try(BufferedReader br = new BufferedReader(new FileReader(RutaArchivo)))
        {
            String Linea;
            Vehiculo d = null;

            while ((Linea = br.readLine()) != null) {
                if(Linea.startsWith("PLACA:"))
                {
                    if(d != null)
                    {
                        VectorVehiculos.add(d);
                    }
                    d = new Vehiculo();
                    d.setPLaca(Linea.substring(6));
                }
                else if(Linea.startsWith("MARCA:"))
                {
                    if(d != null)
                    {
                        d.setMarca(Linea.substring(6));
                    }
                }
                else if(Linea.startsWith("MODELO:"))
                {
                    if(d != null) 
                    {
                        d.setModelo(Integer.parseInt(Linea.substring(7)));
                    }
                }
                else if(Linea.startsWith("PRECIO_DIARIO:"))
                {
                    if(d != null) 
                    {
                       d.setPrecioDiario(Float.parseFloat(Linea.substring(14)));
                    }
                }
                else if(Linea.startsWith("ESTADO:"))
                {
                    if(d != null) 
                    {
                        d.setDireccion(Linea.substring(7));
                    }
                }
                else if(Linea.startsWith("TIPO_COMBUSTIBLE:")) {
                    if(d != null && d instanceof CarrosSedan) {
                        ((CarrosSedan) d).setTipoCombustible(Linea.substring(17));
                    }
                }
                else if(Linea.startsWith("TRANSMISION:")) {
                    if(d != null && d instanceof CarrosSedan) {
                        ((CarrosSedan) d).setTransmision(Linea.substring(12));
                    }
                }
                else if(Linea.startsWith("TRACCION:")) {
                    if(d != null && d instanceof CamionetaSUV) {
                        ((CamionetaSUV) d).setTraccion(Linea.substring(9));
                    }
                }
                else if(Linea.startsWith("CAPACIDAD_MALETERO:")) {
                     if(d != null && d instanceof CamionetaSUV) {
                        ((CamionetaSUV) d).setCapacidadMaletero(Float.parseFloat(Linea.substring(19)));
                    }
                }
            }

              if(d != null)
              {
                 VectorVehiculos.add(d);
              }
               System.out.println("ARCHIVO IMPORTADO CORRECTAMENTE");
        }
         catch(IOException e)
            {
                e.printStackTrace();
            }
        }
         return VectorVehiculos;
    }
}
