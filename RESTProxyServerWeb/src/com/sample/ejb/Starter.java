package com.sample.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ejb.Startup;

/**
 * Session Bean implementation class Starter
 */
@Singleton
@LocalBean
@Startup
@ApplicationPath("/services")
public class Starter extends Application {

    /**
     * Default constructor. 
     */
    public Starter() {
        // TODO Auto-generated constructor stub
    }

}
