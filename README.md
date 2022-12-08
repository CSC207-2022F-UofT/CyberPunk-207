# CyberPunk207

Welcome to Night City....

<img width="1439" alt="image" src="https://user-images.githubusercontent.com/105243930/205428299-ffaf8462-70fa-4a22-8584-bc09986ce6d4.png">


Cyberpunk 207 is a turned-base tabletop card game. In the game, five players will take on different identities, divided into three camps (police, criminals, and corpo) to advance towards their respective goals. Here are their winning objectives:

Police Chief: Death of Criminal and Corpo.

Police: Help Police Chief to achieve his goals

Corpo: Death of other characters

Criminal: Death of Police Chief and Police


## Running
Run the GameLauncher class located in the directory

## Basic Rules

Each character has 4 life points, the police chief has 5 life points, and the character dies when life goes to zero. Police die if the police chief dies. Before the game starts, every player is assigned their camps and draws 4 cards from the deck in hands for future use. The police chief must immediately show his/her identity with the other players remaining hidden until they die. Then the game plays clockwise. At the beginning of each player’s turn, they draw 2 cards from the deck. Each player can attack other players using different cards to decrease enemies' life, and players can also use the corresponding cards for defence. Each player can only attack one adjacent player without a weapon card or mount card equipped. Equipping a weapon card or mount card can increase or decrease the player's distance from other players (+1 distance means the player's attack range increases by one on each side). Different skill cards also have different distances for use. The game design will be based on the background of the world of Cyberpunk 2077 and expand somewhat, aiming to let people know more about the cyber world.

## UI
* LoginPage - 1st page for login and register
* RulePage - 2nd page displaying rules
* GamePage - 3rd page where the primary game is displayed (you can see information on yourself and other players to play the game)

## Changes after Milestone 4
- Updated Clean Architecture structure in project, restructured the program into 7 unique use cases and created individual controllers, presenters and interfaces for each of them
- Connected use case with front end UI following clean architecture	rules
- Updated GitHub usage with commenting and review for new pull requests
- Updated readme file for the project
- Updated testing for entity, use cases and UI
- Updated documentation for all codes and corrected naming conventions for all classes
- Corrected bugs and errors that effected functionality of the program

## Design patterns used
* Factory design pattern used in the implementation of [cards](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/main/java/entity/Card)
* Observer design pattern used in [updating game board information](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/main/java/UseCase/GlobalStatus) for the game
* Singleton design pattern used in view models in all [use cases](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/main/java/UseCase) of the project

## Clean architecture
* We follow clean architecture model for all use cases in our project
* All seven use cases interacts with UI through their individual presenter and controllers, boundaries are also implemented to prevent dependency across layers
* Response and request models are implemented to contain information of the game
* [Login system](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/main/java/UseCase/Login) also used serialization to interact with local database that stores login information

## Testing coverage
* Test coverage includes most [card entity](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/test/java/entities) to ensure their individual functionality
* Also tested all seven [use cases](https://github.com/CSC207-2022F-UofT/course-project-group-148/tree/main/src/test/java/UseCase) to ensure their normal functionality within the game

## Documentations
- [CRC cards](https://docs.google.com/presentation/d/1NDSY8ECLeGjmG_CDGjaI0u4tHIRhg0pL5_blFVvRGxs/edit#slide=id.g14c536dc64b_0_40)
- [Help Guide](https://docs.google.com/document/d/1plI87RyJ0jCMYeijyiLynWOV64fhWfKZ8fg5gIbjFcQ/edit?usp=sharing)
- [Project Blueprint](https://docs.google.com/document/d/138I455XzOeydqokah_ssoD2i4f0X__615q7Ek8vThH8/edit#heading=h.gcegl3vlg4sp)
- [Specification](https://docs.google.com/document/d/1RyoYvM5jh8z5xX-V-DCh5hZdcybpxFl1AdSeoPYMer8/edit?usp=sharing)
- [Scenario Walk-Through](https://docs.google.com/presentation/d/1NDSY8ECLeGjmG_CDGjaI0u4tHIRhg0pL5_blFVvRGxs/edit#slide=id.g14c1f896a82_0_0)
- [Design document]()