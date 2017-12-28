package softjob.softjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


public class menuEmpresa extends Fragment implements  View.OnClickListener  {
    //crear objetos
    GridView gridView;
    Button btRegistrar;
    TextView texto;
    FirebaseDatabase database;
    DatabaseReference databaseEmpresas;
    ArrayList<String> Empresas;
    ArrayAdapter<String> adapter;
    ListView listViewEmpresas;
    List<Empresa> empresaList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_menu_empresa, container, false);
        database= FirebaseDatabase.getInstance();
        btRegistrar =(Button)v.findViewById(R.id.btRegistrarEmpresa);
        //texto=(TextView)v.findViewById(R.id.txtEmpresa);
        btRegistrar.setOnClickListener(this);

        databaseEmpresas = FirebaseDatabase.getInstance().getReference("empresas");
        listViewEmpresas = (ListView)v.findViewById(R.id.listViewEmpresas);
        empresaList = new ArrayList<>();


        ChildEventListener child=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String empresaid=dataSnapshot.getKey().toString();
                String Correo=dataSnapshot.getValue().toString();
                String Descripcion=dataSnapshot.getValue().toString();
                String Dirección=dataSnapshot.getValue().toString();
                String Empleos=dataSnapshot.getValue().toString();
                String Nombre=dataSnapshot.getValue().toString();
                texto.setText(Correo);
                Log.d("DatosEmpresa",dataSnapshot.toString());
                Toast toas = Toast.makeText(getApplicationContext(), "Lee data", Toast.LENGTH_SHORT);
                toas.show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        //databaseReference.addChildEventListener(child);
        //adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Empresas);

        /*databaseReference.child("Empresa 1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Empresa empresa1=dataSnapshot.getValue(Empresa.class);
                System.out.println(dataSnapshot);
                //texto.setText(empresa1.getNombre());
                Log.i("DatosEmpresa",dataSnapshot.toString());
                pruevatext=dataSnapshot.toString();
                texto.setText(pruevatext);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        return  v;
    }
    public void onClick(View vista){
        switch (vista.getId()){
            case R.id.btRegistrarEmpresa:
                //texto.setText("APlicar xD");
                //Intent intent = new Intent(menuEmpresa.this,RegistrarEmpresa.class);
                Intent intent = new Intent(getActivity(),RegistrarEmpresa.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseEmpresas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                empresaList.clear();

                for (DataSnapshot empresasSnapshot: dataSnapshot.getChildren()){
                    Empresa empresa =  empresasSnapshot.getValue(Empresa.class);

                    empresaList.add(empresa);
                }

                //softjob.softjob.EmpresaList adapter = new Empresa(RegistrarEmpresa.this, empresaList);
                //GridAdapter adapt = new A
                listViewEmpresas.setAdapter(adapter);
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
