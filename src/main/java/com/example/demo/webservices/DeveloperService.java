package com.example.demo.webservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.DeveloperList;
import com.example.demo.entity.Developer;
import com.example.demo.repository.DeveloperRepository;


@Service
public class DeveloperService
{

  private static final Logger LOGGER = LoggerFactory.getLogger(DeveloperService.class);


  // Abstrahierung Layer für die DB Transaktionen
  @Autowired
  private DeveloperRepository developerRepository;


  @Autowired
  public DeveloperService(DeveloperRepository developerRepository)
  {
    System.out.println("-- DeveloperService - Verknüpfe zum entsprechenden Repository");
    this.developerRepository = developerRepository;

  }

  // ToDo: Schreibe eine Test der genau nur diesen String überprüft
  public String simpleDeveloperOutput()
  {
    return "Hi DeveloperService here";
  }

  public void AddDevelopers(String name)
  {
    System.out.println("Add Developers");
    developerRepository.save(new Developer(name));
  }

  // bekomme einen bestimmten Developer (Entity/Tabelle)
  public void RemoveDeveloperWithId(Long id)
  {
    Long developerId = 8L;

    System.out.println("Remove Developers");
    try
    {
      this.developerRepository.deleteById(developerId);
    }
    catch (Exception e)
    {
      LOGGER.error("-- RemoveDeveloperWithId - DeveloperService.java - keine Developer mit der ID " + developerId + " gefunden.");
    }
  }


  // - There should be a list of developers. Functionality to add or remove developers. A developer just has a name as the only attribute.
  public List<Developer> ListDevelopers(DeveloperRepository repository, String name)
  {
    System.out.println("List Developers");

    List<Developer> developers = new ArrayList<>();

    if (null == name)
    {
      Iterable<Developer> results = repository.findAll();
      results.forEach(developer -> {
        developers.add(developer);
      });
    }
    else
    {
      Developer developer = repository.findByName(name);
      if (null != developer)
      {
        developers.add(developer);
      }
    }
    return developers;
  }

  // liefert eine List von Developern
  public List<DeveloperList> getAllDeveloperList()
  {
    // findAll()-Methode ist in der Repository als Standard mit dabei (liefert Daten aus DB)
    Iterable<Developer> developers = this.developerRepository.findAll();
    Map<Long, DeveloperList> developerListMap = new HashMap<>();
    // Lambda-Funktion, iterieren durch alle "developers" in der DB und legen einen neuen Developer in der Liste an
    developers.forEach(mydeveloper -> {
      DeveloperList developerList = new DeveloperList();
      developerList.setId(mydeveloper.getId());

      developerList.setName(mydeveloper.getName());

      developerListMap.put(mydeveloper.getId(), developerList);
    });
    List<DeveloperList> developerLists = new ArrayList<>();
    for ( long developerId : developerListMap.keySet() )
    {
      developerLists.add(developerListMap.get(developerId));
    }
    return developerLists;
  }


}
