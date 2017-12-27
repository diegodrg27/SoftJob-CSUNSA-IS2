package softjob.softjob;

/**
 * Created by jairf on 26/12/2017.
 */

public class Empleo {
    String id_empleo;
    String id_empresa;

    public Empleo(String id_empleo, String titulo, String descripcion, String habilidadesDuras, String habilidadesBlandas, String fecha_publicacion, String fecha_limite, String id_categoria) {
        this.id_empleo = id_empleo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.habilidadesDuras = habilidadesDuras;
        this.habilidadesBlandas = habilidadesBlandas;
        this.fecha_publicacion = fecha_publicacion;
        this.fecha_limite = fecha_limite;
        this.id_categoria = id_categoria;
    }

    String titulo;
    String descripcion;
    String habilidadesDuras;
    String habilidadesBlandas;
    String fecha_publicacion;
    String fecha_limite;

    public String getId_empleo() {
        return id_empleo;
    }

    public void setId_empleo(String id_empleo) {
        this.id_empleo = id_empleo;
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

    public String getHabilidadesDuras() {
        return habilidadesDuras;
    }

    public void setHabilidadesDuras(String habilidadesDuras) {
        this.habilidadesDuras = habilidadesDuras;
    }

    public String getHabilidadesBlandas() {
        return habilidadesBlandas;
    }

    public void setHabilidadesBlandas(String habilidadesBlandas) {
        this.habilidadesBlandas = habilidadesBlandas;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    String id_categoria;


    public Empleo(){

    }
}
