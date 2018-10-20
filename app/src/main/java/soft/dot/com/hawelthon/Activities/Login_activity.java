package soft.dot.com.hawelthon.Activities;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.data.UserSharedPref;
import soft.dot.com.hawelthon.entities.User;
import soft.dot.com.hawelthon.services.implementation.UserService;

public class Login_activity extends AppCompatActivity implements View.OnClickListener, Callback<User> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        getWindow().setEnterTransition(new Fade());
        getWindow().setExitTransition(new ChangeImageTransform());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_login:
                sign_in_user();
                break;
            case R.id.button:
                Intent intent = new Intent(this, SignUp_Activity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }

    private void sign_in_user() {
        User user = new User();
        UserService userService = new UserService();
        userService.logIn(user, this);

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
        Toast.makeText(this, "Failed to acces remote server please retry later", Toast.LENGTH_SHORT).show();
        Log.e("Sing_in Erreur", t.getMessage());

    }
}
