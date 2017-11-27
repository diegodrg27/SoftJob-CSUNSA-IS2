package softjob.softjob;

/**
 * Created by Diego on 15/11/2017.
 */

public class Usuario {
    int sexo;
    String Nombres;
    String Apellidos;
    String Edad;
    String DNI;

    public  Usuario( String Nombres, String Apellidos ,String DNI, String Edad, int sexo){
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.sexo = sexo;
        this.Edad = Edad;
        this.DNI = DNI;
    }
}
