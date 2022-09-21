package proyecto1.ProyectoDW.controller;

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

@RestController
@RequestMapping("/api/v1/editoriales")
public class EditorialController {
    @Autowired
    private EditorialRepository editorialRepository;

    @GetMapping
    public List<Editorial> getAllEditoriales() {
        return editorialRepository.findAll();
    }

    //crear el REST API de editorial para crear un post
    @PostMapping
    public Editorial createEditorial(@RequestBody Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    // creamos un get que busca editorial por id
    @GetMapping("{id}")
    public ResponseEntity<Editorial> getEditorialById(@PathVariable Integer id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Editorial not exist with id: " + id));
        return ResponseEntity.ok(editorial);
    }

    // el update de las editoriales recibiendo un id
    @PutMapping("{id}")
    public ResponseEntity<Editorial> updateEditorial(@PathVariable Integer id,@RequestBody Editorial editorialDetails) {
        Editorial updateEditorial = editorialRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Editorial not exist with id: "+ id));
        updateEditorial.setName(editorialDetails.getName());
        updateEditorial.setWeb_site(editorialDetails.getWeb_site());
        editorialRepository.save(updateEditorial);
        return ResponseEntity.ok(updateEditorial);
    }
    // el delete de una editorial por id
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEditorial (@PathVariable Integer id){
        Editorial editorial = editorialRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Editorial not exist with id: "+ id));
        editorialRepository.delete(editorial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
