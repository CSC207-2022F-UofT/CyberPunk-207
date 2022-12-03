# CyberPunk207

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


## Design patterns used
* Factory design pattern used in the implementation of cards
* Observer design pattern

## Clean architecture
* 

## Testing coverage
