package com.example.inlupp3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.inlupp3.BookStore;

import org.junit.jupiter.api.Test;

class BookStoreTest {

	@Test
	void verifyFiftyBooksReturnsOneShelf() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(50);
		assertEquals(1, shelves);
	}

	@Test
	void verifyHundredBooksReturnsTwoShelves() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(100);
		assertEquals(2, shelves);
	}

	@Test
	void verifyLessThanFiftyReturnsOneShelf() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(49);
		assertEquals(1, shelves);
	}

	@Test
	void verifyZeroReturnsOneShelf() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(0);
		assertEquals(1, shelves);
	}

	@Test
	void verifyRoundsUp() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(153);
		assertEquals(4, shelves);
	}

	@Test
	void verifyRoundsUp2() {
		BookStore bookStore = new BookStore();
		int shelves = bookStore.calculateShelves(149);
		assertEquals(3, shelves);
	}
}
