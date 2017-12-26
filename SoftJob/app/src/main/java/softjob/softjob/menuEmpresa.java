package softjob.softjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class menuEmpresa extends Fragment implements  View.OnClickListener  {
    //crear objetos
    GridView gridView;
    Button btRegistrar;
    TextView texto;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<String> Empresas;
    ArrayAdapter<String> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_menu_empresa, container, false);
        database= FirebaseDatabase.getInstance();
        btRegistrar =(Button)v.findViewById(R.id.btRegistrarEmpresa);
        texto=(TextView)v.findViewById(R.id.txtEmpresa);
        btRegistrar.setOnClickListener(this);
        gridView=(GridView)v.findViewById(R.id.gvEmpresa);
        databaseReference=database.getReference().child("Empresa");
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Empresas);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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
}
