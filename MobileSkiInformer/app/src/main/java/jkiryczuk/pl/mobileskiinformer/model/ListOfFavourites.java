package jkiryczuk.pl.mobileskiinformer.model;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListOfFavourites {

    private static ListOfFavourites listInstance;
    private static Gson gson;
    private List<NearbyResort> resorts;
    private final static String filename =  Environment.getExternalStorageDirectory().toString()+"/favs.json";

    public static synchronized ListOfFavourites getInstance() {
        if (listInstance == null) {
            listInstance = new ListOfFavourites();
        }
        return listInstance;
    }

    public List<NearbyResort> getResorts() {
        return resorts;
    }

    public void setResorts(List<NearbyResort> resorts) {
        this.resorts = resorts;
    }

    private ListOfFavourites() {
        this.resorts = new ArrayList<>();
        this.gson = new Gson();
    }


    public void serialize(List<NearbyResort> resorts) {
        Writer writer = null;
        try {
            writer = new FileWriter(filename);
        } catch (IOException e) {

            Log.e("Przy serialu",e.getMessage());
            return;
        }
        String xd = gson.toJson(this.resorts);
        gson.toJson(this.resorts, writer);
        try {
            writer.flush(); //flush data to file   <---
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close(); //close write
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void deserialize() {
        Type resorstsType = new TypeToken<List<NearbyResort>>() {
        }.getType();
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            Log.e("Przy deserialu",e.getMessage());
            this.resorts = new ArrayList<>();
            return;
        }
        this.resorts = gson.fromJson(reader, resorstsType);

    }
}
