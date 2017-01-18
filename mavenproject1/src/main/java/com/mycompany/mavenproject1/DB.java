/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import io.minutelab.mlab.Lab;
import io.minutelab.mlab.MlabRule;
import io.minutelab.mlab.PostGresLab;
import io.minutelab.mlab.ResourcePrepare;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author user
 */
public class DB extends MlabRule{
   
    public DB(){
       this.lab = new PostGresLab(ResourcePrepare.filename(this, "/test.sql"));
    }

    public void unCovered(){
        this.lab = new Lab("will","never","run");
    }
}

