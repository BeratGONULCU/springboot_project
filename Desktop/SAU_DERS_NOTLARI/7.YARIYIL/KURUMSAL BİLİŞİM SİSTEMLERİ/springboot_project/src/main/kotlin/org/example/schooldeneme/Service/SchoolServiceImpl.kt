package org.example.schooldeneme.Service

import jakarta.persistence.Id
import org.example.schooldeneme.Mapper.SchoolMapper
import org.example.schooldeneme.jpa.ISchoolRepository
import org.springframework.stereotype.Service
import org.example.schooldeneme.dto.Request.SchoolRequest
import org.example.schooldeneme.dto.Response.SchoolResponse
import kotlin.jvm.optionals.toList

@Service
class SchoolServiceImpl(
    var schoolRepository : ISchoolRepository,
    private val schoolMapper: SchoolMapper
): ISchoolService {

    private val SCHOOL_NOT_FOUND_MESSAGE : String = "bu okul bulunamadı..!"

    override fun createSchool(request : SchoolRequest) : SchoolResponse {
        val schoolRequest = schoolMapper.requestToEntity(request)
        schoolRepository.save(schoolRequest)
        return schoolMapper.entityToResponse(schoolRequest)
    }

    override fun getAllSchool(): List<SchoolResponse> {
        val allSchool = schoolRepository.findAll().toList()
        return schoolMapper.entityListToResponseList(allSchool)
    }

    override fun receiveSchoolById(schoolId: Int): SchoolResponse {
        val validSchool = schoolRepository.findById(schoolId)
        val isSchoolValid = validSchool.isPresent
//        val schoolById = schoolRepository.findById(schoolId).toList()
        if(isSchoolValid == true)
        {
            return schoolMapper.entityToResponse(validSchool.get())
        }
        else throw RuntimeException(SCHOOL_NOT_FOUND_MESSAGE)
    }

    override fun deleteSchoolById(schoolId: Int) {
        val validSchool = schoolRepository.findById(schoolId).orElseThrow { throw RuntimeException(SCHOOL_NOT_FOUND_MESSAGE) }

        try {
            schoolRepository.delete(validSchool)
        }
        catch (e: Exception) {throw RuntimeException("Could not delete school $schoolId", e)}

    }

    override fun updateSchoolById(schoolId: Id, Request: SchoolRequest): SchoolResponse {
        TODO("Not yet implemented")
    }

}