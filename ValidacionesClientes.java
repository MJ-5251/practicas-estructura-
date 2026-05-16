import java.util.Scanner;
import java.util.Stack;

public class ValidacionesClientes {

      // VALIDAR CEDULA Y TELEFONO
    public String ValidarCedulaYTelefono(Scanner sc, int n1, int n2) {
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

   // VALIDAR NOMBRE Y APELLIDO
   public String ValidarNombreYApellido(Scanner sc) {
    String Validar;
    
    while (true) {
        Validar = sc.nextLine().trim().replaceAll("\\s+", " ");
        
        if (Validar.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") && Validar.length() >= 2 && Validar.length() <= 15) {
            break;
        }
        System.out.println("ERROR: SOLO LETRAS, SIN NÚMEROS NI CARACTERES ESPECIALES, MÁXIMO 15 CARACTERES");
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
    while (true) {
        Cedula = ValidarCedulaYTelefono(sc, 7, 11);
        for (cliente o : clientes) {
            if(Cedula.equals(o.getCedula()))
            {
                encontrado = true;
            }
        }
        if(encontrado){
            System.out.println("YA EXISTE UN USUARIO REGISTRADO CON ESA CEDULA, POR FAVOR INGRESE UNA NUEVA");
            encontrado = false;
        }
        else
        {
           break;
        }
    }
    return Cedula;
   }
}