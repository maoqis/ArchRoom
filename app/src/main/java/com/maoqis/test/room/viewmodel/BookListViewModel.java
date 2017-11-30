package com.maoqis.test.room.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.support.annotation.NonNull;

import com.maoqis.test.room.BasicApp;
import com.maoqis.test.room.db.entity.Book;

import java.util.List;

/**
 * Created by bjmaoqisheng on 2017/11/30.
 */

public class BookListViewModel extends AndroidViewModel {
    private final MediatorLiveData<List<Book>> mediatorLiveData;
    public BookListViewModel(@NonNull Application application) {
        super(application);
        mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.setValue(null);
        LiveData<List<Book>> listLiveData = ((BasicApp) application).getRepository().getObservableProducts();
        mediatorLiveData.addSource(listLiveData, mediatorLiveData::setValue);
    }

    public MediatorLiveData<List<Book>> getMediatorLiveData() {
        return mediatorLiveData;
    }
}
