# JWT Validation and Claims - Spring Boot

A small Spring Boot project for generating a JWT, validating its signature/expiration,
and reading its claims. Uses Java 17, Spring Boot 3.3.5 and JJWT 0.12.6.

## Import into Spring Tool Suite (STS)

1. Extract `JWTValidationClaims.zip`.
2. Open STS.
3. Select **File -> Import -> Maven -> Existing Maven Projects**.
4. Browse to the extracted `JWTValidationClaims` folder.
5. Select the project and click **Finish**.
6. Wait for Maven dependencies to download.
7. Right-click `JwtValidationApplication.java` -> **Run As -> Spring Boot App**.

## Test using Postman

### 1. Generate a token
- Method: `POST`
- URL: `http://localhost:8080/api/token?username=Keshava`
- No request body is required.
- Copy the `token` value from the JSON response.

### 2. Validate token and view claims
- Method: `GET`
- URL: `http://localhost:8080/api/validate`
- Header:
  - Key: `Authorization`
  - Value: `Bearer PASTE_TOKEN_HERE`

The response displays the subject (`username`), custom claims (`role`, `college`),
issued time and expiration time.

### 3. Access the protected profile endpoint
- Method: `GET`
- URL: `http://localhost:8080/api/profile`
- Use the same `Authorization: Bearer PASTE_TOKEN_HERE` header.

## Main files

- `JwtValidationApplication.java` - main Spring Boot class.
- `JwtUtil.java` - creates JWTs and validates them; extracts claims.
- `JwtController.java` - REST endpoints for token generation, validation and profile access.

## Important

This is a classroom/demo project. The hard-coded secret is only for local practice.
For a real application, keep the signing key outside source code (for example, an
environment variable or secret manager), use HTTPS, and implement proper authentication
and authorization. This demo uses a controller-level token check to keep the project
small; it does not configure a full Spring Security filter chain.
