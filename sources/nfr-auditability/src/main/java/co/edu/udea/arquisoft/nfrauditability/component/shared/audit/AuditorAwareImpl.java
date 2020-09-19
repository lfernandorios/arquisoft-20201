package co.edu.udea.arquisoft.nfrauditability.component.shared.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of("Admin");
    }

}
