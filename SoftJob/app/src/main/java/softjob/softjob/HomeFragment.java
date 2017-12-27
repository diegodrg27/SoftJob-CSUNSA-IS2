package softjob.softjob;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment {
    Spinner spDesastre;
    String cont_desastre;//recibes lo que eliges en el spinner

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_home, container, false);
        spDesastre=(Spinner)v.findViewById(R.id.spDesastre);
        /*****************************Configurar Spinner************************************/
        String[] desastres = new String[]{//contendor del tipo de desastre
                "Seleccione Categoría",
                "Mantenimiento y Reparaciones Técnica",
                "Ingenierías",
                "Producción y Operarios",
                "Construcción y Obra",
                "Recursos Humanos",
        };
        final List<String> desastresList = new ArrayList<>(Arrays.asList(desastres));//crear un List a partir de una array de strings

        final ArrayAdapter<String> adapterDesastre = new ArrayAdapter<String>(getContext(),R.layout.spinner_item,desastresList){
            //Array adapter en el cual recibe principalmente la fuente en la cual estaran los strings y el List de los desastres
            //estas funciones configuran cada item del spinner
            @Override
            public boolean isEnabled(int position){//esta funcion establece cuales elementos del desastresList o List estan habilitados
                if(position == 0){
                    return true;
                }

                else{
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent){
                View view = super.getDropDownView(position,convertView,parent);//se llama asi mismo para recibir cada item del list atraves del view
                TextView tv =(TextView) view;//recibimos el item usando un objeto TextView

                if(position == 0){
                    tv.setTextColor(Color.GRAY);//modificamos la fuente del texto
                }
                else{
                    tv.setTextColor(Color.BLACK);
                }

                return view;//retornamos el view
            }
        };

        adapterDesastre.setDropDownViewResource(R.layout.spinner_item);//recibe la configuracion del spinneritem.xml
        spDesastre.setAdapter(adapterDesastre);//Ingresamos el Array adapter en el spinner

        spDesastre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){//configuramos las acciones cuando un item es seleccionado
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                String selectedItemText =(String) parent.getItemAtPosition(position);

                if(position > 0){
                    cont_desastre = spDesastre.getSelectedItem().toString();//obtiene el item en string
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    return  v;
    }
}
