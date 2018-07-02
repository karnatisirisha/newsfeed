package example.com.newsfeedsample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Admin on 05-06-2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    private ArrayList<String> mBlogTitleList = new ArrayList<>();
    private ArrayList<String> mAuthorNameList = new ArrayList<>();
    private ArrayList<String> mBlogUploadDateList = new ArrayList<>();
    private ArrayList<String> mBlogImageList = new ArrayList<>();
    private Activity mActivity;
    private int lastPosition = -1;

    public DataAdapter(MainActivity activity, ArrayList<String> mBlogTitleList, ArrayList<String> mAuthorNameList, ArrayList<String> mBlogUploadDateList, ArrayList<String> mBlogImageList) {
        this.mActivity = activity;
        this.mBlogTitleList = mBlogTitleList;
        this.mAuthorNameList = mAuthorNameList;
        this.mBlogUploadDateList = mBlogUploadDateList;
        this.mBlogImageList=mBlogImageList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_blog_title, tv_blog_author, tv_blog_upload_date;
        private ImageView imgDis;

        public MyViewHolder(View view) {
            super(view);
            tv_blog_title = (TextView) view.findViewById(R.id.row_tv_blog_title);
            tv_blog_author = (TextView) view.findViewById(R.id.row_tv_blog_author);
            tv_blog_upload_date = (TextView) view.findViewById(R.id.row_tv_blog_upload_date);
            imgDis=(ImageView)view.findViewById(R.id.imgDis);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_data, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv_blog_title.setText(mAuthorNameList.get(position));
        holder.tv_blog_author.setText(mBlogTitleList.get(position));
        holder.tv_blog_upload_date.setText(mBlogUploadDateList.get(position));
        String str=mBlogImageList.get(position);
        try {
            InputStream input = new java.net.URL(str).openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            holder.imgDis.setImageBitmap(bitmap);

        }catch (IOException e){e.printStackTrace();}
        // Decode Bitmap

    }

    @Override
    public int getItemCount() {
        return mBlogTitleList.size();
    }
}