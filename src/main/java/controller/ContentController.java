package dev.bijansaudcontentcalender.contentcalender.controller;

// naming the class is the nameof the controller and put controller in the end
// Request mapping is the path to the controller with the path in the brackets
import dev.bijansaudcontentcalender.contentcalender.Repository.ContentCollectionRepository;
import dev.bijansaudcontentcalender.contentcalender.Repository.ContentRepository;
import dev.bijansaudcontentcalender.contentcalender.model.Content;
import dev.bijansaudcontentcalender.contentcalender.model.Status;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {


    private final ContentRepository repository;

    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("") // Empty path gives the path of the main class where the method is there
    public List<Content> findAll(){
        return repository.findAll();
    }

    //CRUD all are needed create, Reade, Update, Delete

    @GetMapping("/{id}")
    public Content findbyId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Notfound"));
    }

    // Creates a new content also the body should have response
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found");
        }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        repository.deleteById(id);
    }


    @GetMapping("/filter/{keyword}")
    public List<Content> findBytitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }

}

    // This is the written dependency injection using the new, so we are no longer responsible to make the new instance
    // of the class thus It is called dependency injection with the framework
    // the above code is the dependency injection; prefered

//    private ContentCollectionRepository repository;
//// Dependency Injection
//    // when new is written then you have to check, our application context makes the instance on the class in teh main application
//    // so when new is written then it will create another instance of the class
//    // so this should be avoided
//    public ContentController() {
//        repository = new ContentCollectionRepository();
//    }

