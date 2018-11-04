package jkiryczuk.pl.mobileskiinformer.model;

import java.util.ArrayList;
import java.util.List;

public class ListOfFavourites {
    private static ListOfFavourites listInstance;

    private List<NearbyResort> resorts;
    public static synchronized ListOfFavourites getInstance() {
        if(listInstance == null){
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
    }
}
