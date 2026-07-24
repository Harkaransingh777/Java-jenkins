# Java + Jenkins Demo

![Java](https://img.shields.io/badge/Java-21-orange)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Jenkins](https://img.shields.io/badge/CI-Jenkins-red)
![Tests](https://img.shields.io/badge/Tests-JUnit%205-green)

A small, complete example of a Java application built with Maven, unit tested with JUnit 5, and built automatically by a Jenkins pipeline. Use it as a starting point for learning Jenkins CI/CD with Java, or as a portfolio project.

## What's inside

- **`Calculator.java`** — a small utility class (add, subtract, multiply, divide, power, factorial, prime check, even check)
- **`Main.java`** — entry point that demonstrates the calculator
- **`CalculatorTest.java`** — JUnit 5 unit tests covering normal cases and edge cases (like division by zero)
- **`pom.xml`** — Maven build configuration
- **`Jenkinsfile`** — declarative Jenkins pipeline: Checkout → Build → Test → Package → Archive Artifacts
- **`.gitignore`** — ignores build output and IDE files
- **`LICENSE`** — MIT license

## Project structure

```
java-jenkins-demo/
├── Jenkinsfile
├── README.md
├── LICENSE
├── pom.xml
├── .gitignore
└── src/
    ├── main/java/com/example/calculator/
    │   ├── Calculator.java
    │   └── Main.java
    └── test/java/com/example/calculator/
        └── CalculatorTest.java
```

## Prerequisites

- JDK 21+
- Maven 3.8+
- Git
- A Jenkins server (local or remote) with the Pipeline plugin (bundled by default in modern Jenkins)

## Run it locally

Build and run the app:

```bash
mvn clean package
java -jar target/java-jenkins-demo.jar
```

Run just the tests:

```bash
mvn test
```

## Push it to GitHub

```bash
cd java-jenkins-demo
git init
git add .
git commit -m "Initial commit: Java + Jenkins demo project"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

## Set up the Jenkins pipeline

1. In Jenkins, click **New Item** → choose **Pipeline** → give it a name → **OK**.
2. Under **Pipeline**, set **Definition** to `Pipeline script from SCM`.
3. Set **SCM** to `Git`, and paste your GitHub repo URL.
4. Set **Script Path** to `Jenkinsfile` (this is the default).
5. Save, then click **Build Now**.

The `Jenkinsfile` references a JDK tool named `JDK21` and a Maven tool named `Maven3`. Configure these once under **Manage Jenkins → Tools**:
- Add a **JDK installation** named `JDK21` (or check "Install automatically").
- Add a **Maven installation** named `Maven3` (or check "Install automatically").

If you'd rather not configure tools by hand, or your tool names differ, update the `tools {}` block in the `Jenkinsfile` to match what you configured — or swap it for a Docker agent so Jenkins pulls a ready-made Maven+JDK image instead:

```groovy
agent {
    docker { image 'maven:3.9-eclipse-temurin-21' }
}
```

(Requires Docker on the Jenkins agent, plus the Docker Pipeline plugin.)

## What the pipeline does

| Stage | What happens |
|---|---|
| Checkout | Pulls the latest code from your Git repo |
| Build | Compiles the source with `mvn clean compile` |
| Test | Runs the JUnit tests and publishes the results |
| Package | Builds the runnable JAR |
| Archive Artifacts | Saves the JAR on the Jenkins build page for download |

## Ideas to extend this project

- Add a GitHub webhook so Jenkins builds automatically on every `git push`
- Add a `Deploy` stage (e.g. copy the JAR to a server, or push a Docker image)
- Add static analysis (Checkstyle, SpotBugs) or code coverage (JaCoCo)
- Add a `Dockerfile` and build/push a container image as part of the pipeline

## License

MIT — see [LICENSE](LICENSE). Feel free to use this as a learning template or portfolio starter.
