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
Button task1Button1 = new Button("Create an account");
task1Button1.addClassName("taskbutton");
```

### Vaadin layout component
The buttons are displayed within a HorizontalLayout component to place them next to each other. 

```java
HorizontalLayout buttonsTask1 = new HorizontalLayout();
buttonsTask1.addClassName("buttonrow");
buttonsTask1.add(task1Button1);
```

Both the checkbox and buttons are combined in a VerticalLayout component. 

```java
VerticalLayout taskrow1 = new VerticalLayout();
taskrow1.add(row1, buttonsTask1);
taskrow1.addClassName("taskrow");
```