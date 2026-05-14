import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MetodosVehiculo {
    public Queue<Vehiculo> Registrar(Queue<Vehiculo> VectorVehiculo)
    {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("1. REGISTRAR VEHICULO SEDAN");
            System.out.println("2. REGISTRAR VEHICULO SUV");
            System.out.println("3. SALIR");
            int opc = sc.nextInt();


            switch (opc) {
                case 1:
                      CarrosSedan C = new CarrosSedan();
                      System.out.println("INGRESE LA PLACA DEL VEHICULO");
                      C.setPlaca(sc.next());
                      System.out.println("INGRESE LA MARCA DEL VEHICULO");
                      C.setMarca(sc.next());
                      System.out.println("INGRESE EL MODELO DEL VEHICULO");
                      C.setModelo(sc.nextInt());
                      System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
                      C.setPrecioDiario(sc.nextFloat());
                      C.setEstado("DISPONIBLE");

                      boolean salir = true;
                      while (salir) {
                      System.out.println("INGRESE EL TIPO DE COMBUSTIBLE");
                      System.out.println("1. GASOLINA");
                      System.out.println("2. DIESÉL");
                      System.out.println("3. ELÉCTRICO");
                      int opt = sc.nextInt();
                      switch (opt) {
                        case 1:
                             C.setTipoCombustible("GASOLINA");
                             salir = false;
                            break;
                        case 2:
                            C.setTipoCombustible("DIÉSEL");
                             salir = false;
                            break;
                        case 3:
                            C.setTipoCombustible("ELÉCTRICO");
                            salir = false;
                            break;
                        default:
                            System.out.println("OPCIÓN INVALIDA");
                            break;
                        }
                      }
                      
                      salir = true;
                      while(salir)
                      {
                      System.out.println("INGRESE LA TRANSIMISIÓN DEL VEHÍCULO");
                      System.out.println("1. AUTOMATICO");
                      System.out.println("2. MANUAL");
                      int opt = sc.nextInt();
                      switch (opt) {
                        case 1:
                             C.setTransmision("AUTOMATICO");
                             salir = false;
                            break;
                        case 2:
                            C.setTransmision("MANUAL");
                             salir = false;
                            break;
                        default:
                            System.out.println("OPCIÓN INVALIDA");
                            break;
                        }
                      }

                      VectorVehiculo.add(C);
                    break;


                case 2:
                    
                     CamionetaSUV P = new CamionetaSUV();
                      System.out.println("INGRESE LA PLACA DEL VEHICULO");
                      P.setPlaca(sc.next());
                      System.out.println("INGRESE LA MARCA DEL VEHICULO");
                      P.setMarca(sc.next());
                      System.out.println("INGRESE EL MODELO DEL VEHICULO");
                      P.setModelo(sc.nextInt());
                      System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
                      P.setPrecioDiario(sc.nextFloat());
                      P.setEstado("DISPONIBLE");

                      boolean cont = true;
                      while(cont)
                      {
                      System.out.println("INGRESE LA TRACCIÓN DEL VEHÍCULO");
                      System.out.println("1. 4 X 2");
                      System.out.println("2. 4 X 4");
                      int opt = sc.nextInt();
                      switch (opt) {
                        case 1:
                             P.setTraccion("4X2");
                             cont = false;
                            break;
                        case 2:
                             P.setTraccion("4X4");
                             cont = false;
                            break;
                        default:
                            System.out.println("OPCIÓN INVALIDA");
                            break;
                        }
                      }
                      
                      System.out.println("INGRESE LA CAPACIDAD DEL MALETERO");
                        P.setCapacidadMaletero(sc.nextFloat());

                      VectorVehiculo.add(P);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA");
                    break;
            }

          
        }
        return VectorVehiculo; 
    }

    public Queue<Vehiculo> Modificar(Queue<Vehiculo> VectorVehiculo)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA MODIFICAR");
        String Placa = sc.next();
        boolean encontrado = false;
        for (Vehiculo vehiculo : VectorVehiculo) {
            
            if(Placa.equals(vehiculo.getPlaca()))
            {
            encontrado = true;

            System.out.println("INGRESE LA MARCA DEL VEHICULO");
            vehiculo.setMarca(sc.next());
            System.out.println("INGRESE EL MODELO DEL VEHICULO");
            vehiculo.setModelo(sc.nextInt());
            System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
            vehiculo.setPrecioDiario(sc.nextFloat());
            boolean seguir = true;
            while (seguir) {
            System.out.println("INGRESE EL ESTADO DEL VEHICULO");
            System.out.println("1. DISPONIBLE");
            System.out.println("2. OCUPADO");
            int opc = sc.nextInt();
              switch (opc) {
                case 1:
                    vehiculo.setEstado("DISPONIBLE");
                    seguir = false;
                    break;
                case 2:
                    vehiculo.setEstado("OCUPADO");
                    seguir = false;
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
                    break;
              }
            }
            
        if (vehiculo instanceof CarrosSedan) {

            CarrosSedan sedan = (CarrosSedan) vehiculo;

            System.out.println("Nuevo tipo combustible:");
            sedan.setTipoCombustible(sc.nextLine());

            System.out.println("Nueva transmision:");
            sedan.setTransmision(sc.nextLine());
        }

        else if (vehiculo instanceof CamionetaSUV) {

            CamionetaSUV suv = (CamionetaSUV) vehiculo;

            System.out.println("Nueva traccion:");
            suv.setTraccion(sc.nextLine());

            System.out.println("Nueva capacidad maletero:");
            suv.setCapacidadMaletero(sc.nextFloat());
        }
       System.out.println("CLIENTE MODIFICADO");          
     } 
    }

    if(!encontrado)
    {
        System.out.println("CLIENTE NO ENCONTRADO");
    }
    return VectorVehiculo;
    }

       public Queue<Vehiculo>  Eliminar(Queue<Vehiculo> VectorVehiculo)
       {
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA ELIMINAR");
        String Placa = sc.next();
        boolean eliminado = VectorVehiculo.removeIf(x -> x.getPlaca().equals(Placa));
        
        if(eliminado)
        {
            System.out.println("CLIENTE ELIMINADO");
        }
        else{
            System.out.println("CLIENTE NO ENCONTRADO");
        }
        return VectorVehiculo;
       }

      public void Buscar(Queue<Vehiculo> VectorVehiculo)
      {
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA BUSCAR");
        String Placa = sc.next();
        boolean encontrado = false;
        for (Vehiculo vehiculo : VectorVehiculo) {
              if(Placa.equals(vehiculo.getPlaca()))
              {
                encontrado = true;
                System.out.println("PLACA: " + vehiculo.getPlaca());
                System.out.println("MARCA: " + vehiculo.getMarca());
                System.out.println("MODELO: " + vehiculo.getModelo());
                System.out.println("PRECIO DIARIO : " + vehiculo.getPrecioDiario());
                System.out.println("ESTADO: " + vehiculo.getEstado());

                 if (vehiculo instanceof CarrosSedan) {
                CarrosSedan sedan = (CarrosSedan) vehiculo;
                System.out.println("TIPO DE COMBUSTIBLE :" + sedan.getTipoCombustible());
                System.out.println("TRASMISIÓN :" + sedan.getTransmision());
                 }

                 else if (vehiculo instanceof CamionetaSUV) {
                 CamionetaSUV suv = (CamionetaSUV) vehiculo;
                  System.out.println("TRACCIÓN: " + suv.getTraccion());
                System.out.println("CAPACIDAD MALETERO: " + suv.getCapacidadMaletero());
                }
                System.out.println("VEHICULO ELIMINADO");
              }
         }

         if(!encontrado)
         {
            System.out.println("VEHICULO NO ENCONTRADO");
         }
      }
}   
