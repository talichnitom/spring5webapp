package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner  {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =  publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pesic = new Publisher("Pesic i sinovi", "Beogradska 5, Beograd, Srbija");
        publisherRepository.save(pesic);

        Author carlos = new Author("Carlos", "Castaneda");
        Book orlovdar = new Book("Orlov Dar", "0123212");

        carlos.getBooks().add(orlovdar);
        orlovdar.getAuthors().add(carlos);

        orlovdar.setPublisher(pesic);
        pesic.getBooks().add(orlovdar);

        authorRepository.save(carlos);
        bookRepository.save(orlovdar);
        publisherRepository.save(pesic);

        Author nice = new Author("Fridrih", "Nice");
        Book zaraturstra = new Book("Tako je govorio Zaratustra", "6545646");
        nice.getBooks().add(zaraturstra);
        zaraturstra.getAuthors().add(nice);

        zaraturstra.setPublisher(pesic);
        authorRepository.save(nice);
        bookRepository.save(zaraturstra);

        pesic.getBooks().add(zaraturstra);
        publisherRepository.save(pesic);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Number of publishers " + pesic.getBooks().size() );

    }
}
