package application.afericoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/afericoes")
public class AfericaoController {
    @Autowired
    private AfericaoService afericaoService;

    @GetMapping
    public Iterable<AfericaoDTO> getAll() {
        return this.afericaoService.getAll();
    }

    @GetMapping("/{id}")
    public AfericaoDTO getById(@PathVariable long id) {
        return this.afericaoService.getById(id);
    }

    @PostMapping
    public AfericaoDTO insert(@RequestBody AfericaoInsertDTO body) {
        return this.afericaoService.insert(body);
    }

    @PutMapping("/{id}")
    public AfericaoDTO update(@PathVariable long id, @RequestBody AfericaoInsertDTO body) {
        return this.afericaoService.update(id, body);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        this.afericaoService.deleteById(id);
    }
}
