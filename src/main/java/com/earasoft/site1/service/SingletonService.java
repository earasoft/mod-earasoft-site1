package com.earasoft.site1.service;

import java.io.File;
import java.io.IOException;

import org.vertx.java.core.Vertx;
import org.vertx.java.core.file.impl.PathAdjuster;
import org.vertx.java.core.impl.VertxInternal;

import freemarker.template.Configuration;

public class SingletonService {
    private static SingletonService instance = null;
    private Configuration cfg;
    private File vertxPath;
    
    public File getVertxPath() {
		return vertxPath;
	}


	public Configuration getCfg() {
        return cfg;
    }
    
    
    protected SingletonService(Vertx vertx) {
        
        this.cfg = new Configuration();
        try {
        	this.vertxPath = new File(PathAdjuster.adjust((VertxInternal) vertx,""));
            cfg.setDirectoryForTemplateLoading(this.vertxPath);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static SingletonService getInstance(Vertx vertx) {
       if(instance == null) {
          instance = new SingletonService(vertx);
       }
       return instance;
    }
 }