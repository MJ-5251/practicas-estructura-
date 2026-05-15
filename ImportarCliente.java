import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class ImportarCliente {
    public Stack<cliente> Importar()
    {
        String RutaArchivo = "Clientes.txt";
        Stack<cliente> VectorClientes = new Stack<>();

        File Archivo = new File(RutaArchivo);
        if(Archivo.exists())
        {
        try(BufferedReader br = new BufferedReader(new FileReader(RutaArchivo)))
        {
            String Linea;
            cliente d = null;

            while ((Linea = br.readLine()) != null) {
                if(Linea.startsWith("CEDULA:"))
                {
                    if(d != null)
                    {
                        VectorClientes.add(d);
                    }
                    d = new cliente();
                    d.setCedula(Linea.substring(0));
                }
                else if(Linea.startsWith("NOMBRE:"))
                {
                    if(d != null)
                    {
                        d.setNombre(Linea.substring(0));
                    }
                }
                else if(Linea.startsWith("APELLIDO:"))
                {
                    if(d != null) 
                    {
                        d.setApellido(Linea.substring(0));
                    }
                }
                else if(Linea.startsWith("TELEFONO:"))
                {
                    if(d != null) 
                    {
                        d.setTelefono(Linea.substring(0));
                    }
                }
                else if(Linea.startsWith("DIRECCIÓN:"))
                {
                    if(d != null) 
                    {
                        d.setDireccion(Linea.substring(0));
                    }
                }
                else if(Linea.startsWith("LICENCIA_CONDUCCION:"))
                {
                    if(d != null) 
                    {
                        d.setLicenciaConduccion(Linea.substring(0));
                    }
                }
            }
               System.out.println("ARCHIVO IMPORTADO CORRECTAMENTE");
        }
         catch(IOException e)
            {
                e.printStackTrace();
            }
        }
         return VectorClientes;
    }
}
