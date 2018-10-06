package jkiryczuk.pl.mobileskiinformer.repository;

import android.arch.lifecycle.MutableLiveData;

import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;

public interface DataRepository {

    void getBorough(Long id, final MutableLiveData<Resource<BoroughResponse>> liveData);
}
