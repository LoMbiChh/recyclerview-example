package com.example.recyclerview_example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private Context context;

    public RecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contactName.setText(contacts.get(position).getName());
        holder.contactMail.setText(contacts.get(position).getMail());

        Glide.with(context)
                .load(contacts.get(position).getImageUrl())
                .into(holder.contactImage);

        holder.contactCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contacts.get(position).getName() + " selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView contactCardView;
        private TextView contactName, contactMail;
        private ImageView contactImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contactCardView = itemView.findViewById(R.id.contact_card_view);
            contactName = itemView.findViewById(R.id.contact_name);
            contactMail = itemView.findViewById(R.id.contact_mail);
            contactImage = itemView.findViewById(R.id.contact_image);
        }
    }
}
