package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Song;

import java.util.ArrayList;

import adapter.models.HorizontalModel;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.HorizontalRVViewHolder>{

    Context context;
    ArrayList<HorizontalModel>arrayList;
    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel>arrayList) {
        this.context=context;
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public HorizontalRecyclerViewAdapter.HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);
        return new HorizontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerViewAdapter.HorizontalRVViewHolder holder, int position) {
            final HorizontalModel horizontalModel = arrayList.get(position);
            holder.textViewTitle.setText(horizontalModel.getName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent numbersIntent = new Intent(v.getContext(), Song.class);
                    v.getContext().startActivity(numbersIntent);
                }
            });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        ImageView imageViewThumb;
        public HorizontalRVViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            imageViewThumb = (ImageView)itemView.findViewById(R.id.IVThumb);

        }
    }
}
