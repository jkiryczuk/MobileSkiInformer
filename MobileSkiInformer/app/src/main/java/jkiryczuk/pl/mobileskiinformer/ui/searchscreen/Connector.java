package jkiryczuk.pl.mobileskiinformer.ui.searchscreen;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;

public interface Connector {


    public void callbackFetchData(List<NearbyResort> date);
}
