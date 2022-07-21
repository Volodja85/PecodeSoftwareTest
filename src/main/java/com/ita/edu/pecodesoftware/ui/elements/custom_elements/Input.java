package com.ita.edu.pecodesoftware.ui.elements.custom_elements;


import com.ita.edu.pecodesoftware.ui.elements.base_element.Element;
import com.ita.edu.pecodesoftware.ui.elements.base_element.ImplementedBy;

    @ImplementedBy(InputElement.class)
    public interface Input extends Element {
        void set(String text);

        void pressEnter();
    }

