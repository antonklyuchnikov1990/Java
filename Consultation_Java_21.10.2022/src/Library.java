import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Oruel", "1984", 2021));
        books.add(new Book("Charles Dickens", "A Tale of Two Cities", 1859));
        books.add(new Book("Antoine de Saint-Exupéry", "The Little Prince", 1943));
        books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
        books.add(new Book("Agatha Christie", "And Then There Were None", 1939));
        Book book6 = new Book("Agatha Christie", "qwerty", 1939);
        books.add(book6);
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Ivanov Ivan Ivanovich", "ivanov.email@test.ru", true));
        readers.add(new Reader("Michailov Michail Michailovich", "michailov.email@test.ru", true));
        readers.add(new Reader("Antonov Anton Antonovich", "antonov.email@test.ru", true));
        readers.add(new Reader("Dmitrievsky Dmitry Dmitrievich", "dmitrievsky.email@test.ru", true));
        readers.add(new Reader("Petrov Petr Petrovich", "petrovich.email@test.ru", true));
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(1));
        readers.get(0).getBooks().add(books.get(2));
        readers.get(1).getBooks().add(books.get(3));
        readers.get(1).getBooks().add(books.get(4));
        readers.get(1).getBooks().add(books.get(5));
        readers.get(2).getBooks().add(book6);

        //и так далее для других читателей и взятых книг
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBook(String bookName) {
       return books.stream()
                .filter(b -> b.getName().equals(bookName))
                .findFirst()
                .orElseThrow();
    }

    // Длинный вариант:
//    public Book getBook(String bookName) {
//        Optional<Book> bookOpt = books.stream()
//                .filter(b -> b.getName().equals(bookName))
//                .findFirst();
//        if (bookOpt.isPresent()) {
//            return bookOpt.get();
//        } else {
//            return null;
//        }
//    }

    public List<Reader> getReaders() {
        return readers;
    }
}
