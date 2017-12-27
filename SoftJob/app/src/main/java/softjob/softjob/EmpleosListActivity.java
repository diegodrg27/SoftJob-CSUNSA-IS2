package softjob.softjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EmpleosListActivity extends AppCompatActivity {
    ListView listViewEmpleos;
    DatabaseReference databaseEmpleos;
    List<Empleo> empleoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleos_list);

        databaseEmpleos = FirebaseDatabase.getInstance().getReference("empleos");
        Button btn = (Button)findViewById(R.id.btnAddEmpleo);
        listViewEmpleos = (ListView)findViewById(R.id.listViewEmpleos);
        empleoList = new ArrayList<>();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EmpleosListActivity.this, EmpleosActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseEmpleos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                empleoList.clear();

                for (DataSnapshot empleosSnapshot: dataSnapshot.getChildren()){
                    Empleo empleo =  empleosSnapshot.getValue(Empleo.class);

                    empleoList.add(empleo);
                }

                EmpleoList adapter = new EmpleoList(EmpleosListActivity.this, empleoList);
                listViewEmpleos.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
