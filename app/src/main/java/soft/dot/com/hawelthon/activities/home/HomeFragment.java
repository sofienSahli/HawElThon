package soft.dot.com.hawelthon.activities.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.entities.Post;

public class HomeFragment extends Fragment {

    RecyclerView mRecyclerView;
    List<Post> mListPosts = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = view.findViewById(R.id.homeFragment_rcv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mListPosts.add(new Post(1, "https://images.wallpaperscraft.com/image/man_sitting_chair_90508_1920x1080.jpg", "dazdzad"));
        mListPosts.add(new Post(2, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "fzefffff"));

        mRecyclerView.setAdapter(new PostsAdapter(mListPosts));

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
