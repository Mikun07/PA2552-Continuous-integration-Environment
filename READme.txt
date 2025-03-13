Tic-Tac-Toe Game with CI/CD Integration


This project is a simple Tic-Tac-Toe game built using Java and Swing. It includes automated testing and CI/CD integration using GitHub Actions.
Project Overview
This project demonstrates a fully automated software development workflow, incorporating:
* Development Environment: [VS Code](https://code.visualstudio.com/)
* Version Control Software: [SourceTree](https://www.sourcetreeapp.com/)
* Version Control Server: [GitHub](https://github.com/)
* Continuous Integration (CI) Tool: [GitHub Actions](https://github.com/features/actions)
* Automated Build Tool: [Maven](https://maven.apache.org/)
* Automated Testing Framework: [JUnit 5](https://junit.org/junit5/)
This ensures the Tic-Tac-Toe application is continuously built and tested upon each code change.
Setup Instructions
1. Clone the Repository:
git clone https://github.com/Mikun07/PA2552-Continuous-integration-Environment.git
cd TicTacToe
2. Open in VS Code
3.  Install Maven:
Ensure you have Maven installed. Check with: mvn -version
Build & Run the Application
1. Build the Project:
Use Maven to compile the project: mvn clean package
2. Run the Application:
Run the Tic-Tac-Toe game: java -jar target/TicTacToe-1.0-SNAPSHOT.jar
Running Automated Tests
The project includes unit tests and integration tests using JUnit.
1. Run All Tests:
mvn test
2. Run Specific Tests:
mvn test -Dtest=TC01Test,TC02Test,TC03Test
Continuous Integration (CI) with GitHub Actions
CI Workflow:
* Triggers: Runs on every push or pull request to main.
* Steps:
   * Check out the latest code
   * Set up Java 21
   * Install dependencies using Maven
   * Run unit and integration tests
   * Build the project
* Located in .github/workflows/ci.yml:
Contributors
* Ayomikun Festus-Olaleye
* Hao Pan
* Mandela Ogunleye
* Harsha Vardhan Devulapalli