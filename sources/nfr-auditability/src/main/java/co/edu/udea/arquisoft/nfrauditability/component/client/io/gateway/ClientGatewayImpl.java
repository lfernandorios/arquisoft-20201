package co.edu.udea.arquisoft.nfrauditability.component.client.io.gateway;

import co.edu.udea.arquisoft.nfrauditability.component.client.io.repository.ClientRepository;
import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import co.edu.udea.arquisoft.nfrauditability.component.client.model.ClientStatus;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.ClientGateway;
import co.edu.udea.arquisoft.nfrauditability.component.shared.web.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;


@Repository
public class ClientGatewayImpl implements ClientGateway {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String RESOURCE_NOT_FOUND = "Client not found";

    private ClientRepository clientRepository;


    public ClientGatewayImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }

    @Override
    public Client save(@NotNull Client clientToCreate) {
        logger.debug("Begin save clientToCreate = {}", clientToCreate);

        final Client clientToBeCreated = clientToCreate.toBuilder()
                .id(UUID.randomUUID())
                .estado(String.valueOf(ClientStatus.UNDER_STUDY)).build();


        final Client clientCreated = clientRepository.save(clientToBeCreated);

        logger.debug("End save clientCreated = {}", clientCreated);

        return clientCreated;
    }

    @Override
    public Client findById(@NotNull UUID id) {
        logger.debug("Begin findById id = {}", id);

        Client clientFound = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(RESOURCE_NOT_FOUND));

        logger.debug("End findById clientFound = {}", clientFound);

        return clientFound;
    }

    @Override
    public List<Client> findAll() {
        List<Client> listClient = (List<Client>) clientRepository.findAll();
        return listClient;
    }

    @Override
    public void deleteById(@NotNull UUID id) {
        logger.debug("Begin deleteById id = {}", id);

        findById(id);
        clientRepository.deleteById(id);

        logger.debug("End deleteById");
    }

    @Override
    public Client update(@NotNull Client clientToUpdate) {
        logger.debug("Begin update clientToUpdate = {}", clientToUpdate);

        final Client clientToBeUpdated = clientToUpdate.toBuilder()
                .estado(String.valueOf(ClientStatus.APPROVED)).build();

        final Client clientUpdated = clientRepository.save(clientToBeUpdated);

        logger.debug("End update userUpdated = {}", clientUpdated);

        return clientUpdated;
    }

}
