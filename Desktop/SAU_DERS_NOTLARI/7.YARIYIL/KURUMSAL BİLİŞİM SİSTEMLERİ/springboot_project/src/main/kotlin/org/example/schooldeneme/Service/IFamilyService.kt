package org.example.schooldeneme.Service

import com.sun.net.httpserver.Request
import jakarta.persistence.Id
import org.example.schooldeneme.dto.Request.FamilyRequest
import org.example.schooldeneme.dto.Response.FamilyResponse

interface IFamilyService {
    fun CreateFamily(request: FamilyRequest) : FamilyResponse
    fun GetAllFamily() : List<FamilyResponse>
    fun deleteFamilyById(familyId : Int)
}