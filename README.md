## UOW-IIT-OOP-ASSESMENT - League Manager

This project has angular frontend and play framework backend. Both of these configured as one project using a boilerplate. 

Overview of the League Manager as follows ;

- CLI Application functions :
  - Add club to the league
  - Delete club from league
  - Show the league table
  - Add match 
  - Invoke the GUI
  - Shoe clubs in the league

- GUI Application functions :
  - Show league table according to the points
  - Show league table according to scored goals
  - Show league table according to number of wins
  - Generate a match randomly
  - Sort matches according to date
  - Filter matches to given date
  
 ## Setup Development Environment

### Prerequisites
1. Java 
2. Angular
3. play framework
4. scala 

### Building this project
1. Clone your forked this repository
  ```
  git clone https://github.com/<GITHUB USE RNAME>/UOW-IIT-OOP-ASSESMENT.git
  cd UOW-IIT-OOP-ASSESMENT/premier-league-manager
  ```
2. Clean enviroment and install dependencies 
  ```
  sbt clean stage
  ```
3. Run the project
  ``` 
  cd app
  javac   CliApplication.java
  java CliApplication
  ```
