
package com.db.grad.javaapi.service;

        import com.db.grad.javaapi.model.CounterParty;
        import com.db.grad.javaapi.repository.CounterPartyRepository;
        import org.junit.Ignore;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.junit.jupiter.MockitoExtension;

        import java.util.ArrayList;
        import java.util.NoSuchElementException;
        import java.util.Optional;

        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CounterPartyHandlerTest
{
    @Mock
    private CounterPartyRepository itsCounterPartysRepo;

    @InjectMocks
    private CounterPartyHandler cut;

    @Test
    public  void    add_a_CounterParty_return_number_of_CounterPartys_in_repo_is_one()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        Mockito.when(itsCounterPartysRepo.save(theCounterParty)).thenReturn(theCounterParty);
        Mockito.when(itsCounterPartysRepo.count()).thenReturn(1L);
        cut.addCP( theCounterParty );

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfCPs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    add_several_CounterPartys_return_number_of_CounterPartys_match_number_added()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        Mockito.when(itsCounterPartysRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfCPs();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_CounterParty_and_remove_CounterParty_return_number_of_CounterPartys_is_zero()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        Mockito.when(itsCounterPartysRepo.save(theCounterParty)).thenReturn(theCounterParty);
        CounterParty uniqueCounterParty = cut.addCP( theCounterParty );

        Optional<CounterParty> opt = Optional.of(theCounterParty);
        Mockito.when(itsCounterPartysRepo.findById(theCounterParty.getCounterparty_id())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeCounterParty( uniqueCounterParty.getCounterparty_id() );
        long actualResult = cut.getNoOfCPs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsCounterPartysRepo, times(1)).delete(theCounterParty);
    }

    // This test covers the other logic path in cut.removeCounterParty()
    @Ignore
    @Test
    public  void    add_CounterParty_and_remove_CounterParty_that_doess_not_exist_return_number_of_CounterPartys_is_one()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        CounterParty uniqueCounterParty = cut.addCP( theCounterParty );

        long invalidId = 33;
        long expectedResult = 1;
        boolean expectedStatus = false;

        Optional<CounterParty> opt = Optional.empty();
        Mockito.when(itsCounterPartysRepo.findById(invalidId)).thenReturn(opt);

        Mockito.when(itsCounterPartysRepo.count()).thenReturn(1L);

        // act
        // There is no CounterParty with ID == 33
        boolean actualStatus = cut.removeCounterParty( invalidId );
        long actualResult = cut.getNoOfCPs();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsCounterPartysRepo, times(0)).delete(theCounterParty);
    }

    @Test
    public  void    find_CounterParty_by_valid_id_returns_one_CounterParty()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        Mockito.when(itsCounterPartysRepo.save(theCounterParty)).thenReturn(theCounterParty);
        CounterParty addedCounterParty = cut.addCP( theCounterParty );
        CounterParty expectedCounterParty = theCounterParty;
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );

        CounterParty jpaCounterParty = addedCounterParty;
        Optional<CounterParty> opt = Optional.of(addedCounterParty);
        Mockito.when(itsCounterPartysRepo.findById(addedCounterParty.getCounterparty_id())).thenReturn(opt);

        // act
        CounterParty actualResult = cut.getCPById( addedCounterParty.getCounterparty_id() );

        // assert
        assertEquals( expectedCounterParty.getCounterparty_id(), actualResult.getCounterparty_id() );
        assertEquals( expectedCounterParty.getName(), actualResult.getName() );
    }

    @Ignore
    @Test
    public  void    find_CounterParty_by_invalid_id_returns_null_CounterParty()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        long invalidId = 33;

        Optional<CounterParty> opt = Optional.empty();
        Mockito.when(itsCounterPartysRepo.findById(invalidId)).thenReturn(opt);

        // act
        assertThrows(NoSuchElementException.class, () -> {
            cut.getCPById( invalidId );
        });
    }

    @Test
    public  void    find_CounterParty_by_name_returns_one_CounterParty()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("FIrst");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        cut.addCP( theCounterParty );
        CounterParty expectedCounterParty = theCounterParty;
        String CounterPartyToFind = "Second";
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        ArrayList<CounterParty> expectedList = new ArrayList<>();
        expectedList.add(expectedCounterParty);
        Mockito.when(itsCounterPartysRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        CounterParty actualResult = cut.getCPByName( CounterPartyToFind );

        // assert
        assertEquals( expectedCounterParty.getCounterparty_id(), actualResult.getCounterparty_id() );
        assertEquals( expectedCounterParty.getName(), actualResult.getName() );
    }


    @Test
    public  void    find_CounterParty_by_name_returns_null_because_many_CounterPartys_with_same_name()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        CounterParty expectedCounterParty = theCounterParty;
        String CounterPartyToFind = "First";
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        ArrayList<CounterParty> expectedList = new ArrayList<>();
        Mockito.when(itsCounterPartysRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        CounterParty actualResult = cut.getCPByName( CounterPartyToFind );

        // assert
        assertNull( actualResult );
    }

    @Test
    public  void    find_CounterParty_by_invalid_name_returns_null_CounterParty()
    {
        // arrange
//        CounterPartyHandler cut = new CounterPartyHandler();
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        ArrayList<CounterParty> expectedList = new ArrayList<>();
        Mockito.when(itsCounterPartysRepo.findByName(Mockito.any())).thenReturn(expectedList);

        // act
        CounterParty actualResult = cut.getCPByName( "Fourth" );

        // assert
        assertNull( actualResult );
    }

    @Ignore
    @Test
    public  void    update_CounterParty_that_exists_returns_CounterParty_id()
    {
        // arrange
        CounterParty theCounterParty = new CounterParty();
        theCounterParty.setName("First");
        cut.addCP( theCounterParty );
        theCounterParty = new CounterParty();
        theCounterParty.setName("Second");
        Mockito.when(itsCounterPartysRepo.save(theCounterParty)).thenReturn(theCounterParty);
        CounterParty expectedCounterParty = cut.addCP( theCounterParty );
        CounterParty CounterPartyToUpdate = theCounterParty;
        String CounterPartyToFind = "Second";
        theCounterParty = new CounterParty();
        theCounterParty.setName("Third");
        cut.addCP( theCounterParty );
        Mockito.when(itsCounterPartysRepo.save(CounterPartyToUpdate)).thenReturn(CounterPartyToUpdate);

        // act
        CounterPartyToUpdate.setName("Fourth");
        CounterParty actualCounterParty = cut.updateCPDetails( CounterPartyToUpdate );

        // assert
        assertEquals( expectedCounterParty, actualCounterParty );
    }
}

