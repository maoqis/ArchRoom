package com.maoqis.test.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.maoqis.test.room.db.AppDatabase;
import com.maoqis.test.room.db.entity.Book;
import com.maoqis.test.room.db.entity.User;

import java.util.List;

/**
 * Repository handling the work with products and comments.
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
    private MediatorLiveData<List<Book>> mObservableProducts;

    private DataRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableProducts = new MediatorLiveData<>();

        mObservableProducts.addSource(mDatabase.myDao().loadAllBooks(),
                productEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableProducts.postValue(productEntities);
                    }
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public MediatorLiveData<List<Book>> getObservableProducts() {
        return mObservableProducts;
    }

    public LiveData<Book> loadBook(final int id) {
        return mDatabase.myDao().loadBook(id);
    }

    public LiveData<User> loadComments(final int productId) {
        return mDatabase.myDao().loadUser(productId);
    }
}
