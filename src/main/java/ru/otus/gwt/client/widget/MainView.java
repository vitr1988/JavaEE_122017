package ru.otus.gwt.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;

public class MainView extends Composite {
    @UiTemplate("MainPart.ui.xml")
    interface MainViewUiBinder extends UiBinder<VerticalPanel, MainView> {
    }

    @UiField
    TextBox loginTextField;

    @UiField
    PasswordTextBox passwordTextField;

    @UiField
    Button submit;

    private static MainViewUiBinder ourUiBinder = GWT.create(MainViewUiBinder.class);

    public MainView() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    public HandlerRegistration addClickHandler(ClickHandler handler) {
        return submit.addClickHandler(handler);
    }
}