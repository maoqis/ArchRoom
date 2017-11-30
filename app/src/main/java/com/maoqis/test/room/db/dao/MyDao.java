package com.maoqis.test.room.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import com.maoqis.test.room.db.entity.Book;
import com.maoqis.test.room.db.entity.User;
import com.maoqis.test.room.db.subset.NameTuple;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by bjmaoqisheng on 2017/11/29.
 */
@Dao
public interface MyDao {
    @Insert
    void insertUsers(User... users);

    @Insert
    void insertBothUsers(User user1, User user2);

    @Insert
    void insertUserList(List<User> userList);

    @Insert
    void insertUserAndFriends(User user, List<User> friendList);

    @Insert
    void insertBookList(List<Book> bookList);

    @Update
    void updateUsers(User... users);

    @Delete
    void deleteUsers(User... users);

    @Query("SELECT * FROM user")
    List<User> loadAllUsers();

    @Query("SELECT * FROM user WHERE age > :minAge")
    public User[] loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
            + "OR last_name LIKE :search")
    public List<User> findUserWithName(String search);

    /**
     * Returning subsets of columns
     * @return
     */
    @Query("SELECT first_name, last_name FROM user")
    public List<NameTuple> loadFullName();

    /**
     * Passing a collection of arguments
     * @param regions
     * @return
     */
    @Query("SELECT first_name, last_name FROM user WHERE city IN (:regions)")
    public List<NameTuple> loadUsersFromRegions(List<String> regions);

    /**
     * Reactive queries with RxJava
     * @param id
     * @return
     */
    @Query("SELECT * from user where id = :id LIMIT 1")
    public Flowable<User> loadUserById(int id);


    @Query("SELECT * from user where id = :id LIMIT 1")
    public LiveData<User> loadUser(int id);


    /**
     *
     * @param bookId
     * @return
     */
    @Query("SELECT * from book where book_id = :bookId LIMIT 1")
    public Flowable<Book> loadBookById(int bookId);

    @Query("SELECT * from book where book_id = :bookId LIMIT 1")
    public LiveData<Book> loadBook(int bookId);

    /**
     * Direct cursor access
     * @param minAge
     * @return
     */
    @Query("SELECT * from user where age > :minAge LIMIT 5")
    public Cursor loadRawUserOldThen(int minAge);

//    /**
//     * Querying multiple tables
//     * @param userName
//     * @return
//     */
//    @Query("SELECT * FROM book "
//            + "INNER JOIN loan ON loan.book_id = book.id "
//            + "INNER JOIN user ON user.id = loan.user_id "
//            + "WHERE user.name LIKE :userName")
//    public List<Book> findBooksBorrowedByNameSync(String userName);
//
//    @Query("SELECT user.name AS userName, pet.name AS petName "
//            + "FROM user, pet "
//            + "WHERE user.id = pet.user_id")
//    public LiveData<List<UserPet>> loadUserAndPetNames();


    @Query("SELECT * FROM book")
    LiveData<List<Book>> loadAllBooks();

}
