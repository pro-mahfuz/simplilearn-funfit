package com.funfit;


import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;



public class FunFitApplication {


    public static void main(String[] args) throws Exception {


        String webAppPath =
                new File("src/main/webapp")
                        .getAbsolutePath();



        if(!new File(webAppPath).exists()) {

            throw new IllegalStateException(
                    "Web application folder not found"
            );

        }



        Tomcat tomcat = new Tomcat();



        tomcat.setBaseDir(
                "target/tomcat"
        );



        tomcat.setPort(8080);



        // Required to initialize connector

        tomcat.getConnector();



        Context context =
                tomcat.addWebapp(
                        "/FunFit",
                        webAppPath
                );



        context.setParentClassLoader(
                FunFitApplication.class
                .getClassLoader()
        );



        System.out.println(
                "FunFit started at:"
        );

        System.out.println(
                "http://localhost:8080/FunFit/"
        );



        tomcat.start();



        tomcat.getServer()
              .await();


    }


}