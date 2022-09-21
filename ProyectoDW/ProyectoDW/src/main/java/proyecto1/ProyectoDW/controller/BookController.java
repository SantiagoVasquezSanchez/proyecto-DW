package proyecto1.ProyectoDW.controller;

import org.apache.coyote.Response;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyecto1.ProyectoDW.model.Book;
import proyecto1.ProyectoDW.model.Editorial;
import proyecto1.ProyectoDW.repository.BookRepository;
import proyecto1.ProyectoDW.repository.EditorialRepository;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EditorialRepository editorialRepository;
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //crear el REST API de book para crear un post
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // creamos un get que busca libro por id
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book not exist with id: " + id));
        return ResponseEntity.ok(book);
    }

    // el update de los libros recibiendo un id
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Integer id,@RequestBody Book bookDetails) {
    Book updateBook = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book not exist with id: "+ id));
    updateBook.setName(bookDetails.getName());
    updateBook.setDescription(bookDetails.getDescription());
    updateBook.setImage_url(bookDetails.getImage_url());
    updateBook.setEditorial_id(bookDetails.getEditorial_id());
    bookRepository.save(updateBook);
    return ResponseEntity.ok(updateBook);
    }
    // el delete de un book por id
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBook (@PathVariable Integer id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book not exist with id: "+ id));
        bookRepository.delete(book);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value ="/editoriales/{id}")
    public ResponseEntity<Editorial> editorialByBook(@PathVariable Integer id){
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book not exist with id: "+ id));
        Editorial editorial = editorialRepository.findById(book.getEditorial_id()).orElseThrow(()-> new ResourceNotFoundException(("Editorial not exist with id "+book.getId())));
        return ResponseEntity.ok(editorial);
    }
}