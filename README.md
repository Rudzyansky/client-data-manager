## The Spring Boot ATM Application Example

A microservice multi-module project that simulates an ATM - Server communication

##### Project Structure:

* Common (DTO)
* Server
* Client (ATM)

### Data Transfer Objects

#### Card DTO

| Field  | Type  | Required | Description |
|--------|-------|----------|-------------|
| number | int64 | yes      | Card Number |
| pin    | int16 | yes      | Pin Code    |

#### Account DTO

| Field   | Type  | Required | Description    |
|---------|-------|----------|----------------|
| id      | int64 | yes      | Account Number |
| balance | int64 | yes      | Balance        |

### Server

Base URI : `http://{hostname}:9000`

##### Get Account : `POST /account/getByCard`

> Request : [Card DTO](#card-dto)
>
> Response : [Account DTO](#account-dto)
>
> Error : 403 Wrong PIN-code

##### Get Balance : `GET /account/{accountId}/getBalance`

> Parameter : int64
>
> Response : int64
>
> Error : 400 Wrong Account ID

### ATM

Base URI : `http://{hostname}:9001`

##### Get Account : `POST /account/getByCard`

> Request : [Card DTO](#card-dto)
>
> Response : [Account DTO](#account-dto)
>
> Error : 403 Wrong PIN-code

##### Get Balance : `GET /account/{accountId}/getBalance`

> Parameter : int64
>
> Response : int64
>
> Error : 400 Wrong Account ID
