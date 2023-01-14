import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
//        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);
        Book book = context.getBean("book", Book.class);
        Author author = context.getBean("author", Author.class);
        Reader reader = context.getBean("reader", Reader.class);
        System.out.println(book.getAuthor().getName());
        System.out.println(book.getTitle());
        System.out.println(reader.getName());
        System.out.println(reader.getBook().getTitle());
    }
}
