package com.db.grad.javaapi.service;



        import com.db.grad.javaapi.model.Trade;
        import com.db.grad.javaapi.repository.TradeRepository;
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
public class TradeHandlerTest
{
    @Mock
    private TradeRepository itsTradesRepo;

    @InjectMocks
    private TradeHandler cut;

    @Test
    public  void    add_a_trade_return_number_of_trades_in_repo_is_one()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Mockito.when(itsTradesRepo.count()).thenReturn(1L);
        cut.addTrade( theTrade );

        int expectedResult = 1;

        // act
        long actualResult = cut.getNoOfTrades();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Test
    public  void    add_several_Trades_return_number_of_Trades_match_number_added()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(2);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(3);
        cut.addTrade( theTrade );
        Mockito.when(itsTradesRepo.count()).thenReturn(3L);

        int expectedResult = 3;

        // act
        long actualResult = cut.getNoOfTrades();

        // assert
        assertEquals( expectedResult, actualResult );
    }

    @Ignore
    @Test
    public  void    add_Trade_and_remove_Trade_return_number_of_Trades_is_zero()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Trade uniqueTrade = cut.addTrade( theTrade );

        Optional<Trade> opt = Optional.of(theTrade);
        Mockito.when(itsTradesRepo.findById((long)theTrade.getTrade_id())).thenReturn(opt);

        long expectedResult = 0;
        boolean expectedStatus = true;

        // act
        boolean actualStatus = cut.removeTrade( uniqueTrade.getTrade_id() );
        long actualResult = cut.getNoOfTrades();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsTradesRepo, times(1)).delete(theTrade);
    }

    // This test covers the other logic path in cut.removeTrade()
    @Ignore
    @Test
    public  void    add_Trade_and_remove_Trade_that_doess_not_exist_return_number_of_Trades_is_one()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        Trade uniqueTrade = cut.addTrade( theTrade );

        long invalidId = 33;
        long expectedResult = 1;
        boolean expectedStatus = false;

        Optional<Trade> opt = Optional.empty();
        Mockito.when(itsTradesRepo.findById(invalidId)).thenReturn(opt);

        Mockito.when(itsTradesRepo.count()).thenReturn(1L);

        // act
        // There is no Trade with ID == 33
        boolean actualStatus = cut.removeTrade( invalidId );
        long actualResult = cut.getNoOfTrades();

        // assert
        assertEquals( expectedStatus, actualStatus);
        assertEquals( expectedResult, actualResult );
        verify(itsTradesRepo, times(0)).delete(theTrade);
    }

    @Test
    public  void    find_Trade_by_valid_id_returns_one_Trade()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(2);
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Trade addedTrade = cut.addTrade( theTrade );
        Trade expectedTrade = theTrade;
        theTrade = new Trade();
        theTrade.setTrade_id(3);
        cut.addTrade( theTrade );

        Trade jpaTrade = addedTrade;
        Optional<Trade> opt = Optional.of(addedTrade);
        Mockito.when(itsTradesRepo.findById((long)addedTrade.getTrade_id())).thenReturn(opt);

        // act
        Trade actualResult = cut.getTradeById( addedTrade.getTrade_id() );

        // assert
        assertEquals( expectedTrade.getTrade_id(), actualResult.getTrade_id() );
    }

    @Ignore
    @Test
    public  void    find_Trade_by_invalid_id_returns_null_Trade()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(2);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(3);
        cut.addTrade( theTrade );
        long invalidId = 33;

        Optional<Trade> opt = Optional.empty();
        Mockito.when(itsTradesRepo.findById(invalidId)).thenReturn(opt);

        // act
        assertThrows(NoSuchElementException.class, () -> {
            cut.getTradeById( invalidId );
        });
    }


    @Ignore
    @Test
    public  void    update_Trade_that_exists_returns_Trade_id()
    {
        // arrange
        Trade theTrade = new Trade();
        theTrade.setTrade_id(1);
        cut.addTrade( theTrade );
        theTrade = new Trade();
        theTrade.setTrade_id(2);
        Mockito.when(itsTradesRepo.save(theTrade)).thenReturn(theTrade);
        Trade expectedTrade = cut.addTrade( theTrade );
        Trade TradeToUpdate = theTrade;
        int TradeToFind = 2;
        theTrade = new Trade();
        theTrade.setTrade_id(3);
        cut.addTrade( theTrade );
        Mockito.when(itsTradesRepo.save(TradeToUpdate)).thenReturn(TradeToUpdate);

        // act
        TradeToUpdate.setTrade_id(4);
        Trade actualTrade = cut.updateTradeDetails( TradeToUpdate );

        // assert
        assertEquals( expectedTrade, actualTrade );
    }
}
