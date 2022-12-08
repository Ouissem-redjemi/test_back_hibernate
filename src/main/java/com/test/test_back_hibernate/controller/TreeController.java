package com.test.test_back_hibernate.controller;


import com.test.test_back_hibernate.repository.TreeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;
import java.util.Comparator;
import java.util.Map.Entry;

@RestController
@RequestMapping("/api/tree")
@CrossOrigin(origins = "http://localhost:3000")
public class TreeController {

    private final TreeRepository treeRepository;

    public TreeController(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    //Return the sorted list of "Arrondissement" with the number of Trees in it
    @GetMapping("/listArrondissement")
    private Map<String, Long> getListArrondissement(){
        List<String > listArrondissement= treeRepository.getAllArrondissement();
        List<Long> listNbTree = treeRepository.TreebyArrondissement();
        return getStringLongMap(listArrondissement, listNbTree);
    }

    //Return the list of "Genre" with the number of tree
    //TODO : ne doit pas etre triée.
    @GetMapping("/listArbreByGenre")
    private Map<String, Long> getListGenre(){
        List<String > listGenre= treeRepository.getGenre();
        List<Long> listNbtreebyGenre = treeRepository.countTreebyGenre();
        Map<String, Long> listgenreAndArbre = new HashMap<>();
        LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();
        ArrayList<Long> list = new ArrayList<>();
        for(int i =0 ; i< listGenre.size(); i++){
            listgenreAndArbre.put(listGenre.get(i), listNbtreebyGenre.get(i));
        }
        for (Map.Entry<String, Long> entry : listgenreAndArbre.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Comparator.reverseOrder());
        for (Long str : list) {
            for (Entry<String, Long> entry : listgenreAndArbre.entrySet()) {
                if (entry.getValue().equals(str)) {
                    sortedMap.put(entry.getKey(), str);
                }
            }
        }
        System.out.println(sortedMap);
        return sortedMap;
    }

    //function that Sort a map Values by keys
    private Map<String, Long> getStringLongMap(List<String> listGenre, List<Long> listNbtreebyGenre) {
        Map<String, Long> listgenreAndArbre = new HashMap<>();
        for(int i =0 ; i< listGenre.size(); i++){
            listgenreAndArbre.put(listGenre.get(i), listNbtreebyGenre.get(i));
        }
        return new TreeMap<>(listgenreAndArbre);
    }
}
