package org.example.schooldeneme.Presentation

import jakarta.persistence.Id
import org.example.schooldeneme.Service.IFamilyService
import org.example.schooldeneme.dto.Request.FamilyRequest
import org.example.schooldeneme.dto.Response.FamilyResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/family")

class FamilyController(private val familyService: IFamilyService) {

    @PostMapping
    fun createFamily(@RequestBody req : FamilyRequest) : ResponseEntity<FamilyResponse> {
        val family = familyService.CreateFamily(req)
        return ResponseEntity(family,HttpStatus.CREATED)
    }

    @GetMapping
    fun getAllFamily() : ResponseEntity<List<FamilyResponse>>{
        val families = familyService.GetAllFamily()
        return ResponseEntity.ok(families)
    }

    @DeleteMapping("/{familyId}")
    fun deleteFamily(@PathVariable familyId : Int):ResponseEntity<FamilyResponse> {
        familyService.deleteFamilyById(familyId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}