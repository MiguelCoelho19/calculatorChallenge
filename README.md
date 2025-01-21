# Prerequisites

Ensure the following are installed:

- **Java Development Kit (JDK) 17+**
- **Apache Maven**
- **Docker**
- **Docker Compose**

Use the following commands to verify if tools are installed:

```bash
java -version
mvn -version
docker --version
docker-compose --version
```

# Clone the Project Repository

Use the following command to clone the project repository:

```bash
git clone https://github.com/MiguelCoelho19/calculatorChallenge.git
```

# Build and Run the Project

Use the following commands to build and run the project:

```bash
cd calculatorChallenge/challengeProject
mvn clean install
docker-compose build
docker-compose up
```

# Run Unit Tests

Use the following command to run the unit tests:

```bash
mvn test
```

# Manual Testing

Test the project manually using the following examples:

- [http://localhost:8080/calculator/addition?a=1&b=2&precision=1](http://localhost:8080/calculator/addition?a=1&b=2&precision=1)
- [http://localhost:8080/calculator/subtraction?a=2&b=3.5&precision=1](http://localhost:8080/calculator/subtraction?a=2&b=3.5&precision=1)
- [http://localhost:8080/calculator/multiplication?a=-2&b=3&precision=1](http://localhost:8080/calculator/multiplication?a=-2&b=3&precision=1)
- [http://localhost:8080/calculator/division?a=2&b=3&precision=5](http://localhost:8080/calculator/division?a=2&b=3&precision=5)

# Custom Testing

To test different cases, replace the operation and values in the following format:

```plaintext
http://localhost:8080/calculator/ + [operation] + '?' + 'a=' + [value-a] + '&' + 'b=' + [value-b] + '&' + 'precision=' + [p-int]
```

- **operation** can be: `addition`, `subtraction`, `multiplication`, or `division`.
- **value-a** and **value-b** must be numbers (they can be negative and have decimals).
- **p-int** must be a number (it can't be negative or have decimals).

### Default Values

`value-a`, `value-b`, and `p-int` have default values (`1`, `2`, and `2` respectively). This makes the following examples valid as well:

- [http://localhost:8080/calculator/addition](http://localhost:8080/calculator/addition)
- [http://localhost:8080/calculator/subtraction?b=4](http://localhost:8080/calculator/subtraction?b=4)
- [http://localhost:8080/calculator/multiplication?precision=2&b=4](http://localhost:8080/calculator/multiplication?precision=2&b=4)
