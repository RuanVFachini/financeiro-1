package br.com.academiadev.financeiro.endpoint;

import br.com.academiadev.financeiro.model.LancamentoFinanceiro;
import br.com.academiadev.financeiro.model.Usuario;
import br.com.academiadev.financeiro.repository.LancamentoFinanceiroRepository;
import br.com.academiadev.financeiro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping
public class LancamentoEndpoint {
    @Autowired
    private LancamentoFinanceiroRepository lancamentoRepository;

    @PostMapping("/financeiro")
    public void save(@RequestBody LancamentoFinanceiro lancamentoFinanceiro) {
        lancamentoRepository.save(lancamentoFinanceiro);
    }

    @GetMapping("/financeiro")
    public List<LancamentoFinanceiro> buscarUsuarios() {
        return toList(lancamentoRepository.findAll());
    }

    public <E> List<E> toList(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }
}
