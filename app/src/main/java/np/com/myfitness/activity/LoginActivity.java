package np.com.myfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import java.util.Objects;

import np.com.myfitness.BottomNav;
import np.com.myfitness.R;
import np.com.myfitness.fragment.HomeFragment;
import np.com.myfitness.remote.ApiInterface;
import np.com.myfitness.remote.ApiUtils;
import np.com.myfitness.remote.UserModel;
import np.com.myfitness.utility.TokenManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private TextView forget_password;
    private Button btLogin;
    private EditText email , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

String token = TokenManager.getToken(getApplicationContext());
if(token !=null){
    Intent tokenIntent= new Intent(this, BottomNav.class);
    startActivity(tokenIntent);
}

forget_password= findViewById(R.id.forget_password);
Intent textIntent= new Intent(this, ForgetPasswordActivity.class);
Intent loginIntent= new Intent(this, BottomNav.class);
forget_password.setOnClickListener(v -> startActivity(textIntent));


email=findViewById(R.id.email);
password=findViewById(R.id.password);
btLogin=findViewById(R.id.btLogin);

btLogin.setOnClickListener(v -> {
    String userEmail = email.getText().toString();
    String userPassword = password.getText().toString();
    ApiInterface loginService = ApiUtils.getService(LoginActivity.this).create(ApiInterface.class);
    UserModel userModel = new UserModel(null,null,null,userEmail, userPassword);
    Call<UserModel> call = loginService.postApiInterface(userModel);

    call.enqueue(new Callback<UserModel>() {
        @Override
        public void onResponse(Call<UserModel> call, Response<UserModel> response) {
            if (response.isSuccessful()){
                Log.v( "LoginActivity","success");
                UserModel responseUserModel =response.body();
                String token =responseUserModel.getToken();
                String success=responseUserModel.getSuccess();
                if (Objects.equals(success,"true")){
                    Log.v("LoginActivity","true");
                    TokenManager.saveToken(getApplicationContext(),token);
                }

                startActivity(loginIntent);

            }
        }

        @Override
        public void onFailure(Call<UserModel> call, Throwable throwable) {

        }
    });
});


    }


}