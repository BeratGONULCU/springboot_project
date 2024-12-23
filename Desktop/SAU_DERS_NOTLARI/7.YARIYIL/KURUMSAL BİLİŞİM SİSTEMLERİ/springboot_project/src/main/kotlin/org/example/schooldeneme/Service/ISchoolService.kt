package org.example.schooldeneme.Service

import com.sun.net.httpserver.Request
import jakarta.persistence.Id
import org.example.schooldeneme.dto.Request.SchoolRequest
import org.example.schooldeneme.dto.Response.SchoolResponse

interface ISchoolService {
    fun createSchool(request : SchoolRequest) : SchoolResponse
    fun getAllSchool() : List<SchoolResponse>
    fun receiveSchoolById(schoolId : Int) : SchoolResponse
    fun updateSchoolById(schoolId : Id , Request : SchoolRequest) : SchoolResponse
    fun deleteSchoolById(schoolId : Int)
}

// fun createProduct(request : ProductRequest) : ProductResponse
// fun getAllProducts() : List<ProductResponse>
// fun receiveProductById(productId : Long) : ProductResponse
// fun updateProductById(productId: Long, request: ProductRequest) : ProductResponse
// fun deleteProductById(productId: Long)