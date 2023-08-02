
package com.db.grad.javaapi.service;

        import com.db.grad.javaapi.model.CounterParty;
        import com.db.grad.javaapi.model.Dog;
        import com.db.grad.javaapi.model.Trade;
        import com.db.grad.javaapi.repository.CounterPartyRepository;
        import com.db.grad.javaapi.repository.DogsRepository;
        import com.db.grad.javaapi.repository.TradeRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class CounterPartyHandler
{
    private CounterPartyRepository itsCPRepo;

    @Autowired
    public CounterPartyHandler( CounterPartyRepository tradeRepo )
    {
        itsCPRepo = tradeRepo;
    }


    public List<CounterParty> getAllCP()
    {
        return itsCPRepo.findAll();
    }


    public CounterParty addCP(CounterParty theTrade)
    {
        return itsCPRepo.save( theTrade );
    }


    public long getNoOfCPs()
    {
        return itsCPRepo.count();
    }


    public boolean removeCounterParty(long uniqueId)
    {
        boolean result = false;

        Optional<CounterParty> theTrade = itsCPRepo.findById(uniqueId);
        if(theTrade.isPresent())
        {
            itsCPRepo.delete(theTrade.get());
            result = true;
        }

        return  result;
    }


    public CounterParty getCPById(long uniqueId)
    {
        return itsCPRepo.findById(uniqueId).get();
    }


    public CounterParty getCPByName(String name )
    {
        CounterParty tradeToFind = new CounterParty();
        tradeToFind.setName(name);
        List<CounterParty> trades = itsCPRepo.findByName(name);
        CounterParty result = null;

        if( trades.size() == 1)
            result = trades.get(0);

        return result;
    }


    public CounterParty updateCPDetails(CounterParty tradeToUpdate)
    {
        return itsCPRepo.save( tradeToUpdate );
    }
}
