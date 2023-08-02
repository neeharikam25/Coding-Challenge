package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.service.TradeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class TradesController {
    private TradeHandler tradesService;

    @Autowired
    public TradesController(TradeHandler ds)
    {
        tradesService = ds;
    }

    @GetMapping("/trades")
    public List<Trade> getAllTrades() {
        return tradesService.getAllTrades();
    }

    @GetMapping("/trades/{id}")
    public ResponseEntity< Trade > getTradeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Trade trades = tradesService.getTradeById(id);
        return ResponseEntity.ok().body(trades);
    }

    @GetMapping("/trades/security/{id}")
    public ResponseEntity< Trade > getTradeBySecurityId(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        Trade trades = tradesService.getTradeBySecurity(id);
        return ResponseEntity.ok().body(trades);
    }
    @PostMapping("/trades")
    public Trade createTrade(@Valid @RequestBody Trade trade) {
        return tradesService.addTrade(trade);
    }

    @PutMapping("/trades/{id}")
    public ResponseEntity < Trade > updateTrade(@PathVariable(value = "id") Long id,
                                            @Valid @RequestBody Trade tradeDetails) throws ResourceNotFoundException {

        final Trade updatedTrade = tradesService.updateTradeDetails(tradeDetails);
        return ResponseEntity.ok(updatedTrade);
    }

    @DeleteMapping("/trades/{id}")
    public Map< String, Boolean > deleteTrade(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = tradesService.removeTrade(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}

