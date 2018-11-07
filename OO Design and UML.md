# OO Design and UML
#### Static UML diagram:
![alt text](https://bitbucket.org/MasterFinnius/periodic-table-app/raw/UML/UMLpictures/StaticUML.png "Static UML Diagram")
   
This diagram shows the relationships between the classes needed for the user to search for a specific element within the app.

Our motivation for modelling this aspect of the system was the fact that it is the most complex part of the app from a technical point of view. This is mainly due to the fact that we will be using a database to hold the specific information about each element, and at some point we will need to retrieve this data and display it for the user.

There was also some uncertainty about how the _'Search_ _ _Activity'_, _'Current_ _ _Element'_, and _'Element_ _ _View'_ will interact with each other, and specifically where the SQL fetch request will be sent from. Drawing up the static UML diagram helped us to visualise the working of the system, and decide that the most logical place for the database to be accessed from would be the  _'Element_ _ _View'_ class. This decision was based on the fact that both other classes mentioned above interact with  _'Element_ _ _View'_, but also the fact that as it will be the activity where the fetched data is displayed for the user.  

Modelling the search aspect using a static UML diagram allowed us to see the relationships between each class, and also makes us think about the methods and variables needed for each class. Additionally, having represented this part of our system visually allows us to convey how we have designed our classes to interact with each other much easier, improving communication within the team.  
Making our static UML diagram has shown us how many classes are required to make an efficient system, also allowing us to have an insight onto how we may split up the workload between our team when coding the application.  


#### Dynamic UML diagram:
![alt text](https://bitbucket.org/MasterFinnius/periodic-table-app/raw/UML/UMLpictures/DynamicUML.png "Dynamic UML Diagram")

  j
