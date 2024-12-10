package com.example.restapi_people;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneEditText;
    private EditText ageEditText;
    private Button showFormButton;
    private Button modifyButton;
    private Button addButton;
    private Button cancelButton;
    private LinearLayout formLinearLayout;
    private ListView listView;
    private List<People> people;
    private PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        RetrofitApiService apiService = RetrofitClient.getInstance().create(RetrofitApiService.class);
        loadPeople(apiService);

        showFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    formLinearLayout.setVisibility(View.VISIBLE);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                formLinearLayout.setVisibility(View.GONE);
            }
        });
    }

    public void init() {
        addButton = findViewById(R.id.addButton);
        cancelButton = findViewById(R.id.cancelButton);
        modifyButton = findViewById(R.id.modifyButton);
        showFormButton = findViewById(R.id.showFormButton);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        ageEditText = findViewById(R.id.ageEditText);
        formLinearLayout = findViewById(R.id.formLinearLayout);
        listView = findViewById(R.id.listView);
        people = new ArrayList<>();
        adapter = new PeopleAdapter(people,MainActivity.this);
        listView.setAdapter(adapter);
    }

    public void loadPeople(RetrofitApiService apiService) {

        apiService.getAllPeople().enqueue(new Callback<List<People>>() {
            @Override
            public void onResponse(Call<List<People>> call, Response<List<People>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    people.clear();
                    people.addAll(response.body());
                    //változás történik a listával BÁRMILYEN
                    adapter.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "Sikeres adatlekérdezés",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<People>> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Nem sikerült betölteni a people listát", Toast.LENGTH_SHORT).show();
            }
        });
    }
}