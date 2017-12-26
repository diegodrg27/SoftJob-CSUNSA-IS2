package softjob.softjob;

/**
 * Created by Moebius on 9/12/2017.
 */

class Empresa {
    public String  Correo;
    public String  Descripcion;
    public String  Dirección;
    public String  Nombre;
    public String RUC;
    public String  Telefono;
    public String   WebSite;
    public Empresa()
    {

    }
    public Empresa(String correo, String descripcion, String dirección, String nombre, String RUC, String telefono, String webSite) {
        Correo = correo;
        Descripcion = descripcion;
        Dirección = dirección;
        Nombre = nombre;
        this.RUC = RUC;
        Telefono = telefono;
        WebSite = webSite;
    }



    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String dirección) {
        Dirección = dirección;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }


}
