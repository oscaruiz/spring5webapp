package guru.springframework.spring5webapp.bootrstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        
        System.out.println("Starting");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());
        Author albert = new Author("Albert","Rivera");
        Book lpc = new Book("La politica centrada","88");
        albert.getBooks().add(lpc);
        lpc.getAuthors().add(albert);


        lpc.setPublisher(publisher);
        publisher.getBooks().add(lpc);

        authorRepository.save(albert);
        bookRepository.save(lpc);
        publisherRepository.save(publisher);

        Author juan = new Author("Juan","Palomo");
        Book yml = new Book("yo me lo guiso","66");
        juan.getBooks().add(yml);
        yml.getAuthors().add(juan);

        yml.setPublisher(publisher);
        publisher.getBooks().add(yml);
        authorRepository.save(juan);
        bookRepository.save(yml);
        publisherRepository.save(publisher);


        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println("Publisher Number of Books: "+publisher.getBooks().size());


    }
}
