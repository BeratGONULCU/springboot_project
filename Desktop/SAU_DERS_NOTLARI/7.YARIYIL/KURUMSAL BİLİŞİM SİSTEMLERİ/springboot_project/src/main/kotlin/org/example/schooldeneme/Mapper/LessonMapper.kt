package org.example.schooldeneme.Mapper


import org.example.schooldeneme.ModelEntity.LessonEntity
import org.example.schooldeneme.dto.Request.LessonRequest
import org.example.schooldeneme.dto.Response.LessonResponse
import org.springframework.stereotype.Component

@Component
class LessonMapper:IMapper<LessonResponse,LessonRequest,LessonEntity> {

    override fun entityToResponse(entity: LessonEntity): LessonResponse {
        return LessonResponse(
            lessonId = entity.lessonId,
            lessonName = entity.lessonName,
        )
    }

    override fun responseToEntity(response: LessonResponse): LessonEntity {
        return LessonEntity(
            lessonId = 0,
            lessonName = response.lessonName,
        )
    }

    override fun requestToEntity(request: LessonRequest): LessonEntity {
        return LessonEntity(
            lessonId = 0,
            lessonName = request.lessonName,
        )
    }

    override fun entityListToResponseList(entity: List<LessonEntity>): List<LessonResponse> {
        return entity.map { entityToResponse(it) }
    }

    override fun updateRequestToEntity(request: LessonRequest, entity: LessonEntity) {
        entity.lessonName = request.lessonName
    }



}