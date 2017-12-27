package softjob.softjob;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import softjob.softjob.Empleo;
import softjob.softjob.R;

/**
 * Created by jairf on 26/12/2017.
 */

public class EmpresaList extends ArrayAdapter<Empresa> {
    private Activity context;
    private List<Empresa> empresaList;

    public EmpresaList(Activity context, List<Empresa> empresaList){
        super(context, R.layout.list_empresa_layout, empresaList);
        this.context = context;
        this.empresaList = empresaList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //return super.getView(position, convertView, parent);
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView txtNombre = (TextView)listViewItem.findViewById(R.id.txtNombre);
        TextView txtDescripcion = (TextView)listViewItem.findViewById(R.id.txtDescripcion);

        Empresa empresa = empresaList.get(position);

        txtNombre.setText(empresa.getNombre());
        txtDescripcion.setText(empresa.getDescripcion());
        return listViewItem;
    }
}
