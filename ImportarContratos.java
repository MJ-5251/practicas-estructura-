import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class ImportarContratos {
    public LinkedList<ContratoRenting> Importar()
    {
        String RutaArchivo = "Contratos.txt";
        LinkedList<ContratoRenting> VectorContratos = new Stack<>();

        File Archivo = new File(RutaArchivo);
        if(Archivo.exists())
        {
        try(BufferedReader br = new BufferedReader(new FileReader(RutaArchivo)))
        {
            String Linea;
            ContratoRenting d = null;

            while ((Linea = br.readLine()) != null) {
                if(Linea.startsWith("ID_CONTRATO:"))
                {
                    if(d != null)
                    {
                        VectorContratos.add(d);
                    }
                    d = new ContratoRenting();
                    d.setIdContrato(Linea.substring(7));
                }
                else if(Linea.startsWith("CEDULA_CLIENTE:"))
                {
                    if(d != null)
                    {
                        d.setCedulaCliente(Linea.substring(15));
                    }
                }
                else if(Linea.startsWith("PLACA_VEHICULO:"))
                {
                    if(d != null) 
                    {
                        d.setPlacaVehiculo(Linea.substring(15));
                    }
                }
                else if(Linea.startsWith("FECHA_INICIO:"))
                {
                    if(d != null) 
                    {
                        d.setFechaInicio(Linea.substring(13));
                    }
                }
                else if(Linea.startsWith("FECHA_FIN:"))
                {
                    if(d != null) 
                    {
                        d.setFechaFin(Linea.substring(10));
                    }
                }
                else if(Linea.startsWith("TOTAL_DIAS:"))
                {
                    if(d != null) 
                    {
                       d.setTotalDias(Integer.parseInt(Linea.substring(11)));
                    }
                }
                else if(Linea.startsWith("VALOR_TOTAL:"))
                {
                    if(d != null) 
                    {
                       d.setValorTotal(Float.parseFloat(Linea.substring(12)));
                    }
                }
                else if(Linea.startsWith("ESTADO:"))
                {
                    if(d != null) 
                    {
                        d.setEstado(Linea.substring(7));
                    }
                }
            }

              if(d != null)
              {
                 VectorContratos.add(d);
              }
               System.out.println("ARCHIVO IMPORTADO CORRECTAMENTE");
        }
         catch(IOException e)
            {
                e.printStackTrace();
            }
        }
         return VectorContratos;
    }
}
