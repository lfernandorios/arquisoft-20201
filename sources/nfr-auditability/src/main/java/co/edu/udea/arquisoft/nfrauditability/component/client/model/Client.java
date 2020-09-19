package co.edu.udea.arquisoft.nfrauditability.component.client.model;

import lombok.*;
import co.edu.udea.arquisoft.nfrauditability.component.shared.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public class Client extends Auditable<String> {

    @Id
    private UUID id;

    private String tipoDoc;

    private String documento;

    private String nombre;

    private String direccion;

    private String telefono;

    private String estado;

}
