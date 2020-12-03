package pl.piomin.services.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pl.piomin.services.transaction.model.DonationModel;

@Repository
public interface DonationRepository extends MongoRepository<DonationModel, String>
{

}
