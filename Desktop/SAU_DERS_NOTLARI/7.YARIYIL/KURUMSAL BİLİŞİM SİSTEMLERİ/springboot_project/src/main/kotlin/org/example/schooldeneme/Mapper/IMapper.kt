package org.example.schooldeneme.Mapper

interface IMapper<Response,Request,Entity> {
    fun entityToResponse(entity: Entity) : Response
    fun responseToEntity(response: Response) : Entity
    fun requestToEntity(request: Request) : Entity
    fun entityListToResponseList(entity: List<Entity>) : List<Response>
    fun updateRequestToEntity(request: Request, entity: Entity)
}