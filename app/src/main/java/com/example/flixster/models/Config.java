package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Config {

    //the base URL for loading images
    String imageBasedUrl;
    //the poster size to use when fetching images, part of the Url
    String posterSize;
    //the backdrop size to use when fetching images
    String backdropSize;

    public Config(JSONObject object) throws JSONException {
        JSONObject images = object.getJSONObject("images");
        //get the image based url
        imageBasedUrl = images.getString("secure_base_url");
        //get poster size
        JSONArray posterSizeOptions = images.getJSONArray("poster_sizes");
        //use the option at index 3 or w342 as a fallback
        posterSize = posterSizeOptions.optString(3, "w342");
        //parse the backdrop sizes and use the option at index 1 or w780 as a fallback
        JSONArray backdropSizeOptions = images.getJSONArray("backdrop_sizes");
        backdropSize = backdropSizeOptions.optString(1, "w780");


    }

    //helper method for creating urls
    public String getImageUrl(String size, String path){
        return String.format("%s%s%s",imageBasedUrl, size, path); //concatenate all 3
    }

    public String getImageBasedUrl() {
        return imageBasedUrl;
    }

    public String getPosterSize() {
        return posterSize;
    }

    public String getBackdropSize(){
        return backdropSize;
    }
}
