package org.example.schooldeneme.Mapper

import org.example.schooldeneme.ModelEntity.FamilyEntity
import org.example.schooldeneme.dto.Request.FamilyRequest
import org.example.schooldeneme.dto.Response.FamilyResponse
import org.springframework.stereotype.Component

@Component
class FamilyMapper:IMapper<FamilyResponse,FamilyRequest,FamilyEntity> {

    override fun entityToResponse(entity: FamilyEntity): FamilyResponse {
        return FamilyResponse(
            familyId = entity.familyId,
            familySurname = entity.familySurname,
        )
    }

    override fun responseToEntity(response: FamilyResponse): FamilyEntity {
        return FamilyEntity(
            familyId = 0,
            familySurname = response.familySurname,
        )
    }

    override fun requestToEntity(request: FamilyRequest): FamilyEntity {
        return FamilyEntity(
            familyId = 0,
            familySurname = request.familySurname,
        )
    }

    override fun entityListToResponseList(entity: List<FamilyEntity>): List<FamilyResponse> {
        return entity.map {
            entityToResponse(it)
        }
    }

    override fun updateRequestToEntity(request: FamilyRequest, entity: FamilyEntity) {
        entity.familySurname = request.familySurname
    }

}