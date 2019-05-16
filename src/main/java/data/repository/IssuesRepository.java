package data.repository;

import data.entity.Issues;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuesRepository extends CrudRepository<Issues, Long> {
    Issues findByNumber(String number);


}
