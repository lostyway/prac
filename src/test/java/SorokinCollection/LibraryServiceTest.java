package SorokinCollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryServiceTest {

    private LibraryService libraryService;
    private List<User> users;
    private List<Book> books;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        users.add(new User("Alice", 25, 1L));
        users.add(new User("Bob", 30, 2L));

        books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", 2001, 101L));
        books.add(new Book("Book2", "Author2", 2002, 102L));
        books.add(new Book("Book3", "Author3", 2003, 103L));

        libraryService = new LibraryService(users, books);
    }

    @Test
    public void testGetAllBooks() {
        List<Book> allBooks = libraryService.getAllBooks();
        assertEquals(3, allBooks.size());
        assertTrue(allBooks.contains(books.get(0)));
        assertTrue(allBooks.contains(books.get(1)));
        assertTrue(allBooks.contains(books.get(2)));
    }

    @Test
    public void testGetAllAvailableBooks() {
        Collection<Book> availableBooks = libraryService.getAllAvailableBooks();
        assertEquals(3, availableBooks.size());

        libraryService.takeBook(1L, 101L);
        availableBooks = libraryService.getAllAvailableBooks();
        assertEquals(2, availableBooks.size());
        assertFalse(availableBooks.contains(books.get(0)));
        assertTrue(availableBooks.contains(books.get(1)));
        assertTrue(availableBooks.contains(books.get(2)));
    }

    @Test
    public void testGetUserBooks() {
        Collection<Book> userBooks = libraryService.getUserBooks(1L);
        assertTrue(userBooks.isEmpty());

        libraryService.takeBook(1L, 101L);
        userBooks = libraryService.getUserBooks(1L);
        assertEquals(1, userBooks.size());
        assertTrue(userBooks.contains(books.get(0)));

        libraryService.takeBook(1L, 102L);
        userBooks = libraryService.getUserBooks(1L);
        assertEquals(2, userBooks.size());
        assertTrue(userBooks.contains(books.get(0)));
        assertTrue(userBooks.contains(books.get(1)));

        libraryService.returnBook(1L, 101L);
        userBooks = libraryService.getUserBooks(1L);
        assertEquals(1, userBooks.size());
        assertFalse(userBooks.contains(books.get(0)));
        assertTrue(userBooks.contains(books.get(1)));
    }

    @Test
    public void testTakeBook() {
        libraryService.takeBook(1L, 101L);
        Collection<Book> userBooks = libraryService.getUserBooks(1L);
        assertEquals(1, userBooks.size());
        assertTrue(userBooks.contains(books.get(0)));

        assertThrows(IllegalArgumentException.class, () -> libraryService.takeBook(2L, 101L)); // Книга уже взята
        assertThrows(NoSuchElementException.class, () -> libraryService.takeBook(1L, 999L)); // Книга не найдена
        assertThrows(NoSuchElementException.class, () -> libraryService.takeBook(999L, 102L)); // Пользователь не найден
    }

    @Test
    public void testReturnBook() {
        libraryService.takeBook(1L, 101L);
        Collection<Book> userBooks = libraryService.getUserBooks(1L);
        assertEquals(1, userBooks.size());
        assertTrue(userBooks.contains(books.get(0)));

        libraryService.returnBook(1L, 101L);
        userBooks = libraryService.getUserBooks(1L);
        assertTrue(userBooks.isEmpty());

        assertThrows(IllegalArgumentException.class, () -> libraryService.returnBook(1L, 101L)); // Книга не взята
        assertThrows(IllegalArgumentException.class, () -> libraryService.returnBook(2L, 101L)); // Книга не взята пользователем
        assertThrows(NoSuchElementException.class, () -> libraryService.returnBook(1L, 999L)); // Книга не найдена
        assertThrows(NoSuchElementException.class, () -> libraryService.returnBook(999L, 102L)); // Пользователь не найден
    }

    @Test
    public void testGetBookById() {
        assertNotNull(libraryService.getBookById(101L));
        assertNotNull(libraryService.getBookById(102L));
        assertNotNull(libraryService.getBookById(103L));
        assertNull(libraryService.getBookById(999L));
    }

    @Test
    public void testIsUserExist() {
        assertNotNull(libraryService.isUserExist(1L));
        assertNotNull(libraryService.isUserExist(2L));
        assertThrows(NoSuchElementException.class, () -> libraryService.isUserExist(999L));
    }

    @Test
    public void testIsBookInLibrary() {
        assertNotNull(libraryService.isBookInLibrary(101L));
        assertNotNull(libraryService.isBookInLibrary(102L));
        assertNotNull(libraryService.isBookInLibrary(103L));
        assertThrows(NoSuchElementException.class, () -> libraryService.isBookInLibrary(999L));
    }
}