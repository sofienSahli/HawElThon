package soft.dot.com.hawelthon.activities.home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.entities.Post;
import soft.dot.com.hawelthon.entities.User;

public class ProfileFragment extends Fragment {
    TextView name, phone, address, mail;
    public static User user;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.fragment_profil, container, true);
        name = view.findViewById(R.id.name);
        phone = view.findViewById(R.id.phone);
        address = view.findViewById(R.id.address);
        mail = view.findViewById(R.id.mail);
        recyclerView = view.findViewById(R.id.post);
        setUpProfil();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void setUpProfil() {

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(mLayoutManager);
        ArrayList<Post> mListPosts = new ArrayList<Post>() ;
        mListPosts.add(new Post(1, "https://images.wallpaperscraft.com/image/man_sitting_chair_90508_1920x1080.jpg", "J'ai une voiture occasion à vendre/échanger contre des cours particulers pour mon fils et ceux sur la durée d'une de 3 ans à hauteur de 3 heures par semaines"));
        mListPosts.add(new Post(2, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(4, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(5, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(43, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(12, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(532, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(12412, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(1412, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));
        mListPosts.add(new Post(2523, "https://images.wallpaperscraft.com/image/man_car_sand_sitting_surfer_ferfing_55200_1920x1080.jpg", "Surfeur amateur désire vendre/échanger sa planche contre un skateboard"));

        PostsAdapter postsAdapter = new PostsAdapter(mListPosts, getActivity());
        recyclerView.setAdapter(postsAdapter);
   }
}
