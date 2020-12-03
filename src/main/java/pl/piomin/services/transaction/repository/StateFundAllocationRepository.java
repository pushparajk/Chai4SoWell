package pl.piomin.services.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pl.piomin.services.transaction.model.StateFundAllocation;

@Repository
public interface StateFundAllocationRepository extends MongoRepository<StateFundAllocation, String>
{

}
