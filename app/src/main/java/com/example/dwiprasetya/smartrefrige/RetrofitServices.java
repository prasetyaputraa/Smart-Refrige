package com.example.dwiprasetya.smartrefrige;

import com.example.dwiprasetya.smartrefrige.Model.Item;
import com.example.dwiprasetya.smartrefrige.Model.Transactions;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitServices {

//    @Headers({
//            "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImJjNDA5N2Q0ZDFkYzVkNzI0M2JjYjVmOTVjZWRiMTUwNTgxZjBmNTBjNDJlNWRhYjAwMTA0MzE0ZTcyZDJmMTc3MWVmZTk0Njk2MDVjMjcwIn0.eyJhdWQiOiIxIiwianRpIjoiYmM0MDk3ZDRkMWRjNWQ3MjQzYmNiNWY5NWNlZGIxNTA1ODFmMGY1MGM0MmU1ZGFiMDAxMDQzMTRlNzJkMmYxNzcxZWZlOTQ2OTYwNWMyNzAiLCJpYXQiOjE1NTg2OTE4NDIsIm5iZiI6MTU1ODY5MTg0MiwiZXhwIjoxNTkwMzE0MjQyLCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.W8l9cejfScVBCXJGZ2QeSxeE4kSCIBum1t41eil4iNNCckaVo5Ru9xa7Uz6IGDfsPEJyjc2RJo09u5VJVL9UXjF0KS_BxipqkipGqQAv2DCRrLWiSG92GNj05EQ-akYlz-8yqDbH5ngfA2eji85igToTPC2ujxnz3cZCLMkgV8pzjImDyG0RnPHFQAwUxKgwPghqzjTNMNlCH3r1naNoD5Wq2F9NothOobUrCfsdXLyxrUVLMkCEyaNwNV4-JUKntOpaGjKhGjLr41kL-40eb1JH4dY7w0BSC9F-LC4E8dlWfcIT5ybX4NwVEsj2EtKIbkC8aQBwTB4Plqm4uAkBfPcMWzTGmiGvJUAua-7RgQEwoQCSDttW4puoOkrpqhIvUbKLNls6vQBO1kB-f-MFxo-dm1mXY7aR-UloR8KFh9U5ZJncD7X6RuWlcupYgTyE_LkVv4u0zJXeU4bCp7tgXNJiRx7r1Q5uOdglf2MFYP40n1yPRE5ltaTvX3slcyU51x3ULQX1LojXrJwCTUEemQoFlNmgQF_otfdc6X0p6H7TYMtHu9zVeoXIgm-q8q2gHVKn4GI5V7uW5itIWR0rgOzkpWKJK1dsvgI1-bMGtieWo6prGefQcmKhlrvidLmGmd0dPbtziF0ZIWp_u0q4Kvlt4Lx6RUZVzRT9XYPhGPc",
//            "Content-Type: application/json"
//    })

    @FormUrlEncoded
    @POST("user/log")
    Call<List<Transactions>> loadTransactions(@Header("Authorization") String token, @Field("email") String email, @Field("password") String password, @Field("log") int logType);
}
