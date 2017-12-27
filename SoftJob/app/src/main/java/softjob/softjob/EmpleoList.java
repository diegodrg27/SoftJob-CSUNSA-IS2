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

public class EmpleoList extends ArrayAdapter<Empleo> {
    private Activity context;
    private List<Empleo> empleoList;

    public EmpleoList(Activity context, List<Empleo> empleoList){
        super(context, R.layout.list_layout, empleoList);
        this.context = context;
        this.empleoList = empleoList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        //return super.getView(position, convertView, parent);
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView txtTitulo = (TextView)listViewItem.findViewById(R.id.txtTitulo);
        TextView txtCategoria = (TextView)listViewItem.findViewById(R.id.txtCategoria);

        Empleo empleo = empleoList.get(position);

        txtTitulo.setText(empleo.getTitulo());
        txtCategoria.setText(empleo.getId_categoria());
        return listViewItem;
    }
}
