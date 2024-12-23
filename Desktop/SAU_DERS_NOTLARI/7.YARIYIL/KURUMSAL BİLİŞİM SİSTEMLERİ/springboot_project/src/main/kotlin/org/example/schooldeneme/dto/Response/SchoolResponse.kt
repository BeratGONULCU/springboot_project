package org.example.schooldeneme.dto.Response

data class SchoolResponse(
    var schoolId: Int,
    var schoolName:String,
    val studentList: List<StudentResponse>,
    )
