package com.example.restapi_people;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class PeopleAdapter extends BaseAdapter {

    private List<People> people;
    private Context context;

    public PeopleAdapter(List<People> people, Context context) {
        this.people = people;
        this.context = context;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.people_list_items,
                viewGroup, false);

        TextView firstNameTextView = view.findViewById(R.id.firstNameTextView);
        TextView lastNameTextView = view.findViewById(R.id.lastNameTextView);
        TextView ageTextView = view.findViewById(R.id.ageTextView);
        TextView emailTextView = view.findViewById(R.id.emailTextView);
        Button deleteButton = view.findViewById(R.id.deleteButton);

        People person = people.get(i);

        firstNameTextView.setText(person.getFirstName());
        lastNameTextView.setText(person.getLastName());
        ageTextView.setText("(" + person.getAge() + ")");
        emailTextView.setText(person.getEmail());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Törlés");
                builder.setMessage("Biztosan törli a felhasználót?");
                builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //törlés folyamat

                    }
                });
                builder.setNegativeButton("Nem",null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
        return view;
    }
}
