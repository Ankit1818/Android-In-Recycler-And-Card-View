package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        List<Model> rowListItem = getAllItemList();

        lLayout = new LinearLayoutManager(MainActivity.this);



        RecyclerView rView =findViewById(R.id.recycler);


        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }

    private List<Model> getAllItemList()
    {



        List<Model> allItems = new ArrayList<Model>();

        allItems.add(new Model("United States", R.mipmap.ic_launcher));
        allItems.add(new Model("Canada", R.mipmap.ic_launcher));
        allItems.add(new Model("United Kingdom", R.mipmap.ic_launcher));
        allItems.add(new Model("Germany",R.mipmap.ic_launcher));
        allItems.add(new Model("Sweden",R.mipmap.ic_launcher));

        return allItems;

    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView>
    {

            private List<Model> itemList;
            private Context context;



        public RecyclerViewAdapter(Context context, List<Model> itemList)
        {
            this.itemList = itemList;
            this.context = context;
        }




        @NonNull
        @Override
        public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, null);

            return new MyView(layoutView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyView holder, int position)
        {
                holder.countryName.setText(itemList.get(position).getName());
                holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }

        class MyView extends RecyclerView.ViewHolder
        {

            TextView countryName;
            ImageView countryPhoto;

            public MyView(@NonNull View itemView)
            {
                super(itemView);

                countryName = (TextView) itemView.findViewById(R.id.country_name);
                countryPhoto = (ImageView) itemView.findViewById(R.id.country_photo);

            }
        }
    }
}
