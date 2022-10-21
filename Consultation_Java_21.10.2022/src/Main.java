import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();

        // Получить список всех книг библиотеки, отсортированных по году
        // издания.
        List<Book> list = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getIssueYear).thenComparing(Book::getName))
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println("String \"Hello\"");

        // Variant 1:
        List<EmailAddress> addresses = new ArrayList<>();
        library.getReaders().forEach(reader -> addresses.add(new EmailAddress(reader.getEmail())));
        System.out.println(addresses);
        System.out.println();

//         Variant 2:
//        List<EmailAddress> addressesWithLambda = library.getReaders().stream()
//                .map(Reader::getEmail)
//                .map(EmailAddress::new).toList();
//        System.out.println(addressesWithLambda);

        List<EmailAddress> addressesWithLambda2 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .filter(reader -> reader.getBooks().size() > 1)
                .map(Reader::getEmail)
                .map(EmailAddress::new).toList();
        System.out.println(addressesWithLambda2);

        List<Book> bookList = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(bookList);

        boolean match = library.getReaders().stream()
                .flatMap(reader -> reader.getBooks().stream())
                .anyMatch(book -> "Charles Dickens".equals(book.getAuthor()));
        System.out.println(match);

        int maxBookCount = library.getReaders().stream()
                .map(reader -> reader.getBooks().size())
                .max(Integer::compareTo).orElse(-1);
        System.out.println(maxBookCount);

        Map<String, List<EmailAddress>> map = new HashMap<>();
        for (Reader reader : library.getReaders()) {
            if (reader.isSubscriber()) {
                if (reader.getBooks().size() < 2) {
                    if (!map.containsKey("OK")) {
                        map.put("OK", new ArrayList<>());
                    }
                    map.get("OK").add(new EmailAddress(reader.getEmail()));
                } else {
                    if (!map.containsKey("TOO_MUCH")) {
                        map.put("TOO_MUCH", new ArrayList<>());
                    }
                    map.get("TOO_MUCH").add(new EmailAddress(reader.getEmail()));
                }
            }
        }

        Map<String, List<EmailAddress>> map2 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(reader -> reader.getBooks().size() < 2 ? "OK" : "TOO_MUCH",
                        Collectors.mapping(reader -> new EmailAddress(reader.getEmail()), Collectors.toList())));
        System.out.println("Map 1:");
        System.out.println(map);
        System.out.println("Map 2:");
        System.out.println(map2);

        Map<String, List<Reader>> map3 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(reader -> reader.getBooks().size() < 2 ? "OK" : "TOO_MUCH"));
        System.out.println(map3);

        Map<Boolean, List<Reader>> map4 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.partitioningBy(reader -> reader.getBooks().size() < 2));
        System.out.println(map4);

        System.out.println("Map 5:");
        Map<String, String> map5 = library.getReaders().stream()
                .filter(Reader::isSubscriber)
                .collect(Collectors.groupingBy(reader -> reader.getBooks().size() < 2 ? "OK" : "TOO_MUCH",
                        Collectors.mapping(Reader::getFio, Collectors.joining(", ", "(", ")"))));
        System.out.println(map5);
    }
}
