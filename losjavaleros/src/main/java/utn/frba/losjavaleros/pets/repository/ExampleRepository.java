package utn.frba.losjavaleros.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Object,Integer> { // Object = Entity

  //@Query("FROM StockSubsidiaryEntity s WHERE s.subsidiary.id = :idSubsidiary AND s.part.partCode = :partCode")
  //StockSubsidiaryEntity findStockByPartCodeAndSubsidiary(Integer partCode, Integer idSubsidiary);
}
