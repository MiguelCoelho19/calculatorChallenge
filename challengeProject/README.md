Prerequisites
    Ensure the following are installed:
        Java Development Kit (JDK) 17+
        Apache Maven
        Docker
        Docker Compose
    Use the following commands to verify if tools are installed: 
        java -version
        mvn -version
        docker --version
        docker-compose --version

Use the following command to clone project repository:
    git clone https://github.com/MiguelCoelho19/calculatorChallenge.git

Use the following commands to Build and Run the project:
    cd calculatorChallenge\challengeProject
    mvn clean install
    docker-compose build
    docker-compose up

Use the following command to run the unit tests:
    mvn test

Test the project manually using the following examples:
    http://localhost:8080/calculator/addition?a=1&b=2&precision=1
    http://localhost:8080/calculator/subtraction?a=2&b=3.5&precision=1
    http://localhost:8080/calculator/multiplication?a=-2&b=3&precision=1
    http://localhost:8080/calculator/division?a=2&b=3&precision=5

To test different cases, replace the operation and values in the following formats:
    'http://localhost:8080/calculator/' + [operation] + '?a=' + [value] + '&b=' + [value]
    'http://localhost:8080/calculator/' + [operation] + '?a=' + [value] + '&b=' + [value] + '&precision=' + [p-int]
    operation can be: 'addition', 'subtraction', 'multiplication' or 'division'
    value must be a number, it can be negative and have decimals
    p-int must be a number, it can't be negative or have decimals
