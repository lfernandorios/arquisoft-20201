package co.edu.udea.arquisoft.nfrauditability.component.client.io.web.v1;

import co.edu.udea.arquisoft.nfrauditability.component.client.io.web.v1.model.ClientSaveRequest;
import co.edu.udea.arquisoft.nfrauditability.component.client.io.web.v1.model.ClientSaveResponse;
import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.ClientService;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.model.ClientSaveCmd;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.UUID;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping(path = "/api/v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)

public class ClientController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = {HttpHeaders.LOCATION})
    public ResponseEntity <Void> create(@Valid @NotNull @RequestBody ClientSaveRequest clientToCreate) {
        logger.debug("Begin create: clientToCreate = {}", clientToCreate);

        ClientSaveCmd clientToCreateCmd = ClientSaveRequest.toModel(clientToCreate);

        Client clientCreated = clientService.create(clientToCreateCmd);

        URI location = fromUriString("/api/v1/clients").path("/{id}")
                .buildAndExpand(clientCreated.getId()).toUri();

        logger.debug("End create: clientCreated = {}", clientCreated);

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public  ResponseEntity<List <Client>> findAll(){
        return ResponseEntity.ok(clientService.findAll());
    }



    @GetMapping(path = "/{id}")
    public ResponseEntity<ClientSaveResponse> findById(@Valid @PathVariable("id") @NotNull UUID id) {
        logger.debug("Begin findById: id = {}", id);

        Client clientFound = clientService.findById(id);

        logger.debug("End findById: clientFound = {}", clientFound);

        return ResponseEntity.ok(ClientSaveResponse.fromModel(clientFound));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") @NotNull UUID id) {

        logger.debug("Begin delete: id = {}", id);

        clientService.deleteById(id);

        logger.debug("End delete: id = {}", id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ClientSaveResponse> update(@Valid @RequestBody @NotNull ClientSaveRequest clientToUpdate,
                                                   @Valid @PathVariable("id") @NotNull UUID id) {
        logger.debug("Begin update: clientToUpdate = {}, id = {}", clientToUpdate, id);

        ClientSaveCmd clientToUpdateCmd = ClientSaveRequest.toModel(clientToUpdate);

        Client clientUpdated = clientService.update(id, clientToUpdateCmd);

        logger.debug("End update: clientUpdated = {}", clientUpdated);

        return ResponseEntity.ok(ClientSaveResponse.fromModel(clientUpdated));
    }

}
