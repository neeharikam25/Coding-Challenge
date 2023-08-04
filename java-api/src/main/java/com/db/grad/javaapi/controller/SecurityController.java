package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.service.SecurityHandler;
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
public class SecurityController {
    private SecurityHandler securityService;

    @Autowired
    public SecurityController(SecurityHandler ss)
    {
        securityService = ss;
    }

    @GetMapping("/security")
    public List<Security> getAllSecurities() {
        return securityService.getAllSecurities();
    }

    @GetMapping("/security/book/{id}")
    public ResponseEntity<Security> getSecurityByBookId(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        Security security = securityService.findSecurityByBookId(id);
        return ResponseEntity.ok().body(security);
    }

    @GetMapping("/security/user/{id}")
    public ResponseEntity<List<Security>> getSecurityByUserId(@PathVariable(value = "id") int id)
            throws ResourceNotFoundException {
        List<Security> security = securityService.getSecurityIdByUserId(id);
        return ResponseEntity.ok(security);
    }

    @PostMapping("/security")
    public Security createNewSecurity(@Valid @RequestBody Security se) {
        return securityService.addSecurity(se);
    }

    @PutMapping("/security/{id}")
    public ResponseEntity<Security> updateSecurity(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody Security securityDetails) throws ResourceNotFoundException {

        final Security updatedSecurity = securityService.updateSecurityDetails(securityDetails);
        return ResponseEntity.ok(updatedSecurity);
    }

    @DeleteMapping("/security/{id}")
    public Map< String, Boolean > deleteSecurity(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        boolean removed = securityService.removeSecurity(id);

        Map <String, Boolean> response = new HashMap<>();
        if (removed)
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
