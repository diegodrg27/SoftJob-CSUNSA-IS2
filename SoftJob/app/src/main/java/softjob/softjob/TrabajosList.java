package softjob.softjob;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jairf on 16/12/2017.
 */

public class TrabajosList extends ArrayAdapter<Trabajo>{
    private Activity context;
    private List<Trabajo> trabajoList;

    public TrabajosList(Activity context, List<Trabajo> trabajoList){
        super(context, R.layout.list_layout, trabajoList);
        this.context = context;
        this.trabajoList = trabajoList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewTitulo = (TextView)listViewItem.findViewById(R.id.textViewTitulo);
        TextView textViewCategoria = (TextView)listViewItem.findViewById(R.id.textViewCategoria);

        Trabajo trabajo = trabajoList.get(position);
        textViewTitulo.setText(trabajo.getTitulo());
        textViewCategoria.setText(trabajo.getId_categoria());


        return listViewItem;
    }

}
