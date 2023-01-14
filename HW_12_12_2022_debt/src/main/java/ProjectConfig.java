import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
    public class ProjectConfig {

        @Bean("author")
        public Author author() {
            return new Author("John");
        }

        @Bean("reader")
        public Reader reader() {
            Reader reader = new Reader();
            reader.setName("Ann");
            reader.setBook(book());
            return reader;
        }

        @Bean("book")
        public Book book() {
            Book book = new Book();
            book.setAuthor(author());
            book.setTitle("qwerty");
            return book;
        }
}
