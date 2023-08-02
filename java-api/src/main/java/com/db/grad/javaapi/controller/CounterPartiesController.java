package com.db.grad.javaapi.controller;


        import com.db.grad.javaapi.exception.ResourceNotFoundException;
        import com.db.grad.javaapi.model.CounterParty;
        import com.db.grad.javaapi.model.Trade;
        import com.db.grad.javaapi.service.CounterPartyHandler;
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
public class CounterPartiesController {
    private CounterPartyHandler cpService;

    @Autowired
    public CounterPartiesController(CounterPartyHandler ds)
    {
        cpService = ds;
    }

    @GetMapping("/counterparties")
    public List<CounterParty> getAllTrades() {
        return cpService.getAllCP();
    }

    @GetMapping("/counterparties/{id}")
    public ResponseEntity< CounterParty > getCPById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        CounterParty trades = cpService.getCPById(id);
        return ResponseEntity.ok().body(trades);
    }

    @PostMapping("/counterparties")
    public CounterParty createCP(@Valid @RequestBody CounterParty trade) {
        return cpService.addCP(trade);
    }

    @PutMapping("/counterparties/{id}")
    public ResponseEntity < CounterParty > updateCP(@PathVariable(value = "id") Long id,
                                                @Valid @RequestBody CounterParty tradeDetails) throws ResourceNotFoundException {

        final CounterParty updatedTrade = cpService.updateCPDetails(tradeDetails);
        return ResponseEntity.ok(updatedTrade);
    }

    @DeleteMapping("/counterparties/{id}")
    public Map< String, Boolean > deleteCP(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = cpService.removeCounterParty(id);

        Map < String, Boolean > response = new HashMap<>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}

