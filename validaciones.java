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
}
