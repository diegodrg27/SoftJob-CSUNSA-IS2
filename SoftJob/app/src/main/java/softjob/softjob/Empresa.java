package softjob.softjob;

/**
 * Created by Moebius on 9/12/2017.
 */

class Empresa {
    public String  correo;

    public Empresa(String correo, String descripcion, String dirección, String nombre, String ruc, String telefono, String webSite) {
        this.correo = correo;
        this.descripcion = descripcion;
        this.dirección = dirección;
        this.nombre = nombre;
        this.ruc = ruc;
        this.telefono = telefono;
        this.webSite = webSite;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String  descripcion;
    public String  dirección;
    public String  nombre;
    public String  ruc;
    public String  telefono;
    public String   webSite;
    public Empresa()
    {

    }


}
