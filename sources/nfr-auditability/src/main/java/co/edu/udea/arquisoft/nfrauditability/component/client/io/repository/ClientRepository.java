package co.edu.udea.arquisoft.nfrauditability.component.client.io.repository;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository <Client, UUID> {

}
