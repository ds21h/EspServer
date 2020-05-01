/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jb.espswitch.server;

import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jan
 */
@Path("EspIdf/{Appl}/{Version}")
public class EspIdf {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of EspIdf
     */
    public EspIdf() {
    }

    /**
     * Retrieves representation of an instance of jb.espswitch.server.EspIdf
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImage(@PathParam("Appl") String lApplName,
            @PathParam("Version") String lApplVersion) {

        File mBestand;
        String mBestNaam;
        Response.ResponseBuilder lResponse;

        mBestNaam = lApplName + "-" + lApplVersion + ".bin";
        mBestand = new File("D:\\Source\\NetBeans\\EspServer\\" + mBestNaam);
        if (mBestand.exists()) {
            lResponse = Response.ok(mBestand);
//            lResponse = lResponse.header("Content-Length" , mBestand.length()); //To prevent chunked output by TomCat
        } else {
            lResponse = Response.status(Response.Status.NOT_FOUND);
        }
        return lResponse.build();
    }
}
