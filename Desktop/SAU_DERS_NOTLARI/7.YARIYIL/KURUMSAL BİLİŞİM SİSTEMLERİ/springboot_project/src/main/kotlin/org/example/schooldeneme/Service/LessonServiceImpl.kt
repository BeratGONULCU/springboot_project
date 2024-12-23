package org.example.schooldeneme.Service

import jakarta.persistence.Id
import org.example.schooldeneme.Mapper.FamilyMapper
import org.example.schooldeneme.Mapper.LessonMapper
import org.example.schooldeneme.jpa.ILessonRepository
import org.springframework.stereotype.Service
import org.example.schooldeneme.dto.Request.LessonRequest
import org.example.schooldeneme.dto.Response.LessonResponse

@Service
class LessonServiceImpl(
    var lessonRepository : ILessonRepository,
    var familyMapper: FamilyMapper
):ILessonService {
    override fun getAllLesson(): List<LessonResponse> {
        TODO("Not yet implemented")
    }

    override fun createLesson(request: LessonRequest): LessonResponse {
        TODO("Not yet implemented")
    }

    override fun deleteLessonById(lessonId: Int) {
        TODO("Not yet implemented")
    }
}