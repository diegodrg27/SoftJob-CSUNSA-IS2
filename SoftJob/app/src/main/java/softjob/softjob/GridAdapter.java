package softjob.softjob;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Moebius on 27/12/2017.
 */

public class GridAdapter   extends BaseAdapter{
    Context context;
    public final ArrayList<String> values;
    View view;
    LayoutInflater layoutInflater;

    public int getCount()
    {
        return  values.size();
    }
    public Object getItem(int position){
        return  null;
    }
    public Object getCount(int position)
    {
        return 0;
    }

    public  long getItemId(int position)
    {
        return  0;
    }
    public GridAdapter(Context context, ArrayList<String> values) {
        this.context = context;
        this.values = values;
    }

    public GridAdapter(Context context, ArrayList<String> values, View view, LayoutInflater layoutInflater) {
        this.context = context;
        this.values = values;
        this.view = view;
        this.layoutInflater = layoutInflater;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public View getView(int position, View converView, ViewGroup parent)
    {
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(converView==null){
            view=new View(context);
            view=layoutInflater.inflate(R.layout.single_item,null);
            TextView textView=(TextView)view.findViewById(R.id.textview);
            textView.setText(values.get(position));
        }
        return  view;
    }

}
