package com.db.grad.javaapi.model;

import javax.persistence.*;

@Entity
@Table(name = "bookuser")
@IdClass(BookUserId.class)
public class BookUser {
    @Id
    private int bookuser_id;

    private int book_id;

<<<<<<< HEAD
    @Id
=======
<<<<<<< HEAD
=======
    @EmbeddedId
>>>>>>> 57975b44f9fbc0a0521dcc7e9a6f1d4dcad4aa54
>>>>>>> b59bc039bb464a8fefac917ffefd87fab0ed16ef
    private int user_id;

    public BookUser() {
    }

    public BookUser(int book_id, int user_id) {
        this.book_id = book_id;
        this.user_id = user_id;
    }

    @Column(name = "bookuser_id", nullable = false)
    public int getBookuser_id() {
        return bookuser_id;
    }

    public void setBookuser_id(int bookuser_id) {
        this.bookuser_id = bookuser_id;
    }

    @Column(name = "book_id", nullable = false)
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    @Column(name = "user_id", nullable = false)
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
