package com.ita.edu.pecodesoftware.ui.elements.custom_elements;

import com.ita.edu.pecodesoftware.ui.elements.base_element.Element;
import com.ita.edu.pecodesoftware.ui.elements.base_element.ImplementedBy;

@ImplementedBy(ButtonElement.class)
public interface Button extends Element {
    String getInnerText();
}
