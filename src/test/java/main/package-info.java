package main;
/**#####################
### DATASET PACKAGE ###
######################*/

/*  InitialTestDataSetup CLASS
Create and save token data for test account.
Class import test credentials from TestAccountConfig.xml file.
POST request is sent to Log In api.
Received data is saved in TestAccountDataset.xml file as:
    <TestAccountCreatedData>
        <token>
        <type>
        <id>
        <username>
        <roles>
        <balance>
    <TestAccountCreatedData>
*/

/*  TestDataDealer CLASS
Medium between TestAccountDataset.xml file and all tests.
Class read from TestAccountDataset.xml token data and save it in memory for all tests which require token to access api.
Token data is accessible via Getters.
*/

/**#########################
### CONTROLLERS PACKAGE ###
##########################*/

/*  AuthControllerTest CLASS
Performs api tests associated with /signup /login /userStatus
Goal is to verify that each of these endpoints are working as intended (verification scenarios).

registerUserTest() METHOD
    sends correct (non taken username and password) POST request to /signup endpoint.
    expected result: Account is being created. User receive message stating operation is a success.

registerExistingUserTest() METHOD
    sends already existing test user data (username) POST request to /signup endpoint.
    expected result: Account not is being created. User receive message stating username is not available.

authenticateUserTest() METHOD
    sends already existing test user data (username and password) POST request to /login endpoint.
    expected result: Login succeed, user receives token and user-data from server.
                     expected token and user-data: <token><type><id><username><roles><balance>

authenticateLoginStatusTest() METHOD
    sends already logged-in user data (username and token) in POST request to /userStatus endpoint.
    expected result: Respond from server is a success, user receives user-data from server.
                     expected user-data: <id><username><roles><balance>
*/