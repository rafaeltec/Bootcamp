package com.project.bootcamp.controler;
import com.project.bootcamp.model.Stock;
import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.xml.ws.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin                                                                                                               /**importante para o front end, quando o navegador chamar, senao da erro, colocando o bakend libera o acesso de origens distintas */
@RestController
@RequestMapping(value = "/stock")

public class StockController {

    @Autowired
    private StockService service;


                                                                                                                        /** criando end point com base no dto */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)              /**construindo um json POST */
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(service.save(dto));                                                                    /** pega uma resposta html 200 e retorna os atributos do dto na rela html*/

    }

    @PutMapping()
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {                                           /** sso aqui é um UPDATE*/
        return ResponseEntity.ok(service.update(dto));

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll() {                                                                    /** vai retornar uma lista pegando todos GET*/

        return ResponseEntity.ok(service.findALL());

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)                                           /**faz um select na database e caso nao ache dados retorna erro vida msg configurada */
    public ResponseEntity<StockDTO> findByid  (@PathVariable Long id) {
            return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){
        return ResponseEntity.ok(service.findByToday());

    }



    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }



}
