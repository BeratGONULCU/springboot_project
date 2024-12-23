package org.example.schooldeneme.Mapper

import org.example.schooldeneme.ModelEntity.SchoolEntity
import org.example.schooldeneme.dto.Request.SchoolRequest
import org.example.schooldeneme.dto.Response.SchoolResponse
import org.springframework.stereotype.Component

@Component
class SchoolMapper:IMapper<SchoolResponse, SchoolRequest,SchoolEntity> {

    override fun entityToResponse(entity: SchoolEntity): SchoolResponse {
        return SchoolResponse(
            schoolId = entity.schoolId,
            schoolName = entity.schoolName,
            studentList = emptyList()
        )
    }

    override fun responseToEntity(response: SchoolResponse): SchoolEntity {
        return SchoolEntity(
            schoolId = 0,
            schoolName = response.schoolName
        )
    }

    override fun requestToEntity(request: SchoolRequest): SchoolEntity {
        return SchoolEntity(
            schoolId = 0,
            schoolName = request.schoolName
        )
    }

    override fun entityListToResponseList(entity: List<SchoolEntity>): List<SchoolResponse> {
        return entity.map {
            entityToResponse(it)
        }
    }

    override fun updateRequestToEntity(request: SchoolRequest, entity: SchoolEntity) {
        entity.schoolName = request.schoolName
    }
}