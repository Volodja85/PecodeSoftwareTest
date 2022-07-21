package com.ita.edu.pecodesoftware.ui.elements.custom_elements;

import com.ita.edu.pecodesoftware.ui.elements.base_element.BaseElement;
import org.openqa.selenium.WebElement;

public class ButtonElement extends BaseElement implements Button {

    public ButtonElement(WebElement element) {
        super(element);
    }

    public String getInnerText() {
        return getWrappedElement().getAttribute("innerText");
    }
}
