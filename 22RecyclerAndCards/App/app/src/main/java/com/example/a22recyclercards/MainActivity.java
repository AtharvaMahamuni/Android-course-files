package com.example.a22recyclercards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem> exampleList;

    private Button buttonAdd, buttonDelete;
    private EditText editTextAdd, editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            generateFakeData();
            recyclerViewConfig();

            //find Button
            buttonAdd = findViewById(R.id.buttonadd);
            buttonDelete = findViewById(R.id.buttondelete);
            //find editText
            editTextAdd = findViewById(R.id.edittextadd);
            editTextDelete = findViewById(R.id.edittextdelete);


            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO:Make sure user is not allowed to submit empty form

                    int position = Integer.parseInt(editTextAdd.getText().toString());
                    addCard(position);
                }

            });

            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = Integer.parseInt(editTextDelete.getText().toString());
                    deleteCard(position);
                }
            });

    }

    public void recyclerViewConfig(){
        recyclerView = findViewById(R.id.recyclerView);
        //Performance
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void generateFakeData(){
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.node,"Clicked at Studio"));
        exampleList.add(new ExampleItem(R.drawable.oner,"Clicked at Italy"));
        exampleList.add(new ExampleItem(R.drawable.twor,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.threer,"Clicked at Greece"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"Clicked at Rome"));
        exampleList.add(new ExampleItem(R.drawable.fiver,"Clicked at India"));
        exampleList.add(new ExampleItem(R.drawable.sixr,"Clicked at Maharashtra"));

    }

    public void addCard(int position){
        exampleList.add(position,new ExampleItem(R.drawable.node,"new card added"));
        adapter.notifyItemInserted(position);
    }

    public void deleteCard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
