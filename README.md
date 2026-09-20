# 3D Cube Projection | Java

[![Java](https://img.shields.io/badge/Java-17%2B-orange?style=plastic&logo=openjdk)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-Work%20in%20Progress-yellow?style=plastic)](#)
[![macOS](https://img.shields.io/badge/macOS-supported-0078D4?style=plastic&logo=apple&logoColor=white)](#)
[![Windows](https://img.shields.io/badge/Windows-supported-0078D4?style=plastic&logo=windows&logoColor=white)](#)
[![Linux](https://img.shields.io/badge/Linux-supported-0078D4?style=plastic&logo=linux&logoColor=white)](#)


> A Java-based 3D rendering project focused on understanding the mathematics and implementation behind 3D projections.

## About

A Java program for 3D cube rendering using both orthographic and perspective projections. The project features custom classes, mathematical calculations with matrices, and GUIs that include adjustable buttons, sliders, etc. (Work in progress)


---

## Features

* Real-time 3D cube rendering
* Orthographic projection
* Perspective projection
* Matrix-based mathematical calculations
* Interactive cube rotation
* Mouse controls
* Keyboard controls
* Adjustable GUI controls
* Sliders for modifying rendering parameters
* Custom-built vector and calculation classes
* Java Swing GUI

---

## Preview

> Screenshots will be added as development continues.

<table>
  <tr>
    <td><img src="previews/preview1.png" width="200"></td>
    <td><img src="previews/preview2.png" width="200"></td>
    <td><img src="previews/preview3.png" width="200"></td>
    <td><img src="previews/preview4.png" width="200"></td>
    <td><img src="previews/preview5.png" width="200"></td>
  </tr>
</table>

---

## Downloads

### Latest Release

You can download the latest version of the project from the **Releases** section:

[![Download](https://img.shields.io/badge/Download-Latest%20Release-2ea44f?style=plastic&logo=github)](https://github.com/Mesippo/3D-Cube-Projection-Java/tree/main/Downloadable%20Jars)

> **Note:** The project is currently a work in progress, so releases may change frequently.

### Source Code

To download the source code directly:

[![Source Code](https://img.shields.io/badge/Source%20Code-GitHub-0078D4?style=plastic&logo=github&logoColor=white)](https://github.com/Mesippo/3D-Cube-Projection-Java/tree/main)

---

## Installation

### Requirements

* **Java JDK 17 or newer**
* Git *(optional)*

### Clone the Repository

```bash
git clone https://github.com/mesippo/3D-Cube-Projection-Java.git
cd 3D-Cube-Projection-Java
```

### Run the Project

Open the project in your preferred Java IDE and run the main class.

Compatible IDEs include:

* IntelliJ IDEA
* Eclipse
* Apache NetBeans
* Visual Studio Code

---

## How It Works

The renderer uses mathematical transformations to convert 3D coordinates into 2D screen coordinates.

The project explores concepts including:

* 3D vectors
* Matrix multiplication
* Rotation matrices
* Coordinate transformations
* Orthographic projection
* Perspective projection
* 3D-to-2D coordinate conversion

The goal is to implement these concepts manually rather than relying entirely on an external 3D engine.

---

## Project Structure

```text
src/
└── PhysicsEngine3D/
    ├── CustomEngine/
    │   ├── Calculations.java
    │   ├── InputControls.java
    │   └── PVector.java
    │
    ├── DCube.java
    └── Panel.java
```

> Project structure may change as development continues.

---
