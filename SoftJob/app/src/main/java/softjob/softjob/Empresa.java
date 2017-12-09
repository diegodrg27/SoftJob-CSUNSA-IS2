package softjob.softjob;

/**
 * Created by Moebius on 9/12/2017.
 */

class Empresa {
    protected  String id_empresa;
    protected  String id_usuario;
    protected  String m_nombre;
    protected  String m_telefono;
    protected  String m_direccion;
    protected  String m_correo;
    protected  String m_website;
    protected  String m_description;
    protected  String m_logoRuta;

    public Empresa(String id_empresa, String id_usuario, String m_nombre, String m_telefono, String m_direccion, String m_correo, String m_website, String m_description, String m_logoRuta) {
        this.id_empresa = id_empresa;
        this.id_usuario = id_usuario;
        this.m_nombre = m_nombre;
        this.m_telefono = m_telefono;
        this.m_direccion = m_direccion;
        this.m_correo = m_correo;
        this.m_website = m_website;
        this.m_description = m_description;
        this.m_logoRuta = m_logoRuta;
    }


    public Empresa()
    {

    }
    public String getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(String id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getM_nombre() {
        return m_nombre;
    }

    public void setM_nombre(String m_nombre) {
        this.m_nombre = m_nombre;
    }

    public String getM_telefono() {
        return m_telefono;
    }

    public void setM_telefono(String m_telefono) {
        this.m_telefono = m_telefono;
    }

    public String getM_direccion() {
        return m_direccion;
    }

    public void setM_direccion(String m_direccion) {
        this.m_direccion = m_direccion;
    }

    public String getM_correo() {
        return m_correo;
    }

    public void setM_correo(String m_correo) {
        this.m_correo = m_correo;
    }

    public String getM_website() {
        return m_website;
    }

    public void setM_website(String m_website) {
        this.m_website = m_website;
    }

    public String getM_description() {
        return m_description;
    }

    public void setM_description(String m_description) {
        this.m_description = m_description;
    }

    public String getM_logoRuta() {
        return m_logoRuta;
    }

    public void setM_logoRuta(String m_logoRuta) {
        this.m_logoRuta = m_logoRuta;
    }

}
