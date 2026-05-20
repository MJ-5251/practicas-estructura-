import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ValidacionesClientes {

      // VALIDAR CEDULA Y TELEFONO
    public String ValidarSoloNumeros(Scanner sc, int n1, int n2) {
    String Validar;
    
    while (true) {
        Validar = sc.nextLine().trim().replaceAll("\\s+", "");
        
        if (Validar.matches("[0-9]+") && Validar.length() >= n1 && Validar.length() <= n2) {
            break;
        }
        if(n1 == 7)
        {
        System.out.println("ERROR: INGRESE DE 7 A 11 DIGITOS NUMÉRICOS SIN ESPCACIOS");
        }
        else{
        System.out.println("ERROR: INGRESE 10 DIGITOS NUMÉRICOS SIN ESPCACIOS");
        }
    }
    
    return Validar;
   }


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
    String Cedula;
    boolean encontrado = false;
    validaciones v = new validaciones();
    while (true) {
        Cedula = ValidarSoloNumeros(sc, 7, 11);
        for (cliente o : clientes) {
            if(Cedula.equals(o.getCedula()) && o.isEliminado())
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
        if(c.getCedulaCliente().equals(Cedula) && c.isEliminado() && c.getEstado().equals("ACTIVO"))
        {
            eliminar = false;
        }
     }
     return eliminar;
   }
}