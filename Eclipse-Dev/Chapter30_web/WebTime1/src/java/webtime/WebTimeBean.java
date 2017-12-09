/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webtime;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author superlamer
 */
@Named(value = "webTimeBean")
@ManagedBean
@RequestScoped
public class WebTimeBean {

    /**
     * Creates a new instance of WebTimeBean
     */
    public WebTimeBean() {
    }
    
}
