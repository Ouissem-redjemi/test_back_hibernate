package com.test.test_back_hibernate.repository;

import com.test.test_back_hibernate.model.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface TreeRepository extends JpaRepository<Tree, Long> {

    //Arrondissement
    @Query("SELECT DISTINCT a.arrondissement FROM Tree as a ORDER BY a.arrondissement")
    List<String> getAllArrondissement();
    @Query(value = "Select count (*)  FROM Tree  as a GROUP BY a.arrondissement ORDER BY a.arrondissement")
    List<Long> TreebyArrondissement();

    //Genre
    @Query("SELECT distinct a.genre from Tree as a ORDER BY a.genre")
    List<String> getGenre();

    @Query("SELECT count (*) from Tree as a group by a.genre ORDER BY a.genre ")
    List<Long> countTreebyGenre();
}
