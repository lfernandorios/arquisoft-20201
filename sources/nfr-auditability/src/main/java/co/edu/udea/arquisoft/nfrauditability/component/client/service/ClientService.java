package co.edu.udea.arquisoft.nfrauditability.component.client.service;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.model.ClientSaveCmd;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface ClientService {

    Client create(@NotNull ClientSaveCmd clientToCreateCmd);

    Client findById(@NotNull UUID id);

    List<Client> findAll();

    void deleteById(@NotNull UUID id);

    Client update(@NotNull UUID id, @NotNull ClientSaveCmd clientToUpdateCmd);
}
