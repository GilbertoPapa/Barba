package com.example.barba;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barba.api.UsuarioAPI;
import com.example.barba.model.Usuario;
import com.example.barba.util.DeserializerUsuario;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class LoginClienteActivity extends AppCompatActivity {


    public static final String TAG = "LOG";
    public static final String API = "http..";
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_cliente);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.loginButton);

        loginButton.setReadPermissions(Arrays.asList("email"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                goMainScreen();
            }

            @Override
            public void onCancel() {
                notify1(toolbar);

            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }

        });



        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    // -----> teste cadastro

    private void executeGraphRequest(final String userId) {
        GraphRequest request = new GraphRequest(AccessToken.getCurrentAccessToken(), userId, null, HttpMethod.GET, new GraphRequest.Callback() {
            @Override
            public void onCompleted(GraphResponse response) {
                Log.i("FACEBOOK", response.getJSONObject().toString());
                Log.i("FACEBOOK", Profile.getCurrentProfile().toString());
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, name, email, gender, birthday");
        request.setParameters(parameters);
        request.executeAsync();

    }

    private void goMainScreen() {
        Intent intent = new Intent(this,PesquisaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void notify1(View v) {

        Toast t = new Toast(this);
        t.setGravity(Gravity.CENTER, 0, 0);
        View view = getLayoutInflater().inflate(R.layout.toast1, null);
        TextView textView = (TextView) view.findViewById(R.id.textToast1);
        textView.setText("Cadastre-se em Nosso Site");
        t.setView(view);

        t.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

        Gson gson = new GsonBuilder().registerTypeAdapter(Usuario.class, new DeserializerUsuario()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        UsuarioAPI usuarioAPI = retrofit.create(UsuarioAPI.class);



        //get usuario request
        Call<Usuario> call = usuarioAPI.getUser("...");
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Response<Usuario> response, Retrofit retrofit) {
                Usuario u = response.body();

                if (u != null){
                    //gets das infos

                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG,"");

            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

}
