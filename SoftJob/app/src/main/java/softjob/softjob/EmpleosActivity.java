package softjob.softjob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmpleosActivity extends AppCompatActivity {
    EditText editTextTitulo;
    Button buttonAdd;
    Spinner spinnerCategorias;
    DatabaseReference databaseTrabajos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleos);

        editTextTitulo = (EditText)findViewById(R.id.editTextTitulo);
        buttonAdd = (Button)findViewById(R.id.buttonAddTrabajo);
        spinnerCategorias = (Spinner) findViewById(R.id.spinnerCategorias);

        databaseTrabajos = FirebaseDatabase.getInstance().getReference("trabajos");



        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addTrabajo();
            }
        });
    }

    private void addTrabajo(){

        String titulo = editTextTitulo.getText().toString().trim();
        String categoria = spinnerCategorias.getSelectedItem().toString();

        if (!TextUtils.isEmpty(titulo)){
            String id = databaseTrabajos.push().getKey();
            Trabajo trabajo =  new Trabajo(id, categoria, titulo );
            databaseTrabajos.child(id).setValue(trabajo);
            Toast.makeText(this, "Trabajo agregado", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Debes ingresar un titulo para el empleo", Toast.LENGTH_LONG).show();
        }
    }
}
