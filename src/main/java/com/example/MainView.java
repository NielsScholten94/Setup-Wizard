package com.example;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.helger.commons.functional.IFunction;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;
import elemental.json.*;
import jdk.nashorn.internal.ir.CallNode;
import org.atmosphere.interceptor.JSONPAtmosphereInterceptor;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Route
@CssImport("styles/shared-styles.css")

public class MainView extends VerticalLayout {

    public MainView () {

        Text task1Status = new Text("completed");
        Text task2Status = new Text("active");
        Text task3Status = new Text("open");
        Text task4Status = new Text("open");

        Checkbox row1 = new Checkbox("", false);
        Button task1Button = new Button("complete task");
        Checkbox row2 = new Checkbox("", false);
        Button task2Button = new Button("complete task");
        Checkbox row3 = new Checkbox("", false);
        Button task3Button = new Button("complete task");
        Checkbox row4 = new Checkbox("", false);
        Button task4Button = new Button("complete task");

        if (task1Status.getText().equals("completed")){
            row1.setValue(true);
            row1.setLabel("You finished setting up your account");
            task1Button.addClassName("disabled");
        } else {
            if (task1Status.getText().equals("active")){
                row1.setValue(false);
                row1.setLabel("Set up your account");
                row1.addClassName("active");
            } else {
                row1.setValue(false);
                row1.setLabel("Set up your account");
                task1Button.addClassName("disabled");
            }
        }

        if (task2Status.getText().equals("completed")){
            row2.setValue(true);
            row2.setLabel("You have created your first blueprint");
            task2Button.addClassName("disabled");
        } else {
            if (task2Status.getText().equals("active")){
                row2.setValue(false);
                row2.setLabel("Create your first blueprint");
                row2.addClassName("active");
            } else {
                row2.setValue(false);
                row2.setLabel("Create your first blueprint");
                task2Button.addClassName("disabled");
            }
        }

        if (task3Status.getText().equals("completed")){
            row3.setValue(true);
            row3.setLabel("You have created an import mapping");
            task3Button.addClassName("disabled");
        } else {
            if (task3Status.getText().equals("active")){
                row3.setValue(false);
                row3.setLabel("Create an import mapping");
                row3.addClassName("active");
            } else {
                row3.setValue(false);
                row3.setLabel("Create an import mapping");
                task3Button.addClassName("disabled");
            }
        }

        if (task4Status.getText().equals("completed")){
            row4.setValue(true);
            row4.setLabel("You have imported your product data");
            task4Button.addClassName("disabled");
        } else {
            if (task4Status.getText().equals("active")){
                row4.setValue(false);
                row4.setLabel("Import your product data");
                row4.addClassName("active");
            } else {
                row4.setValue(false);
                row4.setLabel("Import your product data");
                task4Button.addClassName("disabled");
            }
        }

        task1Button.addClickListener(click -> {

            row1.setValue(true);
            row1.setLabel("You finished setting up your account");
            task1Button.addClassName("disabled");
            row1.removeClassName("active");
            row2.addClassName("active");
            task2Button.removeClassName("disabled");

        });

        task2Button.addClickListener(click -> {

            row2.setValue(true);
            row2.setLabel("You have created your first blueprint");
            task2Button.addClassName("disabled");
            row2.removeClassName("active");
            row3.addClassName("active");
            task3Button.removeClassName("disabled");

        });

        task3Button.addClickListener(click -> {

            row3.setValue(true);
            row3.setLabel("You have created an import mapping");
            task3Button.addClassName("disabled");
            row3.removeClassName("active");
            row4.addClassName("active");
            task4Button.removeClassName("disabled");

        });

        task4Button.addClickListener(click -> {

            row4.setValue(true);
            row4.setLabel("You have imported your product data");
            task4Button.addClassName("disabled");
            row4.removeClassName("active");

        });

        VerticalLayout todosList = new VerticalLayout();
        todosList.add(row1, task1Button, row2, task2Button, row3, task3Button, row4, task4Button);

        Button resetButton = new Button("reset list");
        resetButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        resetButton.addClickListener(click -> {

            row1.setValue(false);
            row1.setLabel("Set up your account");
            row1.addClassName("active");
            task1Button.removeClassName("disabled");

            row2.setValue(false);
            row2.setLabel("Create your first blueprint");
            row2.removeClassName("active");
            task2Button.addClassName("disabled");

            row3.setValue(false);
            row3.setLabel("Create an import mapping");
            row3.removeClassName("active");
            task3Button.addClassName("disabled");

            row4.setValue(false);
            row4.setLabel("Import your product data");
            row4.removeClassName("active");
            task4Button.addClassName("disabled");

        });
        add(
                new H1("How to get started with Beeyond?"),
                todosList,
                resetButton
        );


    }
}