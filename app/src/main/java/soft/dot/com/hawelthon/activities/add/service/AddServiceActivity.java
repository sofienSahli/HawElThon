package soft.dot.com.hawelthon.activities.add.service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import soft.dot.com.hawelthon.R;

public class AddServiceActivity extends AppCompatActivity {

    FrameLayout mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_service);

        intViews();

        getSupportFragmentManager().beginTransaction().add(R.id.addService_frame_content, ChooseTypeFragment.newInstance()).commit();

    }

    private void intViews() {
        mContent = findViewById(R.id.addService_frame_content);
    }
}
