package com.project.bootcamp.repository;


import com.project.bootcamp.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findByNameAndDate(String name, LocalDate date);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.name = :name AND stock.date = :date AND stock.id <> :id ")             /** name e data  igual porem o id tem que ser diferente*/
    Optional<Stock> findByStockUpdate(String name, LocalDate date, Long id);



    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.date = :date ")
    Optional<List<Stock>> findByToday(LocalDate date);
                                                                                                    /** o spring entende o find by name and date e faz um where no sql e */

                                                                                                 /** void save(Stock stock); */  /** esta linha eu adicionei usando a correção de errors do intelij, precisa verificar se tem esta implementação NAO ESQUECER */
}




