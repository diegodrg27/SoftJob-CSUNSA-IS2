package softjob.softjob;

/**
 * Created by jairf on 16/12/2017.
 */

public class CategoriaTrabajo {
    public CategoriaTrabajo(String id_categoria, String nombre_categoria) {
        this.id_categoria = id_categoria;
        this.nombre_categoria = nombre_categoria;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre_categoria() {
        return nombre_categoria;
    }

    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    protected String id_categoria;
    protected String nombre_categoria;


}
