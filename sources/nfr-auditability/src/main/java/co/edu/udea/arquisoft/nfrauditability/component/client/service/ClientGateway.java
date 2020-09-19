package co.edu.udea.arquisoft.nfrauditability.component.client.service;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface ClientGateway {

    Client save(@NotNull Client clientToCreate);

    Client findById(@NotNull UUID id);

    List<Client> findAll();

    void deleteById(@NotNull UUID id);

    Client update(@NotNull Client clientToUpdate);
}
