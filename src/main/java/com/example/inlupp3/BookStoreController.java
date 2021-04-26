package com.example.inlupp3;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class BookStoreController {

    @Autowired
    private BookStoreRepository bookStoreRepository;

    @GetMapping(path = "/bookstore")
    @CrossOrigin
    List<BookStore> getAll() {
        List<BookStore> bookstores = new ArrayList<>();
        for (BookStore p : bookStoreRepository.findAll()) {
            bookstores.add(p);
        }
        return bookstores;
    }

    
    @GetMapping(path = "/bookstore/{id}")
    @CrossOrigin
    Optional<BookStore> getBookstoreById(@PathVariable Integer id) {
        return bookStoreRepository.findById(id);
    }

    @PutMapping(path = "/bookstore/{id}", consumes="application/json", produces="application/json")
    @CrossOrigin
        BookStore updateBookStore(@PathVariable Integer id, @RequestBody BookStore bookStoreToUpdate){
            BookStore savedBookStore = bookStoreRepository.findById(id).get();
            int nrOfBooks = bookStoreToUpdate.getNrOfBooks();
            int shelves = bookStoreToUpdate.calculateShelves(nrOfBooks);         
            savedBookStore.setName(bookStoreToUpdate.getName());
            savedBookStore.setAddress(bookStoreToUpdate.getAddress());
            savedBookStore.setNrOfBooks(bookStoreToUpdate.getNrOfBooks());
            savedBookStore.setShelves(shelves);
            bookStoreRepository.save(savedBookStore);
            return savedBookStore;
    }

    @PostMapping(path = "/bookstore", consumes="application/json", produces="application/json")
        ResponseEntity<BookStore> createBookStore(@RequestBody BookStore bookstoreToCreate){
            int nrOfBooks = bookstoreToCreate.getNrOfBooks();
            int shelves = bookstoreToCreate.calculateShelves(nrOfBooks);
            bookstoreToCreate.setShelves(shelves);
            bookStoreRepository.save(bookstoreToCreate);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{Id}")
                .buildAndExpand(bookstoreToCreate.getId())
                .toUri();
            return ResponseEntity.created(location).build();    

    }

    @DeleteMapping(path = "/bookstore/{id}")
    void deleteBookstore(@PathVariable Integer id){
        bookStoreRepository.deleteById(id);
}

    
}