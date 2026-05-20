import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MetodosVehiculo {
    public Queue<Vehiculo> Registrar(Queue<Vehiculo> VectorVehiculo)
    {
        Scanner sc = new Scanner(System.in);
        validaciones v = new validaciones();
        ValidacionesVehiculos vh = new ValidacionesVehiculos();
        ExportarVehiculos  e = new ExportarVehiculos();
        boolean continuar = true;
        while (continuar) {
            System.out.println("1. REGISTRAR VEHICULO SEDAN");
            System.out.println("2. REGISTRAR VEHICULO SUV");
            System.out.println("3. SALIR");
            int opc = v.ValidarEntero(sc);


            switch (opc) {
                case 1:
                      CarrosSedan C = new CarrosSedan();
                      System.out.println("INGRESE LA PLACA DEL VEHICULO");
                      String Placa = vh.PlacaRepetida(sc, VectorVehiculo);
                      if(Placa.equals("SALIR"))
                      {
                        e.ExportarArchivo(VectorVehiculo); 
                        return VectorVehiculo;
                      }
                      else
                      {
                      C.setPlaca(Placa);
                      }

                      System.out.println("INGRESE LA MARCA DEL VEHICULO");
                      C.setMarca(v.ValidarSoloLetras(sc, 2, 20));
                      System.out.println("INGRESE EL MODELO DEL VEHICULO");
                      C.setModelo(vh.ValidarModelo(sc));
                      System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
                      C.setPrecioDiario(vh.ValidarFloat(sc));
                      C.setEstado("DISPONIBLE");

                      boolean salir = true;
                      while (salir) {
                      System.out.println("INGRESE EL TIPO DE COMBUSTIBLE");
                      System.out.println("1. GASOLINA");
                      System.out.println("2. DIESÉL");
                      System.out.println("3. ELÉCTRICO");
                      int opt = v.ValidarEntero(sc);
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
                      int opt = v.ValidarEntero(sc);
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
                      String placa = vh.PlacaRepetida(sc, VectorVehiculo);
                      if(placa.equals("SALIR"))
                      {
                        e.ExportarArchivo(VectorVehiculo);
                        return VectorVehiculo;
                      }
                      else
                      {
                      P.setPlaca(placa);
                      }    

                      System.out.println("INGRESE LA MARCA DEL VEHICULO");
                      P.setMarca(v.ValidarSoloLetras(sc, 2, 20));
                      System.out.println("INGRESE EL MODELO DEL VEHICULO");
                      P.setModelo(vh.ValidarModelo(sc));
                      System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
                      P.setPrecioDiario(vh.ValidarFloat(sc));
                      P.setEstado("DISPONIBLE");

                      boolean cont = true;
                      while(cont)
                      {
                      System.out.println("INGRESE LA TRACCIÓN DEL VEHÍCULO");
                      System.out.println("1. 4 X 2");
                      System.out.println("2. 4 X 4");
                      int opt = v.ValidarEntero(sc);
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
                        P.setCapacidadMaletero(vh.ValidarFloat(sc));

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
        e.ExportarArchivo(VectorVehiculo);
        return VectorVehiculo; 
    }

    public Queue<Vehiculo> Modificar(Queue<Vehiculo> VectorVehiculo)
    {
        Scanner sc = new Scanner(System.in);
        validaciones v = new validaciones();
        ValidacionesVehiculos vh = new ValidacionesVehiculos();
        ExportarVehiculos  e = new ExportarVehiculos();
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA MODIFICAR");
        String Placa = vh.ValidarPlaca(sc);
        boolean encontrado = false;
        for (Vehiculo vehiculo : VectorVehiculo) {
            
            if(Placa.equals(vehiculo.getPlaca()) && !vehiculo.isEliminado())
            {
            encontrado = true;

            System.out.println("INGRESE LA MARCA DEL VEHICULO");
            vehiculo.setMarca(v.ValidarSoloLetras(sc, 2, 20));
            System.out.println("INGRESE EL MODELO DEL VEHICULO");
            vehiculo.setModelo(vh.ValidarModelo(sc));
            System.out.println("INGRESE EL PRECIO DIARIO DEL VEHICULO");
            vehiculo.setPrecioDiario(vh.ValidarFloat(sc));
            boolean seguir = true;
            while (seguir) {
            System.out.println("INGRESE EL ESTADO DEL VEHICULO");
            System.out.println("1. DISPONIBLE");
            System.out.println("2. OCUPADO");
            int opc = v.ValidarEntero(sc);
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

           boolean salir = true;
                      while (salir) {
                      System.out.println("INGRESE EL NUEVO TIPO DE COMBUSTIBLE");
                      System.out.println("1. GASOLINA");
                      System.out.println("2. DIESÉL");
                      System.out.println("3. ELÉCTRICO");
                      int opt = v.ValidarEntero(sc);
                      switch (opt) {
                        case 1:
                             sedan.setTipoCombustible("GASOLINA");
                             salir = false;
                            break;
                        case 2:
                            sedan.setTipoCombustible("DIÉSEL");
                             salir = false;
                            break;
                        case 3:
                            sedan.setTipoCombustible("ELÉCTRICO");
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
                      System.out.println("INGRESE LA NUEVA TRANSIMISIÓN DEL VEHÍCULO");
                      System.out.println("1. AUTOMATICO");
                      System.out.println("2. MANUAL");
                      int opt = v.ValidarEntero(sc);
                      switch (opt) {
                        case 1:
                             sedan.setTransmision("AUTOMATICO");
                             salir = false;
                            break;
                        case 2:
                            sedan.setTransmision("MANUAL");
                             salir = false;
                            break;
                        default:
                            System.out.println("OPCIÓN INVALIDA");
                            break;
                        }
                      }
        }

        else if (vehiculo instanceof CamionetaSUV) {
            CamionetaSUV suv = (CamionetaSUV) vehiculo;
             boolean cont = true;
                      while(cont)
                      {
                      System.out.println("INGRESE LA NUEVA TRACCIÓN DEL VEHÍCULO");
                      System.out.println("1. 4 X 2");
                      System.out.println("2. 4 X 4");
                      int opt = v.ValidarEntero(sc);
                      switch (opt) {
                        case 1:
                             suv.setTraccion("4X2");
                             cont = false;
                            break;
                        case 2:
                             suv.setTraccion("4X4");
                             cont = false;
                            break;
                        default:
                            System.out.println("OPCIÓN INVALIDA");
                            break;
                        }
                      }
                      System.out.println("INGRESE LA NUEVA CAPACIDAD DEL MALETERO");
                      suv.setCapacidadMaletero(vh.ValidarFloat(sc));

        }
       System.out.println("VEHICULO MODIFICADO");          
     } 
    }

    if(!encontrado)
    {
        System.out.println("VEHICULO NO ENCONTRADO");
    }
    e.ExportarArchivo(VectorVehiculo);
    return VectorVehiculo;
    }

       public Queue<Vehiculo>  Eliminar(Queue<Vehiculo> VectorVehiculo)
       {
        Scanner sc = new Scanner(System.in);
        ValidacionesVehiculos vh = new ValidacionesVehiculos();
        ExportarVehiculos  e = new ExportarVehiculos();
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA ELIMINAR");
        String Placa = vh.ValidarPlaca(sc);
        boolean eliminado = false;
        for (Vehiculo vehiculo : VectorVehiculo) {
            if(Placa.equals(vehiculo.getPlaca()) && !vehiculo.isEliminado())
            {
                // VER SI EL VEHICULO ESTA EN USO ANTES DE ELIMANAR
                if(vehiculo.getEstado().equals("DISPONIBLE"))
                {
                    vehiculo.setEliminado(true);
                    eliminado = true;
                }
                else{
                    System.out.println("VEHICULO ESTA EN USO, NO PUEDE SER ELIMINADO");
                     e.ExportarArchivo(VectorVehiculo);
                     return VectorVehiculo;
                }
               
            }
        }
        if(eliminado)
        {
            System.out.println("VEHICULO ELIMINADO");
        }
        else{
            System.out.println("VEHICULO NO ENCONTRADO");
        }
        e.ExportarArchivo(VectorVehiculo);
        return VectorVehiculo;
       }

      public void Buscar(Queue<Vehiculo> VectorVehiculo)
      {
        Scanner sc = new Scanner(System.in);
        ValidacionesVehiculos vh = new ValidacionesVehiculos();
        System.out.println("INGRESE LA PLACA DEL VEHICULO QUE DESEA BUSCAR");
        String Placa = vh.ValidarPlaca(sc);
        boolean encontrado = false;
        for (Vehiculo vehiculo : VectorVehiculo) {
              if(Placa.equals(vehiculo.getPlaca()) && !vehiculo.isEliminado())
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
              }
         }

         if(!encontrado)
         {
            System.out.println("VEHICULO NO ENCONTRADO");
         }
      }
}   
