package jkiryczuk.pl.mobileskiinformer.repository;

import android.arch.lifecycle.MutableLiveData;

import jkiryczuk.pl.mobileskiinformer.model.response.lists.BoroughsList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.CountiesList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.VoivodeshipsList;

public interface DataRepository {

    void getBorough(Long id, final MutableLiveData<Resource<BoroughResponse>> liveData);

    void getResorts(final MutableLiveData<Resource<ResortsList>> liveData);

    void getBoroughsInCounties(Long countyId,final MutableLiveData<Resource<BoroughsList>> liveData);

    void getVoivodeships(final MutableLiveData<Resource<VoivodeshipsList>> liveData);

    void getCountiesInVoivodeShip(Long voivodeshipId,final MutableLiveData<Resource<CountiesList>> liveData);
}
