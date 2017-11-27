package softjob.softjob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class MainActivity extends AppCompatActivity {

    Button EditarPerfil;
    Button RegistrarEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditarPerfil = (Button) findViewById(R.id.btn_EditarPerfil);
        RegistrarEmpresa = (Button) findViewById(R.id.btn_RegistrarEmpresa);

        if(AccessToken.getCurrentAccessToken() == null){
            goLogInScreen();
        }

        EditarPerfil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,EditarPerfil.class);

                startActivity(intent);


            }
        });

        RegistrarEmpresa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this,RegistrarEmpresa.class);

                startActivity(intent);


            }
        });
    }

    private void goLogInScreen() {
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void LogOut(View view){
        LoginManager.getInstance().logOut();
        goLogInScreen();
    }
}
