package ro.mihai.newsreader.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import ro.mihai.newsreader.Common.ISO8601Parse;
import ro.mihai.newsreader.DetailArticle;
import ro.mihai.newsreader.Interface.ItemClickListener;
import ro.mihai.newsreader.Model.Article;
import ro.mihai.newsreader.R;

class ListNewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemClickListener itemClickListener;
    TextView article_title;
    RelativeTimeTextView article_time;
    CircleImageView article_image;

    public ListNewsViewHolder(View itemView) {
        super(itemView);
        article_image = itemView.findViewById(R.id.article_image);
        article_title = itemView.findViewById(R.id.article_title);
        article_time = itemView.findViewById(R.id.article_time);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.OnClick(view,getAdapterPosition(),false);

    }
}
public class ListNewsAdapter extends RecyclerView.Adapter<ListNewsViewHolder> {
    private List<Article> articleList;
    private Context context;

    public ListNewsAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_layout,parent,false);
        return new ListNewsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListNewsViewHolder holder, int position) {

        Picasso.get()
                .load(articleList.get(position).getUrlToImage())
                .into(holder.article_image);
        if(articleList.get(position).getTitle().length()> 65){
            holder.article_title.setText(articleList.get(position).getTitle().substring(0,65)+ "...");
        }else{
            holder.article_title.setText(articleList.get(position).getTitle());

            Date date = null;

//            try {
//                date = ISO8601Parse.parse(articleList.get(position).getPublishedAt());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            try {
//                holder.article_time.setReferenceTime(date.getTime());
//            }catch (Exception e){
//                e.printStackTrace();
//            }


            holder.setItemClickListener(new ItemClickListener() {
                @Override
                public void OnClick(View view, int position, boolean isLongClick) {
                    Intent detail = new Intent(context,DetailArticle.class);
                    detail.putExtra("webURL", articleList.get(position).getUrl());
                    context.startActivity(detail);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}
