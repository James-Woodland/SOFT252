/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PatientManagementSystem.Serialiser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author james
 */
public class Serialiser {
    private String name;
    
    /**
     *
     * @param filename
     */
    public Serialiser(String filename){
        name = filename;
    }
       
    /**
     *
     * @param filename
     */
    public void setName(String filename){
        name = filename;
    }
    
    /**
     *
     * @return
     */
    public String getName(){
        return name;
    }
    
    /**
     *
     * @param object
     * @return
     */
    public void writeObject(Serializable object){
        try {
            FileOutputStream fileOutput = new FileOutputStream(name);
            ObjectOutputStream output = new ObjectOutputStream(fileOutput);
            output.writeObject(object);
            output.close();
            fileOutput.close();                      
         } catch (IOException i) {           
            i.printStackTrace();           
         }
    }
    
    /**
     *
     * @return
     */
    public Serializable readObject(){
        Serializable loadedObject = null;
        try {
         FileInputStream fileInput = new FileInputStream(name);
         ObjectInputStream input = new ObjectInputStream(fileInput);
         loadedObject = (Serializable) input.readObject();
         input.close();
         fileInput.close();       
        } catch (IOException i) {       
            i.printStackTrace();
        } catch (ClassNotFoundException c) {           
            c.printStackTrace();
        }
        return loadedObject;
    }
}
