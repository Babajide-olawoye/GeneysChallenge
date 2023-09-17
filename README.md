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

### Test Case 2: Search for a flights
- **Test Description**: Testing the ryanair homepage url
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

### Test Case 3:  Select suggested flights
- **Test Description**: Once flights are choosen then  the "Log in to myRyanair” and “Passengers” section appear under selected flights; “Passengers” section is disabled
- **Test Input**:
  - Choose the first flight for both departure and arrival flight
- **Expected Output**: "Log in to myRyanair” and “Passengers” section appears
- **Actual Output**:  "Log in to myRyanair” and “Passengers” section appear

### Test Case 4: Choose “Log in later"
- **Test Description**: When we choose “Log in later", the Passengers” section becomes active
- **Expected Output**: Passengers” section becomes active
- **Actual Output**: Passengers” section became active

### Test Case 5: Click continue after inputting Passenger's field
- **Test Description**: Enter any valid values in fields in “Passengers” section and click continue
- **Test Input**:
- Passenger 1 = Mr. Joshua Ola
- Passenger 2 = Mrs. Joanna Ola
- Passenger 3 = Mr. Joshua Jr. Ola
- Passenger 4 = Mr. Mark Ola
- **Expected Output**: Redirect to "Where would you like to sit?” page for the first flight is loaded
- **Actual Output**: Redirect to "Where would you like to sit?” page for the first flight is loaded

### Test Case 6: Choose seats
- **Test Description**: Choose any available seats 
- **Expected Output**: "Where would you like to sit?” page for the second flight is loaded

### Test Case 7: Choose seats
- **Test Description**: Choose any available seats for second flight and click continue
- **Expected Output**: "What bags are you taking on board?” page is loaded

