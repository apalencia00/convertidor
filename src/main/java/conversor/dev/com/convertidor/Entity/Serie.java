package conversor.dev.com.convertidor.Entity;

public class Serie {

    private String fecha;
    private double valor;

    public Serie() {
    }

    public Serie(String fecha, double valor) {
        this.fecha = fecha;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
