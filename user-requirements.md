# User Requirements

## What should it do?
#### Stage 1
1. Display periodic table
1. Search Function
1. Display element information once element is clicked on

#### Stage 2
1. Can change information from 'keV' to 'Angstroms'
1. Can change machine being used (JEOL L-Value to Cameca Sin-Theta-Units)

#### Stage 3
1. Display energy chart (Separate charts for separate units)
1. Select value on graph, shows elements that could be in that range


## User Needs
1. Easy to read the table and info
1. Navigatable
1. Intuitive
1. Good documentation if someone else wants to work on this after

## Host Organisation Needs
1. Be able to toggle between the 2 machines they used

## Existing System
1. No existing systems

## Security
1. Prevent SQL injection

***

# Requirements Discussed in Lab

## Stakeholders
1. Mike & colleagues - 1st point of contact
2. EMAS members - micro-analysis organization which will be the majority of our user base
3. Research students - students doing research in microbeam related field
4. Lab staff - technicians in charge of equipment etc

## Functional Requirements
1. Display the skeleton periodic table
1. Be able to change units by pressing a button
1. Show information of elements when clicked
1. Search for elements by symbol and name
1. Display basic image of energy charts - potentially an interactive version
1. System should not break

## Non-Functional Requirements
1. Be able to find an element in 10 seconds
1. Make sure text is readable half a meter away from face when user has 20/20 vision
1. User should be able to find and use the changing unit feature in under 5 seconds
1. User should not be able to access the data in any way at any point (SECURITYYYYYY)
1. Element search should be live i.e. updates as you type
1. After reading the help page of the app, user should be able to use all features of the app confidently and quickly
