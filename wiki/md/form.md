# Register

## Context

**THE USER HAS** Clicked on the register button 

## User Story

> **AS** Maria, basic_user, 
> **I WANT TO** register my new account
> **SO THAT I CAN** log in to my account

### Loading task

 Inputs will disappear and the user will see a circular loader while creating account

### Success

Once submitted, if no business rule is violated Maria will be redirected to the client's main view: the dashboard. 

### Error

Once submitted, if any business rule is violated Maria must be warned with detailed error messages regarding which inputs are wrong, so he can fix them and submit them again.

## Functional specifications (FORM)

| Label               | Placeholder                        | Type               | Component     | Pattern                        | Dependency    | Automatic Value  |   Required |
|:-------------------|:---------------------------------:|:------------------:|:-------------------:|:---------------------------:|:-------------------:|:-----------------------:|:--------------:|
| id       |                    | Number                | ╳                  | ╳            |  ╳               |    AI                        |        ✔        |
| Username       | "username"                   | Text                | Input                 | Alpha           |   ╳                   |    ╳                         |        ✔         |
| firstname       | "John "                   | Text                | Input                 | Alpha           |  ╳               |    ╳                         |        ╳         |
| lastname       | "Doe"                   | Text                | Input                 | Alpha           |  ╳               |    ╳                         |        ╳         |
| email       | "john.doe@example.com"                   | Email               | Input                 | Alphanumeric           |  ╳             |    ╳                         |        ✔         |
| phone       | "XX-XX-XX-XX-XX "                   | Number                | Input                 | Numeric           |  ╳               |     ╳                         |        ╳         |
| password       | "*******"                   | Password                | Input                 | Alphanumeric           |  ╳                |    ╳                         |        ✔         |
| birthdate       | "JJ/MM/AAAA"                   | Date                | Date picker                 | DateTime           |  ╳              |    ╳                         |        ╳        |
