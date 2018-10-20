package soft.dot.com.hawelthon.activities.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import soft.dot.com.hawelthon.R;
import soft.dot.com.hawelthon.entities.Post;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<Post> mListPosts;

    public PostsAdapter(List<Post> mListPosts) {
        this.mListPosts = mListPosts;
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
    }

    @Override
    public int getItemCount() {
        return mListPosts.size();
    }

    class PostsViewHolder extends RecyclerView.ViewHolder {

        TextView username;
        TextView description;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.itemPost_txv_username);
            description = itemView.findViewById(R.id.itemPost_txv_description);
        }

        private void bindItem(Post post){
            description.setText(post.getDescription());
        }
    }
}
