package softjob.softjob;

/**
 * Created by jairf on 16/12/2017.
 */

public class Trabajo {
    protected String id_trabajo;

    public String getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(String id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHab_duras() {
        return hab_duras;
    }

    public void setHab_duras(String hab_duras) {
        this.hab_duras = hab_duras;
    }

    public String getHab_blandas() {
        return hab_blandas;
    }

    public void setHab_blandas(String hab_blandas) {
        this.hab_blandas = hab_blandas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    protected String id_empresa;
    protected String titulo;
    protected String descripcion;
    protected String hab_duras;

    public Trabajo(String id_trabajo, String id_categoria, String titulo,String id_empresa, String descripcion, String hab_duras, String hab_blandas, String fecha_publicacion) {
        this.id_trabajo = id_trabajo;
        this.id_empresa = id_empresa;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.hab_duras = hab_duras;
        this.hab_blandas = hab_blandas;
        this.fecha_publicacion = fecha_publicacion;
        this.id_categoria = id_categoria;
    }

    public Trabajo(String id_trabajo, String categoria, String titulo){
        this.id_trabajo = id_trabajo;
        this.id_categoria = categoria;
        this.titulo = titulo;
    }

    public Trabajo(){

    }

    protected String hab_blandas;
    protected String fecha_publicacion;
    protected String id_categoria;
}
