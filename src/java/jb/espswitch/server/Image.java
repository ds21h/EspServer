/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jb.espswitch.server;

import java.io.File;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST Web Service
 *
 * @author Jan
 */
@Path("Image/{Bin}/{Version}")
public class Image {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public Image() {
    }

    /**
     * Retrieves representation of an instance of
     * jb.espswitch.server.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImage(@PathParam("Bin") int lBinNumber,
            @PathParam("Version") String lBinVersion) {

        File mBestand;
        String mBestNaam;
        ResponseBuilder lResponse;

        mBestNaam = "EspBin" + lBinNumber + "-" + lBinVersion + ".bin";
        mBestand = new File("D:\\Source\\NetBeans\\EspServer\\" + mBestNaam);
        if (mBestand.exists()) {
            lResponse = Response.ok(mBestand);
            lResponse = lResponse.header("Content-Length" , mBestand.length()); //To prevent chunked output by TomCat
        } else {
            lResponse = Response.status(Response.Status.NOT_FOUND);
        }
        return lResponse.build();
    }
}
