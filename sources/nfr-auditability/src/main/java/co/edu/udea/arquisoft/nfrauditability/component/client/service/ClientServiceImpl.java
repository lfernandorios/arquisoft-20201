package co.edu.udea.arquisoft.nfrauditability.component.client.service;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.model.ClientSaveCmd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ClientGateway clientGateway;


    public ClientServiceImpl(ClientGateway clientGateway){
        this.clientGateway = clientGateway;

    }

    @Override
    public Client create(@NotNull ClientSaveCmd clientToCreateCmd){
        logger.debug("Being create clientToCreateCmd = {}", clientToCreateCmd);

        Client clientToCreate = ClientSaveCmd.toModel(clientToCreateCmd);

        Client clientCreated = clientGateway.save(clientToCreate);

        logger.debug("End create clientCreated = {}", clientCreated);

        return clientCreated;
    }

    @Override
    @Transactional(readOnly = true)
    public Client findById(@NotNull UUID id){
        logger.debug("Being find by id = {}", id);

        Client clientFound = clientGateway.findById(id);

        logger.debug("End findById clientFound = {}", clientFound);

        return clientFound;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        List<Client> listClient =  clientGateway.findAll();
        return listClient;
    }

    @Override
    public void deleteById(@NotNull UUID id) {
        logger.debug("Begin deleteById id = {}", id);

        clientGateway.deleteById(id);

        logger.debug("End deleteById");
    }

    @Override
    public Client update(@NotNull UUID id, @NotNull ClientSaveCmd clientToUpdateCmd) {
        logger.debug("Begin update id = {}, clientToUpdateCmd = {}", id, clientToUpdateCmd);

        Client clientInDataBase = findById(id);

        Client clientToUpdate = clientInDataBase.toBuilder()
                .tipoDoc(clientToUpdateCmd.getTipoDoc())
                .documento(clientToUpdateCmd.getDocumento())
                .nombre(clientToUpdateCmd.getNombre())
                .direccion(clientToUpdateCmd.getDireccion())
                .telefono(clientToUpdateCmd.getTelefono())
                .estado(clientToUpdateCmd.getEstado())
                .build();

        Client clientUpdated = clientGateway.update(clientToUpdate);

        logger.debug("End update clientUpdated = {}", clientUpdated);

        return clientUpdated;
    }






}
