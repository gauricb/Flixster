package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.List;
import java.util.ArrayList;

@Parcel
public class Movies {
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    Double voteAverage;
    public Movies() {}

    public Movies(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString( "poster_path");
        title = jsonObject.getString( "title");
        overview = jsonObject.getString( "overview");
        voteAverage = jsonObject.getDouble("vote_average");

    }

    public static List<Movies> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movies> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movies(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
    public String getOverview() {
        return overview;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }
}
