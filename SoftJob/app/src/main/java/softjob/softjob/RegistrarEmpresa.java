package softjob.softjob;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistrarEmpresa extends AppCompatActivity implements  View.OnClickListener{
    Button btcancelar;
    Button btenviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_empresa);
        btcancelar=(Button)this.findViewById(R.id.btcancelar);
        btcancelar.setOnClickListener(this);
        btcancelar.setOnClickListener(this);
        btenviar=(Button)this.findViewById(R.id.btenviar);
    }
    public void onClick(View vista){
        switch (vista.getId()){
            case R.id.btcancelar:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

        }
    }
}
