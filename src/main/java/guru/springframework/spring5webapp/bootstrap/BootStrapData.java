package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner  {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author carlos = new Author("Carlos", "Castaneda");
        Book orlovdar = new Book("Orlov Dar", "0123212");
        carlos.getBooks().add(orlovdar);
        orlovdar.getAuthors().add(carlos);

        authorRepository.save(carlos);
        bookRepository.save(orlovdar);

        Author nice = new Author("Fridrih", "Nice");
        Book zaraturstra = new Book("Tako je govorio Zaratustra", "6545646");
        carlos.getBooks().add(zaraturstra);
        orlovdar.getAuthors().add(nice);

        authorRepository.save(nice);
        bookRepository.save(zaraturstra);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());


    }
}
