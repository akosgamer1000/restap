package com.example.restapi_people;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService {

    //get all users
    @GET("acttFJ/people")
    Call<List<People>> getAllPeople();

}
