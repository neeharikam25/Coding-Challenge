package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SecurityHandlerTest {
    @Mock
    private SecurityRepository seRepo;

    @InjectMocks
    private SecurityHandler handler;

    @Ignore
    @Test
    public void update_security_and_return_id () {
        // arrange
        Security theSecurity = new Security();
        theSecurity.setIssuerName("Amazon");
        handler.addSecurity(theSecurity);

        theSecurity = new Security();
        theSecurity.setIssuerName("LuftHansa");
        Mockito.when(seRepo.save(theSecurity)).thenReturn(theSecurity);
        Security expectedSecurity = handler.addSecurity(theSecurity);
        Security securityToUpdate = theSecurity;

        theSecurity = new Security();
        theSecurity.setIssuerName("Netflix");
        handler.addSecurity(theSecurity);
        Mockito.when(seRepo.save(securityToUpdate)).thenReturn(securityToUpdate);

        // act
        securityToUpdate.setIssuerName("HBO");
        Security actualSecurity = handler.updateSecurityDetails(securityToUpdate);

        // assert
        assertEquals( expectedSecurity, actualSecurity);
    }
}
