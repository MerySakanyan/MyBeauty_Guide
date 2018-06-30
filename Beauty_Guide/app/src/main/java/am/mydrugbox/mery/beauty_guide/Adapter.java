package am.mydrugbox.mery.beauty_guide;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter  extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    ArrayList<Name> arraylist;
    Context context;

    Adapter(ArrayList<Name> arraylist, Context context) {
        this.arraylist = arraylist;
        this.context=context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(arraylist.get(position).getName());
        holder.imageView.setBackgroundResource(arraylist.get(position).getImage());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context, Salon.class);
                intent.putExtra("name",arraylist.get(position).getName() );
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private  TextView textView;
        ImageView imageView;
        CardView cardView;
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
            cardView=itemView.findViewById(R.id.card);
            imageView=itemView.findViewById(R.id.imageview);
          //  imageView.setClipToOutline(true);
        }
    }

    public void setFilter (ArrayList<Name> newlist){
        arraylist=new ArrayList<>();
        arraylist.addAll(newlist);
        notifyDataSetChanged();
    }
}
