# Digital Onboarding

This is a prototype was developed by Niels Scholten in 2020. It is a prototype for the setup wizard of the digital onboarding of Beeyond. The prototype shows the functionalities of the setup wizard. It is build with the Vaadin framework, specifically Vaadin 14 and above. 

## Infrastructure

The files relevant to the setup wizard are located in the following folders:

```location
"/frontend/styles/shared-styles.css"; // styling
"/src/main/java/com.example/MainView.java"; // Main page
"/pom.xml"; // project file
```

## Installation
To continue make sure that at least the following tools are installed:
- Java Development Kit (JDK) 8 or later, like OpenJDK 8
- A Java IDE, like IntelliJ IDEA Community
- Node.js

Import the project with the "pom.xml" file in a Java IDE (like IntelliJ IDEA). When all necessary tools are installed, run the application.

## Usage 
The prototype contains a couple components and features: 

### Vaadin checkbox component
The checkbox component shows the status of a task from the setup wizard.

```java
Checkbox row1 = new Checkbox("", false);
```

### Vaadin button component
Within a task, the button component offers options for the user. 
The "adClassName" adds a class styling to the button. This class is defined in the styling file (see infrastructure).

```java
Button task2Button1 = new Button("Use a template");
task2Button1.addClassName("taskbutton");

Button task2Button2 = new Button("Import my own");
task2Button2.addClassName("taskbutton");
```

### Vaadin layout component
The buttons are displayed within a HorizontalLayout component to place them next to each other. 

```java
HorizontalLayout buttonsTask2 = new HorizontalLayout();
buttonsTask2.addClassName("buttonrow");
buttonsTask2.add(task2Button1, task2Button2);
```

Both the checkbox and buttons are combined in a VerticalLayout component and placed underneath each other. 

```java
VerticalLayout taskrow2 = new VerticalLayout();
taskrow2.add(row2, buttonsTask2);
taskrow2.addClassName("taskrow");
```

### Vaadin progressbar component
The progressbar shows the progress of the setup wizard.

```java
ProgressBar progressBar = new ProgressBar(0, 100, 0);
Label progressLabel = new Label("0%");
progressLabel.addClassName("progressLabel");
```

### if else function
The if else function checks if a task is already completed. When the task is completed, the checkbox will be checked and the buttons will be disabled. At this stage the function is reading from text fields defined at the top of the page. 

```java
Text task1Status = new Text("completed");
Text task2Status = new Text("active");
Text task3Status = new Text("open");
Text task4Status = new Text("open");
```

These text fields should be replaced with a database connection. Everytime the user finished a new task, the database should get an status update. Like in this example above, completed stands for a completed task, active for an active task and open for a task that is nog completed nor active. The status of a task is checked with the function below. 

```java
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
```

### Component execute
Every component is bundled in a VerticalLayout component like this:

```java
VerticalLayout page = new VerticalLayout();
page.add(content, resetButton);
page.addClassName("page");
```

This bundle is executed and displayed with the following code: 

```java
add(

	page

);
```

## Roadmap
Use this roadmap for further development of this prototype. 

- Create a database for the setup wizard
- Connect the prototype with the database
- Create actual tasks in the database with a status indicator (completed, active or open)
- Pull the status of these tasks from the database in the setup wizard
- Define the styling of the tasks based on the status from the tasks in the database
- Update the status of the tasks in the database when a certain task has been completed. 