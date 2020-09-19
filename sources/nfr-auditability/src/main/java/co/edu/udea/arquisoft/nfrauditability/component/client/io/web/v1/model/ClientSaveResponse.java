package co.edu.udea.arquisoft.nfrauditability.component.client.io.web.v1.model;

import co.edu.udea.arquisoft.nfrauditability.component.client.model.Client;
import co.edu.udea.arquisoft.nfrauditability.component.client.service.model.ClientSaveCmd;
import lombok.*;

import java.util.UUID;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSaveResponse {

    private UUID id;

    private String tipoDoc;

    private String documento;

    private String nombre;

    private String direccion;

    private String telefono;

    private String estado;

    public static ClientSaveResponse fromModel(Client client) {
        return ClientSaveResponse.builder()
                .id(client.getId())
                .tipoDoc(client.getTipoDoc())
                .documento(client.getDocumento())
                .direccion(client.getDireccion())
                .telefono(client.getTelefono())
                .estado(client.getEstado()).build();
    }

}
