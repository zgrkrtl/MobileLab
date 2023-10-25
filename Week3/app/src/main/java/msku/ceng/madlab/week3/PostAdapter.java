package msku.ceng.madlab.week3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostAdapter extends BaseAdapter {

    List<Post> postList;
    LayoutInflater layoutInflater;

    public PostAdapter(Activity activity, List<Post> postList) { // constructor kurduktan sonra activitiyi girmemiz gerekiyo çünkü 2 tarafı da lamamız lazım
        this.postList = postList;
        layoutInflater = activity.getLayoutInflater(); // extacts object from xml
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;
        rowView = layoutInflater.inflate(R.layout.row, null );
        EditText txtMessage = rowView.findViewById(R.id.txtMessage);
        TextView txtLocation = rowView.findViewById(R.id.txtLocation);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        Post post = postList.get(position);
        txtMessage.setText(post.getMessage());
        txtLocation.setText(post.getLocation().getLatitude()+" "+ post.getLocation().getLongitude());

        imageView.setImageBitmap(post.getImage());


        return rowView;}
}