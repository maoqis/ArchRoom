package com.maoqis.test.room;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.maoqis.test.room.db.entity.Book;
import com.maoqis.test.room.viewmodel.BookListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private BookListViewModel bookListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookListViewModel = new BookListViewModel(this.getApplication());
        bookListViewModel.getMediatorLiveData().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> bookList) {
                Log.d(TAG, "onChanged: thread= "+Thread.currentThread().getName());
                Log.d(TAG, "onChanged() called with: bookList = [" + bookList + "]");
            }
        });
        LiveData<Book> bookLiveData = ((BasicApp) getApplication()).getRepository().loadBook(1);
        bookLiveData.observe(this, new Observer<Book>() {
            @Override
            public void onChanged(@Nullable Book book) {
                Log.d(TAG, "onChanged() called with: book = [" + book + "]");
            }
        });
    }
}
