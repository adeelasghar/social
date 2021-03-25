package com.mentoringminds.haris.social;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests.The returned object will be sent
 to the client as "text/plain" media type.
     *
     * @param request
     * @return String that will be returned as a text/plain response.
     */
//    @Context
//    HttpServletRequest req;
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public static String getCurrentUrl(HttpServletRequest request) throws MalformedURLException, URISyntaxException{

    URL url = new URL(request.getRequestURL().toString());

    String host  = url.getHost();
    String userInfo = url.getUserInfo();
    String scheme = url.getProtocol();
    int port = url.getPort();
    String path = request.getAttribute("javax.servlet.forward.request_uri").toString();
    String query = request.getAttribute("javax.servlet.forward.query_string").toString();
    URI uri = new URI(scheme,userInfo,host,port,path,query,null);
    return uri.toString();
    }
    }
//
//        @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public String getIt() {
//        return req.getLocalAddr();
//    }
//}
