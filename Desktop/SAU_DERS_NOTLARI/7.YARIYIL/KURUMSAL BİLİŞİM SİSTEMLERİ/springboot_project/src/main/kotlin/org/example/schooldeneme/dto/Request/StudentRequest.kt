package org.example.schooldeneme.dto.Request

import org.example.schooldeneme.dto.Response.LessonResponse

data class StudentRequest(
    val studentName:String,
    val familyId:Int,
    val schoolId:Int,
    val lessonIds:List<Int>,
)
