package soft.dot.com.hawelthon.activities.add.service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import soft.dot.com.hawelthon.R;


public class AddServiceFragment extends Fragment {

    public AddServiceFragment() {
        // Required empty public constructor
    }

    public static AddServiceFragment newInstance() {
        AddServiceFragment fragment = new AddServiceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_service, container, false);
        return view;
    }

}
