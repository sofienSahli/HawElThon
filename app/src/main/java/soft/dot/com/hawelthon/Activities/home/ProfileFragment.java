package soft.dot.com.hawelthon.activities.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.data.UserSharedPref;
import soft.dot.com.hawelthon.entities.User;

public class ProfileFragment extends Fragment {
    TextView name, phone, address, mail;
    Button update;
    public static User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.fragment_profil, container, false);
        update = view.findViewById(R.id.update_profil);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        mail = view.findViewById(R.id.mail);
        setUpProfil();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpProfil() {
        UserSharedPref userSharedPref = new UserSharedPref(getActivity().getSharedPreferences(UserSharedPref.USER_FILE, Context.MODE_PRIVATE));
        if (userSharedPref.getLong(UserSharedPref.USER_CIN) != user.getCin()) {
            update.setVisibility(View.GONE);
        }
        String nom = user.getFirst_name() + "   " + user.getLast_name();
        name.setText(nom);
        phone.setText(user.getPhone() + "");
        address.setText(user.getAddress());
        mail.setText(user.getMail());
    }
}
