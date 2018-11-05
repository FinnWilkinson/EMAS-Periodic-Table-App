# REQUIREMENTS:

## The following is a core set of the use-case goals:
1. View information on each element
1. Search for an element
1. Switch between instruments (this step also involves switching between the units based on instrument used)
1. View the energy graph

## Sequence of steps involved in achieving each goal:
* View information on each element  
  * Go through the table and find the element you want info about
  * Click on element
  * The click creates and sends an sql query
  * Data is retrieved from the database
  * Data is displayed in a suitable format

* Search for an element  
  * Click on the search icon
  * List appears with all the elements in order of increasing atomic number
  * Type into the bar the element symbol or name
  * Word is autocompleted
  * The list shows only the relevant element
  * Clicking the list item opens up the information page for that element

* Switch between instruments  
  * Option 1:
      * Open menu drawer
      * Use the toggle to switch between instruments
      
  * Option 2:
      * Click the element from the table or using the search bar
      * Use the toggle on the page to switch between instruments


4. View the energy graph
   * Open Menu drawer
   * Click on the energy graph tab
   * View the graph



_Alternative flow_ : Might switch between instruments then look for an element (this can be done using the toggle in the menu rather than on the individual element pages)  
_Exceptional flow_ : 

***

## The goal of particular interest: _Searching for an Element_
#### Atomic requirements:
* View the search bar
* Click on search bar
* List is shown
* Type element symbol or name
* The word is autocompleted
* 

#### Functional requirements:
* should autocomplete the name of element
* should show a list of he elements and should reduce the items shown as element is being typed
* 

#### Non-Functional requirements:
* The element that they are searching for is highlighted on the table (this involves animation/graphics that is not our primary aim)
* 
* 
