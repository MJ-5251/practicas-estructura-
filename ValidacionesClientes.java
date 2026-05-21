import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ValidacionesClientes {

   // VALIDAR DIRECCIÓN
   public String ValidarDireccion(Scanner sc) {
    String Direccion;
    
    while (true) {
        Direccion = sc.nextLine().trim().replaceAll("\\s+", " ");
        
        if (Direccion.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s#\\-\\.]+") && Direccion.length() >= 5 && Direccion.length() <= 20) {
            break;
        }
        System.out.println("ERROR: DIRECCIÓN INVÁLIDA, EJEMPLO: CALLE 12 # 34-56");
    }
    
    return Direccion;
   }

   // VALIDAR CEDULA REPETIDA
   public String CedulaRepetida(Scanner sc, Stack<cliente> clientes)
   {
    validaciones v = new validaciones();
    String Cedula;
    boolean encontrado = false;
    while (true) {
        Cedula = v.ValidarSoloNumeros(sc, 7, 11);
        for (cliente o : clientes) {
            if(Cedula.equals(o.getCedula()) && !o.isEliminado())
            {
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("YA EXISTE UN USUARIO REGISTRADO CON ESA CEDULA");
            System.out.println("1.INGRESAR UNA NUEVA");
            System.out.println("2. SALIR");
            int opc = v.ValidarRango(1, 2, sc);
            if(opc == 2)
            {
                return Cedula = "SALIR";
            }
            else{
                System.out.println("INGRESE LA NUEVA CEDULA");
            }
            encontrado = false;
        }
        else
        {
           break;
        }
    }
    return Cedula;
   }

   // VALIDAR VIGENCIA DE CONTRATOS
   public boolean VigenciaContratos(LinkedList<ContratoRenting> VectorContratos, String Cedula)
   {
     boolean eliminar = true;
     for (ContratoRenting c : VectorContratos) {
        if(c.getCedulaCliente().equals(Cedula) && !c.isEliminado() && c.getEstado().equals("ACTIVO"))
        {
            eliminar = false;
        }
     }
     return eliminar;
   }
}