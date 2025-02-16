package SorokinCollection;

import java.util.*;

/**
 * Класс реализует сервис управления библиотекой
 * @author lostway
 * @since 16.02.2025
 */
public class LibraryService {
    Set<User> userList = new HashSet<>();
    Set<Book> bookList = new HashSet<>();
    Map<Long, Long> base = new HashMap<>();
    public LibraryService(List<User> user, List<Book> book) {
        this.userList.addAll(user);
        this.bookList.addAll(book);
    }

    /**
     * : Метод возвращает список всех книг
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }

    /**
     * Метод возвращает список доступных книг (не на руках у пользователей).
     */
    public Collection<Book> getAllAvailableBooks() {
        Set<Book> isAvailableBooks = new LinkedHashSet<>();
        for (Book book : bookList) {
            if (!base.containsKey(book.getBookId())) {
                isAvailableBooks.add(book);
            }
        }
        return isAvailableBooks;
    }

    /**
     * Метод возвращает список книг, взятых пользователем.
     * @param userId уникальное ID пользователя для поиска книги
     */
    public Collection<Book> getUserBooks(Long userId) {
        Set<Book> isTakenByUser = new LinkedHashSet<>();
        for (Map.Entry<Long, Long> entry : base.entrySet()) {
            if (entry.getValue().equals(userId)) {
                isTakenByUser.add(getBookById(entry.getKey()));
            }
        }
        return isTakenByUser;
    }

    /**
     * Пользователь берет книгу. Нужно проверить, доступна ли книга.
     * @param userId поиск уникального id пользователя
     * @param bookId поиск уникального id книги
     */
    public void takeBook(Long userId, Long bookId) {
        Book book = isBookInLibrary(bookId);
        User user = isUserExist(userId);

        if (base.containsKey(bookId)) {
            throw new IllegalArgumentException("Книга уже взята");
        }
        base.put(bookId, userId);
    }

    /**
     * Метод реализует возврат пользователем книги.
     * @param userId поиск уникального id пользователя
     * @param bookId поиск уникального id книги
     */
    public void returnBook(Long userId, Long bookId) {
        isBookInLibrary(bookId);
        isUserExist(userId);

        if (!base.containsKey(bookId) || !base.get(bookId).equals(userId)) {
            throw new IllegalArgumentException("Книга не была взята пользователем");
        }

        base.remove(bookId);
    }

    public Book getBookById(Long bookId) {
        for (Book book : bookList) {
            if (bookId.equals(book.getBookId())) {
                return book;
            }
        }
        return null;
    }

    public User isUserExist(Long userId) {
        for (User user : userList) {
            if (userId.equals(user.getUserId())) {
                return user;
            }
        }
        throw new NoSuchElementException("Пользователь не был найден!");
    }

    public Book isBookInLibrary(Long bookId) {
        for (Book book : bookList) {
            if (bookId.equals(book.getBookId())) {
                return book;
            }
        }
        throw new NoSuchElementException("Книга не была найдена!");
    }
}
