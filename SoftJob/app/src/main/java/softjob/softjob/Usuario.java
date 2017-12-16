package softjob.softjob;

/**
 * Created by Diego on 15/11/2017.
 */

public class Usuario {
    String id_api;
    String Nombres;
    String Apellidos;
    String DNI;
    String Sexo;
    String Telefono;
    String Celular;
    String Direccion;
    String Correo;

    public  Usuario(){

    }

    public  Usuario(String id_api, String Nombres, String Apellidos, String DNI, String Sexo, String Telefono, String Celular, String Direccion, String Correo){
        this.id_api = id_api;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.DNI = DNI;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
        this.Celular = Celular;
        this.Direccion = Direccion;
        this.Correo = Correo;
    }

}
