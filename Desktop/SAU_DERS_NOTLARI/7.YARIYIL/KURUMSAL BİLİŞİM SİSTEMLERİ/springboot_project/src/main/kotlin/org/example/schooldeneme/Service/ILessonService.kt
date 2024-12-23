package org.example.schooldeneme.Service

import com.sun.net.httpserver.Request
import jakarta.persistence.Id
import org.example.schooldeneme.dto.Request.LessonRequest
import org.example.schooldeneme.dto.Response.LessonResponse

interface ILessonService {
    fun createLesson(request: LessonRequest) : LessonResponse
    fun getAllLesson(): List<LessonResponse>
    fun deleteLessonById(lessonId : Int)
}