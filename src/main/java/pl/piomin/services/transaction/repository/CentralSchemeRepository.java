package pl.piomin.services.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pl.piomin.services.transaction.model.Contract;

@Repository
public interface CentralSchemeRepository extends MongoRepository<Contract, String>
{

}
