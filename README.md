# Constraint-Based Black-Box Test Case Generator Introduce
<img width="561" height="201" alt="image" src="https://github.com/user-attachments/assets/95e84b29-3610-4fef-984d-c0f0205dedd3" />

**TCGen3** is a research-oriented automated software testing system developed in Java.  
- A Java-based automated black-box test generation system composed of 11 integrated modules.
- It takes UML software specifications as input, interprets their OCL behavioral constraints, and automatically generates multiple JUnit 5 test scripts with expected inputs and outputs, realizing the concept of Behavior-Driven Development (BDD).
- The system aims to significantly reduce manual test script development time and error rates, while improving coverage and maintainability.
- It integrates theories and techniques from Formal Methods, Model-Based Testing, Constraint-Based Test Case Generation, Compiler Design, Symbolic Execution, and Black-Box Software Testing.
- This project is the implementation system of my master’s thesis:[Constraint-Based Black-Box Test Case Generation for Java Array Types](https://github.com/SamHseih/ocl-testcase-generator/edit/main/README.md)

## Introduction
### Input
- **OCL (Object Constraint Language)** — editable with any plain-text editor  
- **UML Class Diagram (CD)** — editable with **Papyrus** via its GUI
### Output
- **JUnit test scripts** (in `output_Junit`) — ready to run and aligned with the selected coverage criterion

### Intermediate output (output folders)
- **AST (Abstract Syntax Tree)** — Constructed from UML Class Diagrams and OCL 2.4 expressions. It represents the parsed and semantically analyzed structure before building the test model.
- **CLG (Constraint Logic Graph)** — Derived from the AST and serves as the system’s test model, representing OCL constraints in a graph-based logical form.
- **CLP (Constraint Logic Program)** — Generated ECLiPSe CLP (.ecl) code translated from a single executable path within the CLG.
- **Path** — Records a traversable route from the CLG’s start node to end node that can produce a valid test case.
- **Performance** — Stores execution time logs and statistical data for each system stage.
- **Test Data** — Contains the generated test inputs and outputs, stored as .txt files for each project or class.

## Prerequisites
- [Papyrus](https://eclipse.dev/papyrus/) 
- [ECLiPSe](https://eclipseclp.org/)
- [GraphViz](https://graphviz.org/)
- [eclipse IDE](https://www.eclipse.org/)
- **Java SE 21**
## How do I use it?
1. **Download & Import**  
   Clone this repository and import the **`tcgen3`** project into **Eclipse IDE**.
   Make sure the workspace path does not contain Chinese characters !

3. **Configure Build Path (if needed)**  
   `Right-click project → Build Path → Configure Build Path`

4. **Set Program Arguments**
   In **Run Configurations → Arguments → Program arguments**,

   set: `./example Grade DC`

   **Format:**  `<Papyrus Workspace path>   <Project name>   <Coverage criterion: DC or DCC>`

5. **Run the Launcher**  
Execute the `main` method in:
TCGenBlackBoxLauncher.java

# Example and PIT Result
The example folder contains 9 specification cases.
Their outputs are available in the output and output_Junit directories.
You can run these examples directly to explore the system workflow.
![Screenshot](output/PIT%20Result/Screenshot.png)
![Screenshot2](output/PIT%20Result/Screenshot_2.png)
