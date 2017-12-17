package softjob.softjob;

/**
 * Created by Diego on 16/12/2017.
 */

public class InfoProfesional {
    String IdUsuario;
    String GradosSuperiores;
    String ExperienciaLaboral;

    public InfoProfesional(){

    }

    public InfoProfesional(String IdUsuario,String GradosSuperiores, String ExperienciaLaboral){
        this.IdUsuario = IdUsuario;
        this.GradosSuperiores = GradosSuperiores;
        this.ExperienciaLaboral = ExperienciaLaboral;
    }
}
