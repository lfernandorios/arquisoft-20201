package co.edu.udea.arquisoft.nfrauditability.component.client.io.web.v1.model;


import co.edu.udea.arquisoft.nfrauditability.component.client.service.model.ClientSaveCmd;
import lombok.*;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientSaveRequest {

    private String tipoDoc;

    private String documento;

    private String nombre;

    private String direccion;

    private String telefono;

    public static ClientSaveCmd toModel(ClientSaveRequest clientToCreate){
        return ClientSaveCmd.builder()
                .tipoDoc(clientToCreate.getTipoDoc())
                .documento(clientToCreate.getDocumento())
                .nombre(clientToCreate.getNombre())
                .direccion(clientToCreate.getDireccion())
                .telefono(clientToCreate.getTelefono()).build();
    }
}
