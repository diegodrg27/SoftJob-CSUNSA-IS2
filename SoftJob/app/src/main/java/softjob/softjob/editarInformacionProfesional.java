package softjob.softjob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class editarInformacionProfesional extends AppCompatActivity {
    Button Aceptar, Cancelar;
    EditText et_Grados, et_Experiencia;
    private String KeyUsuario;
    private int A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_informacion_profesional);

        SharedPreferences prefs =
                getSharedPreferences("InfoUsuario", Context.MODE_PRIVATE);
        final String IdUsuario = prefs.getString("ID", "");

            /*Toast toas = Toast.makeText(getApplicationContext(), IdUsuario, Toast.LENGTH_SHORT);
            toas.show();*/

        if(IdUsuario.isEmpty()){
            Toast toas = Toast.makeText(getApplicationContext(), "Error del Sistema", Toast.LENGTH_SHORT);
            toas.show();
            Intent intent = new Intent(editarInformacionProfesional.this, MainActivity.class);
            startActivity(intent);

        }

        else{
            final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("InfoProfesional");

            final Query myTopPostsQuery = databaseReference.orderByChild("IdUsuario").equalTo(IdUsuario).limitToFirst(1);

            myTopPostsQuery.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot messageSnapshot: dataSnapshot.getChildren()) {
                        //Log.d("Key: ",KeyUsuario);
                        KeyUsuario = messageSnapshot.getKey();

                        InfoProfesional info = messageSnapshot.getValue(InfoProfesional.class);

                        et_Grados.setText(info.GradosSuperiores);
                        et_Experiencia.setText(info.ExperienciaLaboral);

                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Error en cargar los datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();
                    Intent intent = new Intent(editarInformacionProfesional.this,MainActivity.class);
                    startActivity(intent);
                }
            });
        }

        Aceptar = (Button) findViewById(R.id.btn_Aceptar);
        Cancelar = (Button) findViewById(R.id.btn_Cancelar);

        et_Grados = (EditText)findViewById(R.id.et_Grados);
        et_Experiencia = (EditText) findViewById(R.id.et_Experiencia);

        Cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(editarInformacionProfesional.this,MainActivity.class);
                startActivity(intent);

            }
        });

        Aceptar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                String Grados= et_Grados.getText().toString();
                String Experiencia = et_Experiencia.getText().toString();

                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference()
                        .child("InfoProfesional");

                dbRef.child(KeyUsuario).setValue(new InfoProfesional(IdUsuario,Grados,Experiencia), new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(databaseError == null) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Se envio de datos", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                            toast1.show();
                            Intent intent = new Intent(editarInformacionProfesional.this, MainActivity.class);
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
}
