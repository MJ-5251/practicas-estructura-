import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Stack;

public class ExportarClientes {
    public void ExportarArchivo(Stack<cliente> VectorClientes)
    {
         if(VectorClientes.isEmpty())
         {
            System.out.println("LA LISTA ESTA VACIA NO SE PUEDE EXPORTAR EL ARCHIVO");
            return;
         } else{
            try(FileWriter e = new FileWriter("Clientes.txt"))
            {
                for (cliente o : VectorClientes) {
                    e.write("CEDULA: " + o.getCedula() + "\n");
                    e.write("NOMBRE: : " + o.getNombre() + "\n");
                    e.write("APELLIDO: " + o.getApellido() + "\n");
                    e.write("TELEFONO: " + o.getTelefono() + "\n");
                    e.write("DIRECCIÓN: " + o.getDireccion() + "\n");
                    e.write("LICENCIA_CONDUCCION: " + o.getLicenciaConduccion() + "\n");
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
