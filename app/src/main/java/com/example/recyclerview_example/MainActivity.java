package com.example.recyclerview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recView;
    private RecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = findViewById(R.id.rec_view);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Leonardo DiCaprio", "dicaprio@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Leonardo_DiCaprio_2014.jpg/220px-Leonardo_DiCaprio_2014.jpg"));
        contacts.add(new Contact("Tom Hanks", "tomhanks@gmail.com", "https://www.ilmeteo.it/portale/files/giornale/tom-hanks-080720.jpg"));
        contacts.add(new Contact("Robert De Niro", "deniro@gmail.com", "https://gdsit.cdn-immedia.net/2019/11/ROBERT-DE-NIRO.jpg"));
        contacts.add(new Contact("Brad Pitt", "brad.pitt@gmail.com", "https://www.amica.it/wp-content/uploads/2020/05/brad-1.jpg?v=980901"));
        contacts.add(new Contact("Jhonny Depp", "jhonny@gmail.com", "https://www.youmovies.it/wp-content/uploads/2021/03/GettyImages-684952386-2.jpg"));

        adapter = new RecViewAdapter(this);
        adapter.setContacts(contacts);

        recView.setAdapter(adapter);
        recView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void changeContacts(View view) {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Name changed", "Email changed", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Leonardo_DiCaprio_2014.jpg/220px-Leonardo_DiCaprio_2014.jpg"));
        contacts.add(new Contact("Name changed", "Email changed", "https://www.ilmeteo.it/portale/files/giornale/tom-hanks-080720.jpg"));
        contacts.add(new Contact("Name changed", "Email changed", "https://gdsit.cdn-immedia.net/2019/11/ROBERT-DE-NIRO.jpg"));
        contacts.add(new Contact("Name changed", "Email changed", "https://www.amica.it/wp-content/uploads/2020/05/brad-1.jpg?v=980901"));
        contacts.add(new Contact("Name changed", "Email changed", "https://www.youmovies.it/wp-content/uploads/2021/03/GettyImages-684952386-2.jpg"));

        adapter.setContacts(contacts);
    }
}