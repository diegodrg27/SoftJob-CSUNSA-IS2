package softjob.softjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EmpleosActivity extends AppCompatActivity {

    EditText txtTitulo;
    EditText txtDescripcion;
    EditText dateFechaLimite;
    EditText txtHabDuras;
    EditText txtHabBlandas;
    Spinner spinnerCategorias;
    Button btnGuardar;
    Button btnCancelar;

    DatabaseReference databaseEmpleos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleos);

        databaseEmpleos = FirebaseDatabase.getInstance().getReference("empleos");

        txtTitulo = (EditText)findViewById(R.id.txtTitulo);
        txtDescripcion = (EditText)findViewById(R.id.txtDescripcion);
        txtHabDuras = (EditText)findViewById(R.id.txtHabDuras);
        txtHabBlandas = (EditText)findViewById(R.id.txtHabBlandas);
        dateFechaLimite = (EditText)findViewById(R.id.dateFechaLimite);
        spinnerCategorias = (Spinner)findViewById(R.id.spinnerCategorias);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmpleo();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EmpleosActivity.this, MainActivity.class));
            }
        });
    }

    private void addEmpleo(){
        String titulo = txtTitulo.getText().toString().trim();
        String categoria = spinnerCategorias.getSelectedItem().toString();
        String descripcion = txtDescripcion.getText().toString().trim();
        String habDuras = txtHabDuras.getText().toString().trim();
        String habBlandas = txtHabBlandas.getText().toString().trim();
        String fecha_limite = dateFechaLimite.getText().toString().trim();


        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String fecha_publicacion = df.format(c.getTime());

        if (!TextUtils.isEmpty(titulo)){
            String id = databaseEmpleos.push().getKey();

            Empleo empleo = new Empleo(id, titulo, descripcion, habDuras, habBlandas, fecha_publicacion, fecha_limite, categoria);
            databaseEmpleos.child(id).setValue(empleo);
            Toast.makeText(this, "Empleo agregado!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(EmpleosActivity.this, MainActivity.class));
        } else {
            Toast.makeText(this, "Debes ingresar un titulo para el empleo", Toast.LENGTH_LONG).show();
        }
    }
}
