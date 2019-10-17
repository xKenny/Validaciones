/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *Clase que valida el correo
 * @author Duvan Poveda
 */
@FacesValidator(value = "ValidadorCorreo")
public class CorreoValidacion implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String correo = (String)value;
           Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        Matcher mather = pattern.matcher(correo);

        if (mather.find() == false) {
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Correo invalido","Ingrese un correo valido");
            throw new ValidatorException(mensaje);
        }
    }
    
}
