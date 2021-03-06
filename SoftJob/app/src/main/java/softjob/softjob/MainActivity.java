package softjob.softjob;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private View popup = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user !=null){//trabajar sobre el datos del usuario SIEMPRE VA A ESTAR ALMACENADO EN EL DISPOSITIVO
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            String uid = user.getUid();

            if(popup == null){
                popup = getLayoutInflater().inflate(R.layout.nav_header_main,null);
            }

            TextView nameUsuario;
            ImageView iconoUsuario;

            nameUsuario = (TextView)popup.findViewById(R.id.tv_nameUsuario);
            nameUsuario.setText(name);

            iconoUsuario = (ImageView)findViewById(R.id.imageView);

            Toast toas = Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT);
            toas.show();
            //iconoUsuario.setImageURI(photoUrl);

            /*SharedPreferences prefs =
                    getSharedPreferences("InfoUsuario",Context.MODE_PRIVATE);

            SharedPreferences.Editor editor = prefs.edit();
            editor.remove("ID");
            editor.commit();

            String IdUsuario = prefs.getString("ID", "");

            Toast toas = Toast.makeText(getApplicationContext(), IdUsuario, Toast.LENGTH_SHORT);
            toas.show();*/

            SharedPreferences prefs =
                    getSharedPreferences("InfoUsuario", Context.MODE_PRIVATE);
            String IdUsuario = prefs.getString("ID", "");

            //Toast toas = Toast.makeText(getApplicationContext(), IdUsuario, Toast.LENGTH_SHORT);
            //toas.show();

            if(IdUsuario.isEmpty()){
                //Toast.makeText(getApplicationContext(),"no hay ID", Toast.LENGTH_SHORT).show();

                DatabaseReference reference = FirebaseDatabase.getInstance().getReference(); //base de datos
                DatabaseReference dataRef = reference.child("Usuarios");

                DatabaseReference newPostRef = dataRef.push();
                boolean enviarData = newPostRef.setValue(new Usuario(uid, name, "", "", "", "", "", "", email)).isSuccessful();
                String KeyUsuario = newPostRef.getKey();
                if (enviarData) {

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Surgio un Error", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();

                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Se crearan sus datos Personales", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("ID", KeyUsuario);
                    editor.commit();
                }


                DatabaseReference dataProfRef = reference.child("InfoProfesional");
                DatabaseReference PostInfoProfesional  = dataProfRef.push();

                boolean enviarDataInfo = PostInfoProfesional.setValue(new InfoProfesional(KeyUsuario,"","")).isSuccessful();
                if (enviarDataInfo) {

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Surgio un Error", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();

                } else {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Se crearan sus datos Profesionales", Toast.LENGTH_SHORT);// muestra un mensaje simple que aparece en un corto periodo de tiempo
                    toast1.show();
                }
            }


            //Toast.makeText(getApplicationContext(),uid, Toast.LENGTH_SHORT).show();


        }else{
            goLoginScreen();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    private void goLoginScreen() {//retorna a la actividad login
        Intent intent = new Intent(this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); //ver sirve para evitar la pila de eventos
        startActivity(intent);
    }

    public void logout(View view){//cerrar secion
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();


        if (id == R.id.nav_home) {
            //fragmentManager.beginTransaction().replace(R.id.contenedor,R.id.contenedor).commit();
            fragmentManager.beginTransaction().replace(R.id.contenedor,new HomeFragment()).commit();

        } else if (id == R.id.nav_datosPersonales) {
            Intent intent = new Intent(MainActivity.this,DatosPersonales.class);
            startActivity(intent);


        } else if (id == R.id.nav_infoProfesional) {
            Intent intent = new Intent(MainActivity.this,editarInformacionProfesional.class);
            startActivity(intent);

        } else if (id == R.id.nav_postulaciones) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new Postulaciones()).commit();

        } else if (id == R.id.nav_empresa) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new menuEmpresa()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
