package conversor.dev.com.convertidor.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Indicator")
public class Indicator {

    @Id
    private int _id;
    private String version;
    private String autor;
    private String codigo;
    private String nombre;
    private String unidad_medida;
    private List<Serie> series;

    public Indicator(int id,String version, String autor, String codigo, String nombre, String unidad_medida, List<Serie> series) {
        super();
        this._id = id;
        this.version = version;
        this.autor = autor;
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidad_medida = unidad_medida;
        this.series = series;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }
}
