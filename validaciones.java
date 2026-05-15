import java.util.Scanner;

public class validaciones {
    
    public String pedirCampo(String mensaje, Scanner sc) {
        String valor;
        do {
            System.out.println(mensaje);
            valor = sc.nextLine().trim();
            if (valor.isBlank()) {
                System.out.println("Este campo es requerido. Intente de nuevo.");
            }
        } while (valor.isBlank());
        return valor;
    }

    public boolean ValidarDimension(String opt) {
        while (opt.length() > 1) {
            System.out.println("Solo puede agregar Y or N");
            return false;

        }
        return true;

    }

    public boolean ValidarTexto(String texto) {
        return texto.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ{} ]+");
    }

    public int ValidarEntero(Scanner sc) {
    String Entrada = "";
    while (true) {
        Entrada = sc.nextLine().trim();
        
        if (!Entrada.isEmpty() && Entrada.matches("[0-9]+")) {
            break;
        }
        System.out.println("Por favor Ingrese un digito Numérico");
    }
    return Integer.parseInt(Entrada);
}

     public int ValidarCedula(Scanner sc) {
        int cedulaE = ValidarEntero(sc);
        String cedulaAux = cedulaE + "";
        cedulaAux = cedulaAux.trim();
        while (cedulaAux.length() < 7 || cedulaAux.length() > 11) {
            System.out.println("error ingrese de 7 a 10 digitos");
            sc.next();
            cedulaAux = sc.next();
        }
        try {
            cedulaE = Integer.parseInt(cedulaAux);
        } catch (Exception e) {
            System.out.println("ingrese una cedula valida");
        }
        return cedulaE;
    }
}
