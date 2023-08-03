package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TradeHandler
{
    private TradeRepository itsTradesRepo;

    @Autowired
    public TradeHandler( TradeRepository tradeRepo )
    {
        this.itsTradesRepo = tradeRepo;
    }


    public List<Trade> getAllTrades()
    {
        return itsTradesRepo.findAll();
    }


    public Trade addTrade(Trade theTrade)
    {
        return itsTradesRepo.save( theTrade );
    }


    public long getNoOfTrades()
    {
        return itsTradesRepo.count();
    }


    public boolean removeTrade(long uniqueId)
    {
        boolean result = false;

        Optional<Trade> theTrade = itsTradesRepo.findById(uniqueId);
        if(theTrade.isPresent())
        {
            itsTradesRepo.delete(theTrade.get());
            result = true;
        }

        return  result;
    }


    public Trade getTradeById(long uniqueId)
    {
        return itsTradesRepo.findById(uniqueId).get();
    }


    public Trade getTradeBySecurity(int id )
    {
        Trade tradeToFind = new Trade();
        tradeToFind.setSecurity_id(id);
        List<Trade> trades = itsTradesRepo.findBySecurityId(id);
        Trade result = null;

        if( trades.size() == 1)
            result = trades.get(0);

        return result;
    }


    public Trade updateTradeDetails(Trade tradeToUpdate)
    {
        return itsTradesRepo.save( tradeToUpdate );
    }
}
