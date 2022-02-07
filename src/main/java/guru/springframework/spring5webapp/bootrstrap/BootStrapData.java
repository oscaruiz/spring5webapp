package guru.springframework.spring5webapp.bootrstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Author albert = new Author("Albert","Rivera");
        Book lpc = new Book("La politica centrada","88");
        albert.getBooks().add(lpc);
        lpc.getAuthors().add(albert);

        authorRepository.save(albert);
        bookRepository.save(lpc);

        Author juan = new Author("Juan","Palomo");
        Book yml = new Book("yo me lo guiso","66");
        juan.getBooks().add(yml);
        yml.getAuthors().add(juan);

        authorRepository.save(juan);
        bookRepository.save(yml);

        System.out.println("Starting");
        System.out.println("Number of Books: "+bookRepository.count());



    }
}
