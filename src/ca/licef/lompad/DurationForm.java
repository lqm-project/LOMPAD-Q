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

import java.awt.*;
import java.util.Enumeration;

class DurationForm extends FormContainer {
    public DurationForm(String title, boolean isLine, boolean isMultiple) {
        super(title, isLine, isMultiple);
    }

    void addFormContent() {
        DurationComponent duration = new DurationComponent();
        duration.setMinimumSize(new Dimension(10, 50));
        duration.setPreferredSize(new Dimension(10, 50));
        duration.setMaximumSize(new Dimension(2000, 50));
        addComponent(duration);

        LangstringForm description = new LangstringForm("description", false, true, true);
        description.addFormContent();
        addComponent(description);
    }

    String toEvaluateFrame(String key){
        String xml = "";

        for (Enumeration e = vComponents.elements(); e.hasMoreElements();) {
            FormComponent c = (FormComponent) e.nextElement();
            String res = c.toEvaluateFrame(key);
            if (res != null)
                xml +=res;
        }

        if (xml.equals(""))
            xml = null;

        return xml;
    } 
    
    
    //HTML
    String toHTML(String key) {
        String html = "";
        for (Enumeration e = vComponents.elements(); e.hasMoreElements();) {
            FormComponent c = (FormComponent) e.nextElement();
            String res =(c instanceof FormContainer)?
                    c.toHTMLData(key):c.toHTML(key);
            if (res != null) html += res;
        }

        if (!html.equals(""))
            html = "<TR><TD WIDTH=\"160\" VALIGN=\"TOP\"><B>" + Util.getLabel(key)+ "</B></TD>" +
                    "<TD VALIGN=\"TOP\">" + html + "</TD></TR>";
        else
            html = null;

        return html;
    }
}
