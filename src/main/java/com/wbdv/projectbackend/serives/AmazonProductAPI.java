package com.wbdv.projectbackend.serives;

import com.wbdv.projectbackend.model.AmazonItem;
import com.wbdv.projectbackend.model.SearchResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class AmazonProductAPI {

    private AmazonProductAPI() {
    }

    private static AmazonProductAPI INSTANCE;

    public static AmazonProductAPI getInstance() {
        if (INSTANCE == null)
            INSTANCE = new AmazonProductAPI();
        return INSTANCE;
    }

    public List<SearchResponse> executeFulltextSearch(String searchText) throws IOException {
        //https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://www.omdbapi.com/?apikey=dbd814cb&t=" + searchText);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String object = rd.readLine();
        JSONObject obj = new JSONObject(object);
        String id = obj.getString("imdbID");
        String title = obj.getString("Title");
        String picture = obj.getString("Poster");
        return Arrays.asList(new SearchResponse[]{new SearchResponse(id, title, picture)});
    }

    public AmazonItem getItemDetail(String asin) throws IOException {
        //https://www.javacodegeeks.com/2012/09/simple-rest-client-in-java.html
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://www.omdbapi.com/?apikey=dbd814cb&i=" + asin);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String object = rd.readLine();
        JSONObject obj = new JSONObject(object);
        String id = obj.getString("imdbID");
        String title = obj.getString("Title");
        String picture = obj.getString("Poster");
        String manufacturer = obj.getString("Country");
        String auther = obj.getString("Director");
        return new AmazonItem(id, title, auther, manufacturer, "Movie", picture, picture);
    }

}
