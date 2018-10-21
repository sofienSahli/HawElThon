package soft.dot.com.hawelthon.activities.add.service;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import soft.dot.com.hawelthon.R;

public class ChooseTypeFragment extends Fragment {

    private CardView cardService;
    private CardView cardProduct;


    public ChooseTypeFragment() {
        // Required empty public constructor
    }

    public static ChooseTypeFragment newInstance() {
        ChooseTypeFragment fragment = new ChooseTypeFragment();
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
        View view = inflater.inflate(R.layout.fragment_choose_type, container, false);

        cardService = view.findViewById(R.id.chooseTypeFragment_card_service);
        cardProduct = view.findViewById(R.id.chooseTypeFragment_card_product);

        cardService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cardProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.addService_frame_content, ChooseTypeFragment.newInstance()).commit();

            }
        });

        return view;
    }








}
