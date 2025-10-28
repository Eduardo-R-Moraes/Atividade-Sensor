package application.afericoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AfericaoService {
    @Autowired
    private AfericaoRepository afericaoRepo;

    public Iterable<AfericaoDTO> getAll() {
        return this.afericaoRepo.findAll().stream().map(AfericaoDTO::new).toList();
    }

    public AfericaoDTO getById(long id) {
        Optional<Afericao> afericao = this.afericaoRepo.findById(id);

        if (afericao.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aferição não encontrada."
            );
        }

        return new AfericaoDTO(afericao.get());
    }

    public AfericaoDTO insert(AfericaoInsertDTO afericao) {
        return new AfericaoDTO(this.afericaoRepo.save(new Afericao(afericao)));
    }

    public AfericaoDTO update(long id, AfericaoInsertDTO afericaoInsert) {
        Optional<Afericao> afericao = this.afericaoRepo.findById(id);

        if (afericao.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aferição não encontrada."
            );
        }

        afericao.get().setIdSensor(afericaoInsert.idSensor());
        afericao.get().setUnidade(afericaoInsert.unidade());
        afericao.get().setValor(afericaoInsert.valor());

        return new AfericaoDTO(this.afericaoRepo.save(afericao.get()));
    }

    public void deleteById(long id) {
        Optional<Afericao> afericao = this.afericaoRepo.findById(id);

        if (afericao.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Aferição não encontrada."
            );
        }

        this.afericaoRepo.deleteById(id);
    }
}
