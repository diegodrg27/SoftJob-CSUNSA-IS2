package softjob.softjob;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.Query;

public class DatosPersonales extends AppCompatActivity {

    EditText Nombres, Apellidos, DNI, Direccion, Celular, Telefono, Correo;
    RadioButton rbHombre, rbMujer;
    Button Aceptar, Cancelar;

    String uid;
    String sexo="";
    boolean radSex= false;

    boolean isUserData = false;

    String nameApi;
    String emailApi;


    private String KeyUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_personales);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Nombres = (EditText) findViewById(R.id.et_nombres);
        Apellidos = (EditText) findViewById(R.id.et_Apellidos);
        DNI = (EditText) findViewById(R.id.et_DNI);
        Direccion = (EditText) findViewById(R.id.et_Direccion);
        Celular = (EditText) findViewById(R.id.et_Celular);
        Telefono = (EditText) findViewById(R.id.et_Telefono);
        Correo = (EditText) findViewById(R.id.et_Correo);
        rbHombre = (RadioButton)findViewById(R.id.rb_Hombre);
        rbMujer = (RadioButton)findViewById(R.id.rb_Mujer);

        Aceptar = (Button) findViewById(R.id.btn_Aceptar);
        Cancelar = (Button) findViewById(R.id.btn_Cancelar);

        if(user !=null){//trabajar sobre el datos del usuario
            nameApi = user.getDisplayName();
            emailApi = user.getEmail();

            //Uri photoUrl = user.getPhotoUrl();

            //Nombres.setText(name);
            //Correo.setText(email);

            uid = user.getUid();

            final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuarios");

            final Query myTopPostsQuery = databaseReference.orderByChild("id_api").equalTo(uid).limitToFirst(1);

            myTopPostsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if(dataSnapshot.getValue()!=null){//verifica si esta en la base de datos
                        for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {

                            KeyUsuario = messageSnapshot.getKey();
                            //Log.d("Key: ",KeyUsuario);

                            Usuario usuario = messageSnapshot.getValue(Usuario.class);

                            Nombres.setText(usuario.Nombres);
                            Apellidos.setText(usuario.Apellidos);
                            DNI.setText(usuario.DNI);
                            Celular.setText(usuario.Celular);
                            Correo.setText(usuario.Correo);
                            Direccion.setText(usuario.Direccion);
                            Telefono.setText(usuario.Telefono);

                            System.out.println("Sexo:" + usuario.Sexo);



                            if(usuario.Sexo.equals("H")){
                                    /*Toast toast1 = Toast.makeText(getApplicationContext(), "Hombre", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                                    toast1.show();*/
                                rbHombre.setChecked(true);
                                sexo = "H";
                                radSex =true;
                            }

                            else if(usuario.Sexo.equals("M")){
                                    /*Toast toast1 = Toast.makeText(getApplicationContext(), "Mujer", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                                    toast1.show();*/
                                rbMujer.setChecked(true);
                                sexo = "M";
                                radSex =true;
                            }

                        }

                    }

                    else{
                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference(); //base de datos
                        DatabaseReference dataRef = reference.child("Usuarios");

                        DatabaseReference newPostRef = dataRef.push();
                        boolean enviarData = newPostRef.setValue(new Usuario(uid, nameApi, "", "", "", "", "", "", emailApi)).isSuccessful();
                        KeyUsuario = newPostRef.getKey();
                        if (enviarData) {

                            Toast toast1 = Toast.makeText(getApplicationContext(), "Surgio un Error", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                            toast1.show();
                            Intent intent = new Intent(DatosPersonales.this,MainActivity.class);
                            startActivity(intent);

                        } else {
                            //Toast toast1 = Toast.makeText(getApplicationContext(), "Se crearan sus datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                            //toast1.show();
                            Nombres.setText(nameApi);
                            Correo.setText(emailApi);

                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Error en cargar los datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();
                    Intent intent = new Intent(DatosPersonales.this,MainActivity.class);
                    startActivity(intent);
                }
            });


        }else{
            goLoginScreen();
        }


        Cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(DatosPersonales.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String nombres = Nombres.getText().toString();
                String apellidos = Apellidos.getText().toString();
                String dni = DNI.getText().toString();
                String direccion = Direccion.getText().toString();
                String celular = Celular.getText().toString();
                String telefono = Telefono.getText().toString();
                String correo = Correo.getText().toString();

                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference()
                        .child("Usuarios");



                dbRef.child(KeyUsuario).setValue(new Usuario(uid, nombres, apellidos, dni, sexo, telefono, celular, direccion, correo), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(databaseError == null) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Se envio de datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                            toast1.show();
                            Intent intent = new Intent(DatosPersonales.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Error en el envio de datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                            toast1.show();
                        }
                    }
                });

                /********************************/

            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rb_Hombre:
                if (checked)
                    sexo = "H";
                radSex =true;

                break;
            case R.id.rb_Mujer:
                if (checked)
                    sexo = "M";
                radSex =true;
                break;
        }
    }


    private void goLoginScreen() {//retorna a la actividad login
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); //ver sirve para evitar la pila de eventos
        startActivity(intent);
    }
}
