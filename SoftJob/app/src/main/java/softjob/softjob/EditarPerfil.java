package softjob.softjob;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EditarPerfil extends AppCompatActivity {

    private int sexo;
    private String sNombre;
    private String sApellido;
    private String sEdad;
    private String sDNI;
    private boolean isPush = false;

    Button Cancelar;
    Button Enviar;

    EditText Nombre;
    EditText Apellido;
    EditText Edad;
    EditText DNI;

    DatabaseReference ref = FirebaseDatabase.getInstance().getReference(); //base de datos
    DatabaseReference mensajeRef = ref.child("Usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        Cancelar = (Button) findViewById(R.id.cancelar);
        Enviar = (Button) findViewById(R.id.enviar);
        Nombre = (EditText) findViewById(R.id.et_Nombre);
        Apellido = (EditText) findViewById(R.id.et_Apellido);
        Edad = (EditText) findViewById(R.id.et_Edad);
        DNI = (EditText) findViewById(R.id.et_DNI);




        Cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(EditarPerfil.this,MainActivity.class);

                startActivity(intent);


            }
        });

        Enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                sNombre = Nombre.getText().toString();
                sApellido = Apellido.getText().toString();
                sEdad = Edad.getText().toString();
                sDNI = DNI.getText().toString();

                if(sNombre.isEmpty() ||sDNI.isEmpty()){
                    Toast toastAviso = Toast.makeText(getApplicationContext(), "Completar el Registro!", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toastAviso.show();
                }
                else{

                    //cont_direccion = etDireccion.getText().toString();
                    //Toast toastAviso = Toast.makeText(getApplicationContext(), "Puntación: "+suma, Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    //toastAviso.show();

                    DatabaseReference newPostRef = mensajeRef.push();
                    newPostRef.setValue(new Usuario(sNombre,sApellido,sDNI,sEdad,sexo));

                    //Toast toast1 = Toast.makeText(getApplicationContext(), "Se envió el Mensaje", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    //toast1.show();

                    ProgressDialog.show(
                            EditarPerfil.this
                            ,"Un momento.."
                            ,"Enviando Mensaje"
                            ,true
                            ,true);

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Se envió el Registro", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();

                    Intent intent = new Intent(EditarPerfil.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });



    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rb_hombre:
                if (checked)
                    isPush =true;
                sexo = 1;
                break;
            case R.id.rb_mujer:
                if (checked)
                    isPush =true;
                sexo = 0;
                break;
        }
    }

}
