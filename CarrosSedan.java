public class CarrosSedan extends Vehiculo{
   private String TipoCombustible;
   private String Transmision;
   
   public CarrosSedan() {
   }

   public CarrosSedan(String placa, String marca, int modelo, float precioDiario, String estado, boolean eliminado, String tipoCombustible,
        String transmision) {
    super(placa, marca, modelo, precioDiario, estado, eliminado);
    TipoCombustible = tipoCombustible;
    Transmision = transmision;
    }

   public String getTipoCombustible() {
    return TipoCombustible;
   }
   public void setTipoCombustible(String tipoCombustible) {
    TipoCombustible = tipoCombustible;
   }
   public String getTransmision() {
    return Transmision;
   }
   public void setTransmision(String transmision) {
    Transmision = transmision;
   }

   
}