/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import com.udec.modelo.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 * Clase que contiene los controladores de las vista index
 * @author Duvan Poveda
 */
@Named(value = "index")
@SessionScoped
public class Index implements Serializable{

   private Persona persona = new Persona();
   private List<Persona> personas = new ArrayList();
    public Index() {
    }
 /**
 * Metodo que añade una nueva persona a la lista
 */
    public void añadirPersona(){
        this.personas.add(this.persona);
    }
    
   /**
    * Validacion del campo texto por medio del controlador
    * @param context atrapa la instancia cuando es llamada
    * @param toValidate controlador a validar
    * @param value valor del controlador
    */  
    public void validarSexo(FacesContext context, UIComponent toValidate, Object value){
        context = FacesContext.getCurrentInstance();
        String sexo = (String)value;
        if(!sexo.equalsIgnoreCase("masculino")&&!sexo.equalsIgnoreCase("femenino")){
            ((UIInput)toValidate).setValid(false);
            context.addMessage(toValidate.getClientId(context), new FacesMessage("solo se admiten los parametros: masculino/femenino"));
        }
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }
    
}
