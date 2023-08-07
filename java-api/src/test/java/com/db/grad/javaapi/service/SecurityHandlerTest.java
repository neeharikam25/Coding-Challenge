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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SecurityHandlerTest {
    @Mock
    private SecurityRepository seRepo;

    @InjectMocks
    private SecurityHandler handler;

    @Ignore
    @Test
    public void add_a_security_return_number_of_security_in_repo_is_one()
    {
        // arrange
        Security theSecurity = new Security();
        theSecurity.setSecurityId(1);
        Mockito.when(seRepo.save(theSecurity)).thenReturn(theSecurity);
        Mockito.when(seRepo.count()).thenReturn(1L);
        handler.addSecurity(theSecurity);

        int expectedResult = 1;

        // act
        long actualResult = handler.getNoOfSecurity();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_several_security_return_number_of_security_match_number_added()
    {
        // arrange
        Security theSecurity = new Security();
        theSecurity.setSecurityId(1);
        handler.addSecurity(theSecurity);

        theSecurity = new Security();
        theSecurity.setSecurityId(2);
        handler.addSecurity(theSecurity);

        theSecurity = new Security();
        theSecurity.setSecurityId(3);
        handler.addSecurity(theSecurity);
        Mockito.when(seRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = handler.getNoOfSecurity();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public void add_security_and_remove_security_return_number_of_Trades_is_zero()
    {
        // arrange
        Security theSecurity = new Security();
        handler.addSecurity(theSecurity);
        Mockito.when(seRepo.save(theSecurity)).thenReturn(theSecurity);
        Security uniqueSecurity = handler.addSecurity(theSecurity);

        Optional<Security> opt = Optional.of(theSecurity);
        Mockito.when(seRepo.findById((long)theSecurity.getSecurityId())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = handler.removeSecurity(uniqueSecurity.getSecurityId());
        long actualResult = handler.getNoOfSecurity();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(seRepo, times(1)).delete(theSecurity);
    }

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

