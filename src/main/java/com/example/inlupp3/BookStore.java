package com.example.inlupp3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represents a book store
 * 
 */
@Entity
class BookStore{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    private String address;
    private int nrOfBooks;
    private int shelves;

    public BookStore(){}

    public BookStore(String name, String address, int nrOfBooks){
        this.name = name;
        this.address = address;
        this.nrOfBooks = nrOfBooks;
        this.shelves = calculateShelves(nrOfBooks);
    }

    /**
     * Calculate how many bookshelves are needed.
     * 
     * One Shelf fits 50 books.
     * @param nrOfBooks the number of books
     * @return number of bookshelves needed
     */
    public int calculateShelves(int nrOfBooks){
        int shelves = 0;

        if(nrOfBooks <=50){
            shelves = 1;
        }
        else{
            double result = nrOfBooks/50.0;
            shelves = (int)Math.ceil(result);
        }
        return shelves;

    } 

    public Integer getId() {
        return id;
    }

    public String getAddress() {
       return address;
    }

    public String getName() {
       return name;
    }

    public int getNrOfBooks() {
      return nrOfBooks;
    }

    public int getShelves() {
        return shelves;
    }

   public void setId(Integer id) {
       this.id = id;
   }

   public void setAddress(String address) {
       this.address = address;
   }

   public void setName(String name) {
       this.name = name;
   }

   public void setNrOfBooks(int nrOfBooks) {
       this.nrOfBooks = nrOfBooks;
   }

   public void setShelves(int shelves) {
    this.shelves = shelves;
}

   

}