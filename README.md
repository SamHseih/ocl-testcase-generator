[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
# Constraint-Based Black-Box Test Case Generator 簡介
TCGen3 是一個研究性質的自動化軟體測試系統，基於限制式測試案例生成技術，能夠從軟體規格中自動產生具 DC/DCC 覆蓋準則 的 JUnit 測試腳本，並支援邊界條件分析。

🔹 輸入

OCL (Object Constraint Language)：可使用任意文字編輯器撰寫。

UML 類別圖 (Class Diagram, CD)：可透過 Papyrus 的圖形化介面進行建模。


🔹 輸出

JUnit 測試腳本(在 output_Junit)：具自動化執行能力，符合指定覆蓋標準。

🔹 系統中間產物（輸出資料夾結構）

AST (Abstract Syntax Tree)
解析 UML/Papyrus 類別圖與 OCL 2.4 約束式後，建立抽象語法樹 (AST) 與符號表 (Symbol Table)。

CLG (Constraint Logic Graph)
將 AST 轉換為約束邏輯圖 (CLG)，作為轉譯 CLP 前的中介表示。

CLP (Constraint Logic Program)
進一步將 CLG 轉譯為 ECLiPSe CLP 程式（.ecl 檔）。

Path
紀錄遍歷 CLG 各種路徑的過程。

Performance
紀錄系統執行時間與 CLG 統計資訊。

Test Datas
儲存不同專案、多個類別約束條件的求解結果。

🔹 範例與展示
Demo：包含多個 main 函式，方便測試各模組功能。
Examples：內建 9 個範例，涵蓋 OCL + CD 的完整流程。

# Constraint-Based Black-Box Test Case Generator Introduce
TCGen3 is a research-oriented automated software testing system.
It is based on constraint-based test case generation techniques, and is capable of producing JUnit test scripts that achieve DC/DCC coverage criteria, as well as performing boundary condition analysis.

🔹 Input

OCL (Object Constraint Language): editable with any plain-text editor.

UML Class Diagram (CD): editable with the Papyrus modeling tool via its graphical user interface.

🔹 Output

JUnit Test Scripts(at output_Junit): automatically generated with coverage guarantees and ready for execution.


🔹 Intermediate Artifacts (Output Folder Structure)

AST (Abstract Syntax Tree)
Parses UML/Papyrus class diagrams and OCL 2.4 constraints, then builds the abstract syntax tree (AST) and symbol table.

CLG (Constraint Logic Graph)
Translates the AST into a CLG, serving as the intermediate representation before CLP translation.

CLP (Constraint Logic Program)
Converts the CLG into ECLiPSe CLP code (.ecl files).

Path
Records the traversal process across different CLG paths.

Performance
Stores execution time measurements and CLG statistics.

Test Datas
Contains the solving results of multiple class constraints across different projects.

🔹 Examples and Demonstration

Demo: provides multiple main functions for testing different modules of the system.

Examples: includes 9 ready-to-use examples combining OCL + CD.

# Prerequisites
- [Papyrus](https://eclipse.dev/papyrus/) 
- [ECLiPSe](https://eclipseclp.org/)
- [GraphViz](https://graphviz.org/)
- [eclipse IDE](https://www.eclipse.org/)
- Java SE21
# How do I use it?
1. Download and Import the Project

2. Download the repository and import the tcgen3 project into Eclipse IDE.

3. Configure Build Path

In Eclipse, go to:

`Right-click project → Build Path → Configure Build Path`

4. Set Program Arguments

In Eclipse Run Configurations, set the arguments as:

`./example/Grade Grade DC`

Format:
`<OCL+CD path>   <Project name>   <Coverage criterion: DC or DCC>`

Run the Launcher/Execute the main function  in:
TCGenBlackBoxLauncher.java

# Example and PIT Result
The example folder contains 9 specification cases.
Their corresponding outputs can be found in the output and output_Junit directories.
You can run these examples directly to explore the system workflow.
![Screenshot](output/PIT%20Result/Screenshot.png)
![Screenshot2](output/PIT%20Result/Screenshot_2.png)
