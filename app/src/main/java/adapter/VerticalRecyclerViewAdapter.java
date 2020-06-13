package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

import adapter.models.HorizontalModel;
import adapter.models.VerticalModel;

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.VerticalRVViewHolder> {

    Context context;
    ArrayList<VerticalModel>arrayList;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<VerticalModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public VerticalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vertical,parent,false);
        return new VerticalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalRVViewHolder holder, int position) {
        final VerticalModel verticalModel = arrayList.get(position);
        String title = verticalModel.getTitle();
        ArrayList<HorizontalModel> singleItem = verticalModel.getArrayList();
        //System.out.println(singleItem.size());
        holder.textViewTitle.setText(title);
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter =new HorizontalRecyclerViewAdapter(context,singleItem);
        holder.recyclerView.setHasFixedSize(true);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.recyclerView.setAdapter(horizontalRecyclerViewAdapter);
        holder.BtnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,verticalModel.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class VerticalRVViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        RecyclerView recyclerView;
        Button BtnMore;
        public VerticalRVViewHolder(@NonNull View itemView) {
            super(itemView);
             recyclerView= (RecyclerView)itemView.findViewById(R.id.recyclerview1);
            textViewTitle = (TextView)itemView.findViewById(R.id.txt);
            BtnMore = (Button)itemView.findViewById(R.id.Btnmore);
        }
    }
}
