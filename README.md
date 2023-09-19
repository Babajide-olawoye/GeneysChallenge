# GenesysChallenge
Coding challenge

# Installation
1. JDK 8
2. Maven (latest version)

# Steps to run
1. Download project
2. Make sure youhave the correct installations on device
3. Open project root directory on Command Line
4. Run the following in CMD "mvn test"

# Test

### Test Case 1: Load Ryanir homepage
- **Test Description**: Testing the ryanair homepage url
- **Expected Output**: https://www.ryanair.com/
- **Actual Output**: https://www.ryanair.com/ie/en
  
![Capture](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/5e4c483b-107a-4c80-b4c5-91b0d9edb065)

### Test Case 2: Search for a flights
- **Test Description**: When search button is clicked, page should redirect to page with suggested flights and contains the correct details
- **Test Input**: 
  - Departure: Dublin
  - Destination: Barcelona
  - Date leaving: 20 Sept 2023
  - Date returning: 26 Sept 2023
  - Adult: 2
  - Teen: 1
  - Children: 1
- **Expected Output**: Page with suggested flights is loaded with correct dates and number of persons
- **Actual Output**:

![PassengerCount](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/d0f99b10-209c-43b7-a71a-eae2c5985b3b)
![DateTest](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/65922a05-3e44-4ab2-9943-f98986903a77)

### Test Case 3:  Select suggested flights
- **Test Description**: Once flights are choosen then  the "Log in to myRyanair” and “Passengers” section appear under selected flights; “Passengers” section is disabled
- **Test Input**:
  - Choose the first flight for both departure and arrival flight
- **Expected Output**: "Log in to myRyanair” and “Passengers” section appears
- **Actual Output**:  "Log in to myRyanair” and “Passengers” section appear

![LoginRyanSection](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/2858e884-ce78-4ce3-ac0f-6106c4c2dad5)
![PassengerSec](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/581aece5-56bd-47e0-b685-f6b88d8bbadf)

### Test Case 4: Choose “Log in later"
- **Test Description**: When we choose “Log in later", the Passengers” section becomes active
- **Expected Output**: Passengers” section becomes active
- **Actual Output**: Passengers” section became active

![ll](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/fe6968da-95b0-467f-be65-ebf5d028a9d0)


### Test Case 5: Click continue after inputting Passenger's field
- **Test Description**: Enter any valid values in fields in “Passengers” section and click continue
- **Test Input**:
- Passenger 1 = Mr. Joshua Ola
- Passenger 2 = Mrs. Joanna Ola
- Passenger 3 = Mr. Joshua Jr. Ola
- Passenger 4 = Mr. Mark Ola
- **Expected Output**: Redirect to "Where would you like to sit?” page for the first flight is loaded: https://www.ryanair.com/ie/en/trip/flights/seats
- **Actual Output**: Redirect to "Where would you like to sit?” page for the first flight is loaded: https://www.ryanair.com/ie/en/trip/flights/seats

![finalTest](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/bb52a3de-bc71-4b45-b1e0-b8113669cd7c)

### Test Case 6: Choose seats
- **Test Description**: Choose any available seats and click "Next Flight" button
- **Test Input**:
- The first four valid seat selections
- **Expected Output**: "The "Next Flight" button changes to "Continue" button, meaning the seating selection was successful.
- **Actual Output**: The "Next Flight" button changes to "Continue" button.

![Capture4](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/b9f934db-b949-4fa1-bcda-5a2ca80cb52b)   ![Capture](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/f7a6881f-2e93-487a-8177-2ee496a9f28c)

### Test Case 7: Choose seats
- **Test Description**: Choose any available seats for second flight and click continue
- **Test Input**:
- The first four valid seat selections
- **Expected Output**: "What bags are you taking on board?” page is loaded: "https://www.ryanair.com/ie/en/trip/flights/bags"
- **Actuual Output**: "What bags are you taking on board?” page is loaded: "https://www.ryanair.com/ie/en/trip/flights/bags"

![Capture2](https://github.com/Babajide-olawoye/GeneysChallenge/assets/48318533/e1296328-ad0a-4545-bdfe-cdfd0b4b8caa)
