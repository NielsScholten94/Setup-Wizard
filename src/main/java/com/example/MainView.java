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
import com.vaadin.flow.component.progressbar.ProgressBar;
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

        // create variables to define status of tasks ( this should be pulled and updated from a database )
        Text task1Status = new Text("completed");
        Text task2Status = new Text("active");
        Text task3Status = new Text("open");
        Text task4Status = new Text("open");

        // create task rows

        // task row 1 (checkbox)
        Checkbox row1 = new Checkbox("", false);

        // task row 1 (buttons)
        Button task1Button1 = new Button("Create an account");
        task1Button1.addClassName("taskbutton");

        HorizontalLayout buttonsTask1 = new HorizontalLayout();
        buttonsTask1.addClassName("buttonrow");
        buttonsTask1.add(task1Button1);

        // task row 1 (combined object)
        VerticalLayout taskrow1 = new VerticalLayout();
        taskrow1.add(row1, buttonsTask1);
        taskrow1.addClassName("taskrow");


        // task row 2 (checkbox)
        Checkbox row2 = new Checkbox("", false);

        // task row 2 (buttons)
        Button task2Button1 = new Button("Use a template");
        task2Button1.addClassName("taskbutton");

        Button task2Button2 = new Button("Import my own");
        task2Button2.addClassName("taskbutton");

        HorizontalLayout buttonsTask2 = new HorizontalLayout();
        buttonsTask2.addClassName("buttonrow");
        buttonsTask2.add(task2Button1, task2Button2);

        // task row 1 (combined object)
        VerticalLayout taskrow2 = new VerticalLayout();
        taskrow2.add(row2, buttonsTask2);
        taskrow2.addClassName("taskrow");


        // task row 3 (checkbox)
        Checkbox row3 = new Checkbox("", false);

        // task row 3 (buttons)
        Button task3Button1 = new Button("Create with your data");
        task3Button1.addClassName("taskbutton");

        Button task3Button2 = new Button("Use demo data");
        task3Button2.addClassName("taskbutton");

        HorizontalLayout buttonsTask3 = new HorizontalLayout();
        buttonsTask3.addClassName("buttonrow");
        buttonsTask3.add(task3Button1, task3Button2);

        // task row 3 (combined object)
        VerticalLayout taskrow3 = new VerticalLayout();
        taskrow3.add(row3, buttonsTask3);
        taskrow3.addClassName("taskrow");


        // task row 4 (checkbox)
        Checkbox row4 = new Checkbox("", false);

        // task row 4 (buttons)
        Button task4Button1 = new Button("Run the import");
        task4Button1.addClassName("taskbutton");

        HorizontalLayout buttonsTask4 = new HorizontalLayout();
        buttonsTask4.addClassName("buttonrow");
        buttonsTask4.add(task4Button1);

        // task row 4 (combined object)
        VerticalLayout taskrow4 = new VerticalLayout();
        taskrow4.add(row4, buttonsTask4);
        taskrow4.addClassName("taskrow");


        // progress bar to indicate progress of setup wizard
        ProgressBar progressBar = new ProgressBar(0, 100, 0);
        Label progressLabel = new Label("0%");
        progressLabel.addClassName("progressLabel");

        HorizontalLayout progress = new HorizontalLayout();
        progress.addClassName("progress");
        progress.add(progressLabel, progressBar);


        // page title
        H1 title = new H1("How to get started with Beeyond?");


        // define start position of task elements based on variable task status from database
        if (task1Status.getText().equals("completed")){
            row1.setValue(true);
            row1.setLabel("You finished setting up your account");
            buttonsTask1.addClassName("disabled");
            progressBar.setValue(25);
            progressLabel.setText("25%");
            title.setText("How to get started with Beeyond?");
        } else {
            if (task1Status.getText().equals("active")){
                row1.setValue(false);
                row1.setLabel("Set up your account");
                taskrow1.addClassName("active");
            } else {
                row1.setValue(false);
                row1.setLabel("Set up your account");
                buttonsTask1.addClassName("disabled");
            }
        }

        if (task2Status.getText().equals("completed")){
            row2.setValue(true);
            row2.setLabel("You have created your first blueprint");
            buttonsTask2.addClassName("disabled");
            progressBar.setValue(50);
            progressLabel.setText("50%");
            title.setText("Great work, your blueprint is looking good!");
        } else {
            if (task2Status.getText().equals("active")){
                row2.setValue(false);
                row2.setLabel("Create your first blueprint");
                taskrow2.addClassName("active");
            } else {
                row2.setValue(false);
                row2.setLabel("Create your first blueprint");
                buttonsTask2.addClassName("disabled");
            }
        }

        if (task3Status.getText().equals("completed")){
            row3.setValue(true);
            row3.setLabel("You have created an import mapping");
            buttonsTask3.addClassName("disabled");
            progressBar.setValue(75);
            progressLabel.setText("75%");
            title.setText("Nice work! You're almost there.");
        } else {
            if (task3Status.getText().equals("active")){
                row3.setValue(false);
                row3.setLabel("Create an import mapping");
                taskrow3.addClassName("active");
            } else {
                row3.setValue(false);
                row3.setLabel("Create an import mapping");
                buttonsTask3.addClassName("disabled");
            }
        }

        if (task4Status.getText().equals("completed")){
            row4.setValue(true);
            row4.setLabel("You have imported your product data");
            buttonsTask4.addClassName("disabled");
            progressBar.setValue(100);
            progressLabel.setText("100%");
            title.setText("Congrats! You have completed the setup.");
        } else {
            if (task4Status.getText().equals("active")){
                row4.setValue(false);
                row4.setLabel("Import your product data");
                taskrow4.addClassName("active");
            } else {
                row4.setValue(false);
                row4.setLabel("Import your product data");
                buttonsTask4.addClassName("disabled");
            }
        }

        // define action when task is completed
        task1Button1.addClickListener(click -> {

            row1.setValue(true);
            row1.setLabel("You finished setting up your account");
            buttonsTask1.addClassName("disabled");
            taskrow1.removeClassName("active");
            taskrow2.addClassName("active");
            buttonsTask2.removeClassName("disabled");
            progressBar.setValue(25);
            progressLabel.setText("25%");
            title.setText("How to get started with Beeyond?");

        });

        task2Button1.addClickListener(click -> {

            row2.setValue(true);
            row2.setLabel("You have created your first blueprint");
            buttonsTask2.addClassName("disabled");
            taskrow2.removeClassName("active");
            taskrow3.addClassName("active");
            buttonsTask3.removeClassName("disabled");
            progressBar.setValue(50);
            progressLabel.setText("50%");
            title.setText("Great work, your blueprint is looking good!");

        });

        task3Button1.addClickListener(click -> {

            row3.setValue(true);
            row3.setLabel("You have created an import mapping");
            buttonsTask3.addClassName("disabled");
            taskrow3.removeClassName("active");
            taskrow4.addClassName("active");
            buttonsTask4.removeClassName("disabled");
            progressBar.setValue(75);
            progressLabel.setText("75%");
            title.setText("Nice work! You're almost there.");

        });

        task4Button1.addClickListener(click -> {

            row4.setValue(true);
            row4.setLabel("You have imported your product data");
            buttonsTask4.addClassName("disabled");
            taskrow4.removeClassName("active");
            progressBar.setValue(100);
            progressLabel.setText("100%");
            title.setText("Congrats! You have completed the setup.");

        });

        // create page layout
        VerticalLayout todosList = new VerticalLayout();
        todosList.addClassName("noPadding");
        todosList.add(progress, taskrow1, taskrow2, taskrow3, taskrow4);

        VerticalLayout content = new VerticalLayout();
        content.addClassName("noPadding");
        content.add(title, todosList);

        // reset button
        Button resetButton = new Button("reset list");
        resetButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        resetButton.addClickListener(click -> {

            row1.setValue(false);
            row1.setLabel("Set up your account");
            taskrow1.addClassName("active");
            buttonsTask1.removeClassName("disabled");

            row2.setValue(false);
            row2.setLabel("Create your first blueprint");
            taskrow2.removeClassName("active");
            buttonsTask2.addClassName("disabled");

            row3.setValue(false);
            row3.setLabel("Create an import mapping");
            taskrow3.removeClassName("active");
            buttonsTask3.addClassName("disabled");

            row4.setValue(false);
            row4.setLabel("Import your product data");
            taskrow4.removeClassName("active");
            buttonsTask4.addClassName("disabled");

            progressBar.setValue(0);
            progressLabel.setText("0%");

            title.setText("How to get started with Beeyond?");

        });

        // page layout
        VerticalLayout page = new VerticalLayout();
        page.add(content, resetButton);
        page.addClassName("page");

        // execute content on the page
        add(
                page
        );


    }
}