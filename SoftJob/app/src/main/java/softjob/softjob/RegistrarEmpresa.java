package softjob.softjob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrarEmpresa extends AppCompatActivity {
    EditText et_Nombre;
    EditText et_RUC;
    EditText et_Direccion;
    EditText et_Telefono;
    EditText et_Categoria;
    EditText et_Descripcion;
    EditText et_Correo;
    EditText et_Website;
    Button btcancelar;
    Button btenviar;
    String IdUsuario;

    DatabaseReference databaseEmpresas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);

        databaseEmpresas = FirebaseDatabase.getInstance().getReference("empresas");

        SharedPreferences prefs =
                getSharedPreferences("InfoUsuario", Context.MODE_PRIVATE);
        IdUsuario = prefs.getString("ID", "");

        et_Nombre = (EditText)findViewById(R.id.et_Nombre);
        et_RUC = (EditText)findViewById(R.id.et_RUC);
        et_Direccion = (EditText)findViewById(R.id.et_Direccion);
        et_Telefono = (EditText)findViewById(R.id.et_Telefono);
        //et_Categoria = (EditText)findViewById(R.id.et_Categoria);
        et_Descripcion = (EditText) findViewById(R.id.et_Descripcion);
        et_Correo = (EditText) findViewById(R.id.et_Correo);
        et_Website = (EditText) findViewById(R.id.et_Website);
        btcancelar = (Button)findViewById(R.id.btcancelar);
        btenviar = (Button)findViewById(R.id.btenviar);

        btenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEmpresa();
            }
        });

        btcancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrarEmpresa.this, MainActivity.class));
            }
        });
    }

    private void addEmpresa(){
        String nombre = et_Nombre.getText().toString().trim();
        String ruc = et_RUC.getText().toString().trim();
        String direccion = et_Direccion.getText().toString().trim();
        String telefono = et_Telefono.getText().toString().trim();
        //String categoria = et_Categoria.getText().toString().trim();
        String descripcion = et_Descripcion.getText().toString().trim();
        String correo = et_Correo.getText().toString().trim();
        String website = et_Website.getText().toString().trim();


        if (!TextUtils.isEmpty(nombre)){
            String id = databaseEmpresas.push().getKey();

            Empresa empresa = new Empresa(IdUsuario,correo, descripcion, direccion, nombre, ruc, telefono, website);
            databaseEmpresas.child(id).setValue(empresa);
            Toast.makeText(this, "Empresa agregada!", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(RegistrarEmpresa.this, MainActivity.class));
        } else {
            Toast.makeText(this, "Debes ingresar un nombre para la empresa", Toast.LENGTH_LONG).show();
        }
    }
}
