package com.example;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.helger.commons.functional.IFunction;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;
import elemental.json.Json;
import elemental.json.JsonObject;
import jdk.nashorn.internal.ir.CallNode;
import org.atmosphere.interceptor.JSONPAtmosphereInterceptor;

import java.io.FileReader;

@Route
@CssImport("styles/shared-styles.css")

public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout todosList = new VerticalLayout();

        Checkbox task1 = new Checkbox("you finished setting up your account", true);
        Checkbox task2 = new Checkbox("Create your first blueprint", false);
        Checkbox task3 = new Checkbox("Create an import mapping", false);
        Checkbox task4 = new Checkbox("Import your product data", false);

        todosList.add(task1, task2, task3, task4);

        Button addButton = new Button("next task");
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addButton.addClickListener(click -> {

            if (task1.isEmpty()){
                task1.setValue(true);
                task1.setLabel("you finished setting up your account");
            } else {
                if (task2.isEmpty()){
                    task2.setValue(true);
                    task2.setLabel("You have created your blueprint");
                } else {
                    if (task3.isEmpty()){
                        task3.setValue(true);
                        task3.setLabel("You have created an import mapping");
                    } else {
                        if (task4.isEmpty()){
                            task4.setValue(true);
                            task4.setLabel("you have imported your product data");

                            addButton.setText("reset list");
                        } else if(task1.isEnabled() | task2.isEnabled() | task3.isEnabled() | task4.isEnabled()){
                            task1.setValue(false);
                            task1.setLabel("Create your account");
                            task2.setValue(false);
                            task2.setLabel("Create your first blueprint");
                            task3.setValue(false);
                            task3.setLabel("Create an import mapping");
                            task4.setValue(false);
                            task4.setLabel("Import your product data");

                            addButton.setText("next task");
                        }
                    }
                }
            }

        });
        add( // (5)
                new H1("How to get started with Beeyond?"),
                todosList,
                addButton
        );


    }
}