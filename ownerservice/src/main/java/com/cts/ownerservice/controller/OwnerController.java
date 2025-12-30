package com.cts.ownerservice.controller;

import com.cts.ownerservice.dto.MessageResponse;
import com.cts.ownerservice.dto.OwnerDetailsDto;
import com.cts.ownerservice.entity.OwnerEntity;
import com.cts.ownerservice.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @PostMapping("/save-details")
    public ResponseEntity<MessageResponse> saveOwnerDetails(@RequestBody OwnerEntity ownerEntity){
        return ownerService.saveOwnerDetails(ownerEntity);
    }
    @GetMapping("/get-details-by-id/{id}")
    public ResponseEntity<OwnerDetailsDto> getOwnerDetails(@PathVariable Long id){
        return ownerService.getOwnerDetailsById(id);
    }
    @PutMapping("/update/owner-details/{ownerId}")
    public ResponseEntity<OwnerDetailsDto> updateOwnerDetails(@PathVariable Long ownerId,@RequestBody OwnerDetailsDto ownerDetails){
         return ownerService.updateOwnerById(ownerId,ownerDetails);
    }
    @DeleteMapping("/delete/owner-by/{ownerId}")
    public ResponseEntity<MessageResponse> deleteOwnerById(@PathVariable Long ownerId){
        return ownerService.deleteOwnerById(ownerId);
    }

}
