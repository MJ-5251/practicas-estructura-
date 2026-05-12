import java.util.Scanner;

public class Menu
{
   public static void Clientes()
   {
      Scanner sc = new Scanner(System.in);
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR CLIENTE");
      System.out.println("2. MODIFICAR CLIENTE");
      System.out.println("3. ELIMINAR CLIENTE");
      System.out.println("4. BUSCAR CLIENTE");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = sc.nextInt();

      switch (opc) {
        case 1:
             System.out.println("NO DISPONIBLE");
            break;
        case 2:
             System.out.println("NO DISPONIBLE");
            break;
        case 3:
            System.out.println("NO DISPONIBLE");
            break;
        case 4:
            System.out.println("NO DISPONIBLE");
            break;
        case 5:
             continuar = false;
            break;
        default:
            break;
        }
      }
   }

   public static void Vehiculos()
   {
      Scanner sc = new Scanner(System.in);
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR VEHÍCULO");
      System.out.println("2. MODIFICAR VEHÍCULO");
      System.out.println("3. ELIMINAR VEHÍCULO");
      System.out.println("4. BUSCAR VEHÍCULO");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = sc.nextInt();

      switch (opc) {
        case 1:
             System.out.println("NO DISPONIBLE");
            break;
        case 2:
             System.out.println("NO DISPONIBLE");
            break;
        case 3:
            System.out.println("NO DISPONIBLE");
            break;
        case 4:
            System.out.println("NO DISPONIBLE");
            break;
        case 5:
             continuar = false;
            break;
        default:
            break;
        }
      }
   }

   public static void CONTRATOS()
   {
      Scanner sc = new Scanner(System.in);
      boolean continuar = true;
      while (continuar) {
      System.out.println("1. REGISTAR NUEVO CONTRATO");
      System.out.println("2. MODIFICAR CONTRATO");
      System.out.println("3. FINALIZAR CONTRATO");
      System.out.println("4. BUSCAR CONTRATO");
      System.out.println("5. VOLVER AL MENÚ PRINCIPAL");
      int opc = sc.nextInt();

      switch (opc) {
        case 1:
             System.out.println("NO DISPONIBLE");
            break;
        case 2:
             System.out.println("NO DISPONIBLE");
            break;
        case 3:
            System.out.println("NO DISPONIBLE");
            break;
        case 4:
            System.out.println("NO DISPONIBLE");
            break;
        case 5:
             continuar = false;
            break;
        default:
            break;
        }
      }
   }
}