/*
 * Copyright (C) 2005  Alexis Miara (alexis.miara@licef.ca)
 *
 * This file is part of LomPad.
 *
 * LomPad is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * LomPad is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with LomPad; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package ca.licef.lompad;

import org.w3c.dom.Element;

import java.util.Enumeration;

class FormWrapper extends FormContainer {
    public FormWrapper() {
        super();
    }

    public FormWrapper(String title, boolean isLine) {
        super(title, isLine);
    }

    void addFormContent() {
    }
    
    String toEvaluateFrame(String key) {       
        int subCat=0;
        String res = "";
        String xml = "";
        FormComponent c;       
        
        if (key.startsWith("1.10")){
            subCat = Integer.parseInt(key.substring(5)) - 1;
            c = (FormComponent) vComponents.elementAt(subCat);                       
            res = c.toEvaluateFrame(key);    
        }
        else if (key.startsWith("4.8")){
            subCat = Integer.parseInt(key.substring(4)) - 1;
            c = (FormComponent) vComponents.elementAt(subCat);                       
            res = c.toEvaluateFrame(key);
        }
        else if (key.startsWith("4.9")){
            subCat = Integer.parseInt(key.substring(4)) - 1;
            c = (FormComponent) vComponents.elementAt(subCat);                       
            res = c.toEvaluateFrame(key);
        }
        else if (key.startsWith("5.12")){
            subCat = Integer.parseInt(key.substring(5)) - 1;
            c = (FormComponent) vComponents.elementAt(subCat);                       
            res = c.toEvaluateFrame(key);
        }
        else if (key.startsWith("5.13")){
            subCat = Integer.parseInt(key.substring(5)) - 1;
            c = (FormComponent) vComponents.elementAt(subCat);                       
            res = c.toEvaluateFrame(key);
        }
        else{        
            for (Enumeration e = vComponents.elements(); e.hasMoreElements();) {
                c = (FormComponent) e.nextElement();
                res += c.toEvaluateFrame(key);                
            }
        }
        
        if (res != null)
            xml += res;
        
        if (xml.equals(""))
            xml = null;

        return xml;
    }


    //XML
    String toXML(String key, boolean incr) {
        String xml = "";

        int i = 1;
        for (Enumeration e = vComponents.elements(); e.hasMoreElements(); i++) {
            FormComponent c = (FormComponent) e.nextElement();
            String res = c.toXML(key + (incr ? "." + i : ""));
            if (res != null)
                xml += res;
        }

        if (xml.equals(""))
            xml = null;

        return xml;
    }

    void fromXML(String path, Element e, boolean loop) {
        if (loop)
            fromXML(path, e);
        else {
            FormComponent c = (FormComponent) vComponents.firstElement();
            c.fromXML(path, e);
        }
    }

    //HTML
    String toHTML(String key, boolean incr) {
        String html = "";

        int i = 1;
        for (Enumeration e = vComponents.elements(); e.hasMoreElements(); i++) {
            FormComponent c = (FormComponent) e.nextElement();
            String res = c.toHTMLData(key + (incr?"." + i:""));
            if (res != null)
                html += res;
        }

        if (html.equals(""))
            html = null;

        return html;
    }
}
