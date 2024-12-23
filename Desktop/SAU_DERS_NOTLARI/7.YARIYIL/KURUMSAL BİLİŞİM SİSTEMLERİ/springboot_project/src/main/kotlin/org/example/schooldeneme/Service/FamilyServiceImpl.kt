package org.example.schooldeneme.Service

import jakarta.persistence.Id
import org.example.schooldeneme.Mapper.FamilyMapper
import org.example.schooldeneme.jpa.IFamilyRepository
import org.springframework.stereotype.Service
import org.example.schooldeneme.dto.Request.FamilyRequest
import org.example.schooldeneme.dto.Response.FamilyResponse
import org.example.schooldeneme.jpa.ISchoolRepository

@Service
class FamilyServiceImpl(
    var familyRepository : IFamilyRepository,
    private val familyMapper: FamilyMapper
): IFamilyService {

    private val FAMILY_NOT_FOUND_MESSAGE = "bu aile bulunamadı..! "

    override fun GetAllFamily(): List<FamilyResponse> {
        TODO("Not yet implemented")
    }

    override fun CreateFamily(request: FamilyRequest): FamilyResponse {
        TODO("Not yet implemented")
    }

    override fun deleteFamilyById(familyId: Int) {
        TODO("Not yet implemented")
    }
}