/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineas.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lineas.Lineas;

/**
 *
 * @author Nestor
 */
@Stateless
@Path("lineas.lineas")
public class LineasFacadeREST extends AbstractFacade<Lineas> {

    @PersistenceContext(unitName = "WSLineasGuaguaPU")
    private EntityManager em;

    public LineasFacadeREST() {
        super(Lineas.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Lineas entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Lineas entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Lineas find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Lineas> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Lineas> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @GET
    @Path("allLineas")
    @Produces({"application/xml","application/json"})
    public String getAllLineas(){
        String result="";
        try{
            List<Lineas> lineas=em.createQuery("SELECT l FROM Lineas l").getResultList();
            
            for (Lineas lineas1 : lineas) {
                result+=lineas1.getName()+": De "+lineas1.getOrigin()+" a "+lineas1.getDestination()+". ;";
            }
        }catch(NoResultException e){
            
        }
        return result;
    }
    
    @GET
    @Path("/getLinea/{origin}/{destination}")
    @Produces({"application/xml","application/json"})
    public String getLinea(@PathParam("origin") String origin, @PathParam("destination") String destination){
        String result="";
        try{
            List<Lineas> lineas=em.createQuery("SELECT l FROM Lineas l WHERE l.origin = :origin AND l.destination =:destination").setParameter("origin", origin)
                    .setParameter("destination", destination).getResultList();
            for (Lineas linea : lineas) {
                result+=linea.getName()+":";
            }
        }catch(NoResultException e){
            
        }
        return result;
    }
    
    @GET
    @Path("allOrigin")
    @Produces({"application/xml","application/json"})
    public String getAllOrigin(){
        String result="";
        try{
            List<Lineas> lineas=em.createQuery("SELECT l FROM Lineas l").getResultList();
            
            for (Lineas lineas1 : lineas) {
                result+=lineas1.getOrigin()+":";
            }
        }catch(NoResultException e){
            
        }
        return result;
    }
    
    @GET
    @Path("allDestination")
    @Produces({"application/xml","application/json"})
    public String getAllDestination(){
        String result="";
        try{
            List<Lineas> lineas=em.createQuery("SELECT l FROM Lineas l").getResultList();
            
            for (Lineas lineas1 : lineas) {
                result+=lineas1.getDestination()+":";
            }
        }catch(NoResultException e){
            
        }
        return result;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
