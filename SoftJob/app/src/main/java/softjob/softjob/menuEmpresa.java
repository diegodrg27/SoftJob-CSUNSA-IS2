package softjob.softjob;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class menuEmpresa extends Fragment implements  View.OnClickListener  {
    //crear objetos
    Button btRegistrar;
    TextView texto;
    DatabaseReference database;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //btRegistrar =(Button) findViewById(R.id.btRegistrarEmpresa);
        View v= inflater.inflate(R.layout.fragment_menu_empresa, container, false);
        database= FirebaseDatabase.getInstance().getReference("Empresa");
        btRegistrar =(Button)v.findViewById(R.id.btRegistrarEmpresa);
        texto=(TextView)v.findViewById(R.id.txtEmpresa);
        ///btRegistrar.setOnClickListener();
        btRegistrar.setOnClickListener(this);
        return  v;
    }
    public void onClick(View vista){
        switch (vista.getId()){
            case R.id.btRegistrarEmpresa:
                texto.setText("Apretaste registrar empresa");
        }
    }
}
