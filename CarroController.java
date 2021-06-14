package br.com.garagem.controller;

import br.com.garagem.model.Carro;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.garagem.repository.CarroRepository;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 22/04/2021
 * @brief class ProdutoController
 */
@Controller
public class CarroController {

    @Autowired
    private CarroRepository carroRepository;

    @GetMapping("/gerenciarCarro")
    public String listarProdutos(Model model) {
        model.addAttribute("listaCarro", carroRepository.findAll());
        return "gerenciar_carro";
    }

    @GetMapping("/novoCarro")
    public String novoProduto(Model model) {
        model.addAttribute("carro", new Carro());
        return "editar_carro";
    }

    @GetMapping("/editarCarro/{id}")
    public String editarCarro(@PathVariable("id") long idCarro, Model model) {
        Optional<Carro> carro = carroRepository.findById(idCarro);
        model.addAttribute("carro", carro.get());
        return "editar_carro";
    }

    @PostMapping("/salvarCarro")
    public String salvarCarro(@Valid Carro carro, BindingResult result) {
        if (result.hasErrors()) {
            return "editar_carro";
        }
        carroRepository.save(carro);
        return "redirect:/gerenciarCarro";
    }

    @GetMapping("/excluirCarro/{id}")
    public String excluirCarro(@PathVariable("id") long idCarro) {
        carroRepository.deleteById(idCarro);
        return "redirect:/gerenciarCarro";
    }
}
