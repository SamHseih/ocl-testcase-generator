# Constraint-Based Black-Box Test Case Generator 簡介
<img width="561" height="201" alt="image" src="https://github.com/user-attachments/assets/95e84b29-3610-4fef-984d-c0f0205dedd3" />

- 本系統使用Java開發的一個研究性質的自動化軟體測試系統，基於限制式測試案例產生技術，能夠從軟體規格中自動產生具 DC/DCC 覆蓋準則 的 JUnit 測試腳本，並支援邊界條件分析。
- 本專案是碩士論文的實作系統 : [支援Java陣列型態的限制式黑箱測試案例產生](https://ndltd.ncl.edu.tw/cgi-bin/gs32/gsweb.cgi/ccd=rT2Se3/record?r1=1&h1=0)
### 輸入
- OCL (Object Constraint Language)：可使用任意文字編輯器撰寫。
- UML 類別圖 (Class Diagram, CD)：可透過 Papyrus 的圖形化介面進行建模。
### 輸出
- JUnit 測試腳本(在 output_Junit)：具自動化執行能力，符合指定覆蓋標準。
### 系統中間產物（輸出資料夾結構）
- AST (Abstract Syntax Tree)
  解析 UML/Papyrus 類別圖與 OCL 2.4 後，建立抽象語法樹 (AST) 與符號表 (Symbol Table)。
- CLG (Constraint Logic Graph)
  將 AST 轉換為限制邏輯圖 (CLG)，作為轉譯 CLP 前的中介表示。
- CLP (Constraint Logic Program)
  進一步將 CLG 轉譯為 ECLiPSe CLP 程式（.ecl 檔）。
- Path
  紀錄遍歷 CLG 各種路徑的過程。
- Performance
  紀錄系統執行時間與 CLG 統計資訊。
- Test Datas
  儲存不同專案、多個類別限制條件的求解結果。
- Demo：包含多個 main 函式，開發並測試各模組功能。
- Examples：內建 9 個範例，涵蓋 OCL + CD 的完整中間產物。

# Constraint-Based Black-Box Test Case Generator Introduce
<img width="561" height="201" alt="image" src="https://github.com/user-attachments/assets/95e84b29-3610-4fef-984d-c0f0205dedd3" />

**TCGen3** is a research-oriented automated software testing system developed in Java.  
It relies on **constraint-based test-case generation** to produce JUnit test scripts that meet **DC/DCC coverage** and supports **boundary condition analysis**.

This project is the implementation system of my master’s thesis:[Constraint-Based Black-Box Test Case Generation for Java Array Types](https://github.com/SamHseih/ocl-testcase-generator/edit/main/README.md)
## Introduction
### Input
- **OCL (Object Constraint Language)** — editable with any plain-text editor  
- **UML Class Diagram (CD)** — editable with **Papyrus** via its GUI
### Output
- **JUnit test scripts** (in `output_Junit`) — ready to run and aligned with the selected coverage criterion

### Intermediate Artifacts (output folders)
- **AST (Abstract Syntax Tree)** — AST and Symbol Table built from UML/Papyrus CD and OCL 2.4
- **CLG (Constraint Logic Graph)** — intermediate representation before CLP translation
- **CLP (Constraint Logic Program)** — generated **ECLiPSe CLP** code (`.ecl`)
- **Path** — logs of CLG path traversals
- **Performance** — execution time and CLG statistics
- **Test Data** — solutions for constraints across projects/classes

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
