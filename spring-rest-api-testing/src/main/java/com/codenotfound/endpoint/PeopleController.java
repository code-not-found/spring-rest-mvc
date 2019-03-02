package com.codenotfound.endpoint;

import java.util.List;
import com.codenotfound.model.People;
import com.codenotfound.repository.PeopleRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * PeopleController
 */
@RestController
@RequestMapping(path = "/api")
public class PeopleController {

    private PeopleRepository repo;

    public PeopleController(PeopleRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/people")
    public List<People> findAll() {
        return repo.findAll();
    }

    @GetMapping("/people/{id}")
    public People findById(@PathVariable String id) {
        return repo.findById(id);
    }

    @PostMapping("/people")
    public People save(@RequestBody People people) {
        return repo.save(people);
    }

    @PutMapping(value = "/people/{id}")
    public People update(@PathVariable String id, @RequestBody People people) {
        return repo.update(id, people);
    }

    @DeleteMapping("/people/{id}")
    public void delete(@PathVariable String id) {
        repo.delete(id);
    }
}
