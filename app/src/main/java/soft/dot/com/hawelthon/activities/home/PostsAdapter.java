package soft.dot.com.hawelthon.activities.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

import java.util.List;

import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.activities.MainActivity;
import soft.dot.com.hawelthon.entities.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Post> mListPosts;
    Context context;

    public PostsAdapter(List<Post> mListPosts, Context context) {
        this.mListPosts = mListPosts;
        this.context = context;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_post, viewGroup, false);
        PostsViewHolder vh = new PostsViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder postsViewHolder, int i) {
        postsViewHolder.bindItem(mListPosts.get(i));
        postsViewHolder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "I'm clicked", Toast.LENGTH_SHORT).show();
                ((MainActivity) context).commintFragment(new ProfileFragment());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListPosts.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView description;
        ImageView postImage;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.itemPost_txv_username);
            description = itemView.findViewById(R.id.itemPost_txv_description);
            postImage = itemView.findViewById(R.id.itemPost_img_post);

        }

        private void bindItem(Post post) {
            description.setText(post.getDescription());
            RequestBuilder<Bitmap> requestBuilder = Glide.with(itemView.getContext())
                    .asBitmap();
//                    .placeholder(R.drawable.ic_picture_profile);
//                .skipMemoryCache(true)
//                .signature(new ObjectKey(String.valueOf(System.currentTimeMillis())));
            requestBuilder.load(post.getImage()).into(postImage);
        }
    }
}
