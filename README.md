**format2anyformat-java**

![format2anyformat-java Program](assets/program.png)

This project provides a versatile file converter tool that allows users to convert files between different formats. It is built using Java and Maven, and it requires the following steps to build and run:

## Building Instructions:

Make sure you have Maven installed on your system. If not, you can download and install it from Maven's official website.

Clone this repository to your local machine:
```
git clone https://github.com/erick-jpeg/format2anyformat-java.git
```

## Navigate to the project directory:
```
cd format2anyformat-java
```

Use Maven to compile the project and resolve its dependencies:

```
mvn compile
```

After successful compilation, you can run the App.java file to start the file converter tool:

```
mvn exec:java -Dexec.mainClass="com.conversor.App"
```

## Running Pre-built Release:

If you prefer to use a pre-built release, you can download the latest release from the Releases page. After downloading the JAR file, you can run it using the following command:

```
java -jar format2anyformat-java-1.0.jar
```

## Dependencies:

This project depends on the following libraries:

* Apache PDFBox: A Java library for working with PDF documents.
* Apache POI: A Java library for working with Microsoft Office documents.

Make sure these dependencies are resolved during the build process.
