package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.model.Security;
import com.db.grad.javaapi.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityHandler {
    private SecurityRepository securityRepo;

    @Autowired
    public SecurityHandler(SecurityRepository securityRepo) {
        this.securityRepo = securityRepo;
    }

    public Security findSecurityByBookId(int bookId) {
        return securityRepo.findSecurityByBookId(bookId);
    }

    public Security addSecurity(Security theSecurity) {
        return securityRepo.save(theSecurity);
    }

    public List<Security> getAllSecurities() {
        return securityRepo.findAll();
    }

    public Security updateSecurityDetails(Security securityToUpdate) {
        return securityRepo.save(securityToUpdate);
    }

    public boolean removeSecurity(long uniqueId) {
        boolean result = false;

        Optional<Security> theSecurity = securityRepo.findById(uniqueId);
        if(theSecurity.isPresent())
        {
            securityRepo.delete(theSecurity.get());
            result = true;
        }
        return  result;
    }

}
