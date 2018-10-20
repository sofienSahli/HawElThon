package soft.dot.com.hawelthon.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.data.UserSharedPref;
import soft.dot.com.hawelthon.entities.User;
import soft.dot.com.hawelthon.services.implementation.UserService;

public class SignUp_Activity extends AppCompatActivity implements Callback<User> {
    EditText cin, first_name, last_name, mail, phone, job, address, password, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        cin = findViewById(R.id.cin);
        first_name = findViewById(R.id.first_name);
        last_name = findViewById(R.id.last_name);
        mail = findViewById(R.id.email);
        phone = findViewById(R.id.num_phone);
        job = findViewById(R.id.job);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confimr_password);
        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register_user();
            }
        });

    }

    private void register_user() {
        User user = new User();
        long cin = Long.parseLong(this.cin.getText().toString());
        user.setCin(cin);
        user.setFirst_name(first_name.getText().toString());
        user.setLast_name(last_name.getText().toString());
        user.setMail(mail.getText().toString());
        user.setJob(job.getText().toString());
        user.setAddress(address.getText().toString());
        user.setPassword(password.getText().toString());
        cin = Long.parseLong(this.phone.getText().toString());
        user.setCin(cin);
        UserService userService = new UserService();
        userService.SignUpUser(user, this);
    }


    @Override
    public void onResponse(Call<User> call, Response<User> response) {
        if (response.code() == 200) {
            UserSharedPref userSharedPref = new UserSharedPref(getSharedPreferences(UserSharedPref.USER_FILE, Context.MODE_PRIVATE));
            userSharedPref.logIn(response.body());
        }
    }

    @Override
    public void onFailure(Call<User> call, Throwable t) {
        Toast.makeText(this, "Failed to access remote server ", Toast.LENGTH_SHORT).show();
        Log.e("Inscription error ", t.getMessage());
    }
}
