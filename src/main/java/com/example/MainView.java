package com.example;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
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
        VerticalLayout todosList = new VerticalLayout(); // (1)

        Checkbox task1 = new Checkbox("Create account");
        Checkbox task2 = new Checkbox("Create blueprint");
        Checkbox task3 = new Checkbox("Create import mapping");
        Checkbox task4 = new Checkbox("Import product data");

        task1.setValue(true);
        task2.setValue(false);
        task3.setValue(false);
        task4.setValue(false);

        todosList.add(task1, task2, task3, task4);

        Button addButton = new Button("next task"); // (3)
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addButton.addClickShortcut(Key.ENTER);
        addButton.addClickListener(click -> {
            // (4)

        });
        add( // (5)
                new H1("How to get started with Beeyond?"),
                todosList,
                addButton
        );


    }
}