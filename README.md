# Read Me First
This application stores and calculates distance between stored coordinates for 2 wheeler vehicles.


# Getting Started

## How to run the application

#### Runtime environment
This SpringBoot application requires JDK17 and Apache Maven to run

Open a terminal in project root directory and run `mvn spring-boot:run`.

Application will start on `http://localhost:8080`

#### Database
This application uses `H2(file based) database` and is stored in `./h2`

### API endpoints

This application has three categories of endpoints

1. `/admin`
    1. `/approval`: can change a request status to either `approve` or `reject`. Makes a new mentor object upon 
       `approve` status. Required `approvalStatus` and `requestId` as query parameter. `approvalStatus` can be 
       either `"approve"` or `"reject"` (case in-sensitive). `requestId` will be id of the mentor request in question.
2. `/mentorRequest`: 
    1. `/all`: returns the list of all requests that can be further processed by `/admin/approval`
       2. `/create`: creates a new request to apply to become a mentor. Expects an object of type `MentorRequest`
3. `/mentor`: 
    1. `/get/{mentor_id}`: returns the specified Mentor by id. `mentor_id` is required. 
    2. `/getAll`: return a list of all Mentors in database
    3. `/get?searchKey=<searchKey>`: returns a list of all the matches with searchKey. This match is made with 
       either job roles or name.
