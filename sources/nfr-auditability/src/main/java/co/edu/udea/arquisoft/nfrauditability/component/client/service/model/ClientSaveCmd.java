package co.edu.udea.arquisoft.nfrauditability.component.client.service.model;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class ClientSaveCmd {

    private String tipoDoc;

    private String documento;

    private String nombre;

    private String direccion;

    private String telefono;

    private String estado;

    public static Client toModel(@NotNull ClientSaveCmd clientToCreateCmd){
        return Client.builder()
                .tipoDoc(clientToCreateCmd.getTipoDoc())
                .documento(clientToCreateCmd.getDocumento())
                .nombre(clientToCreateCmd.getNombre())
                .direccion(clientToCreateCmd.getDireccion())
                .telefono(clientToCreateCmd.getTelefono())
                .estado(clientToCreateCmd.getEstado()).build();

    }


}
