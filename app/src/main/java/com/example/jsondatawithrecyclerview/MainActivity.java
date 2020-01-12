package com.example.jsondatawithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

   private RecyclerView recyclerView;
   private ArrayList<DataList> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //ArrayList;
        arrayList = new ArrayList<DataList>();

        //Jsontask object call;
        Jsontask jsontask = new Jsontask();
        jsontask.execute();

    }

    //JSON Datafaceing;
    public class Jsontask extends AsyncTask<String, String, String>{

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer;
        String fullFile;
        //Json File name and author;
        String Author;
        String Name;

        @Override
        protected String doInBackground(String... strings) {

            try {
                URL url = new URL("https://api.myjson.com/bins/8nn96");
                //1. HttpURLConnection;
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                //2. Byet Code Conert;
                inputStream = httpURLConnection.getInputStream();

                //3. BufferReadder;
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                //4. StringBuffer;
                stringBuffer = new StringBuffer();
                String line = "" ;
                while ((line = bufferedReader.readLine()) != null)
                {
                    stringBuffer.append(line);
                }
                fullFile = stringBuffer.toString();

                //JsonObject;
                JSONObject jsonObject = new JSONObject(fullFile);
                JSONObject jsonobjectchild = jsonObject.getJSONObject("Book");

                for (Iterator key = jsonobjectchild.keys(); key.hasNext();)
                {

                    JSONObject books = (JSONObject) jsonobjectchild.get((String) key.next());
                    Author = books.getString("author");
                    Name = books.getString("name");
                    //ListAdd;
                    arrayList.add(new DataList(Author,Name));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

           DataAdapter dataAdapter = new DataAdapter(arrayList,getApplicationContext());
           recyclerView.setAdapter(dataAdapter);
        }
    }


}
