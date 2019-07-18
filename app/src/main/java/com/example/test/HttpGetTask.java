package com.example.test;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HttpGetTask extends AsyncTask<String, Long, String> {
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            String data = "";
            while (scanner.hasNext()) {
                data = data + scanner.nextLine();
            }
            return data;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
//        Log.d("aaa", "onPostExecute: "+ s);

        List<Post> postList = new ArrayList<>();
//        try {
//            JSONArray root = new JSONArray(s);
//            for (int i = 0; i < root.length(); i++) {
//
//                Log.e("index", String.valueOf(i));
//                JSONObject post = root.getJSONObject(i);
//                int id = post.getInt("id");
//                Log.e("id", String.valueOf(id));
//                String date = post.getString("date");
//                Log.e("date", date);
//                JSONObject title = root.getJSONObject(i);
//                String rendered = title.getString("rendered");
//                Log.e("rendered", rendered);
//
//                Post postmodel = new Post();
//                postmodel.id = id;
//                postmodel.date = date;
//                postmodel.title = rendered;
//                postList.add(postmodel);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

//        JsonParser jsonParser = new JsonParser();
//        JsonArray root = jsonParser.parse(s).getAsJsonArray();
//
//        for ( int i = 0; i < root.size(); i++){
//            JsonObject post = root.get(i).getAsJsonObject();
//            int id = post.get("id").getAsInt();
//            String date = post.get("date").getAsString();
//            JsonObject title = post.get("title").getAsJsonObject();
//            String rendered = title.get("rendered").getAsString();
//            Post postmodel = new Post();
//            postmodel.id = id;
//            postmodel.date = date;
//            postmodel.title = rendered;
//            postList.add(postmodel);
//        }

        Gson gson = new Gson();
        postList = gson.fromJson(s, new TypeToken<List<Post>>(){}.getType());

    }
}
