All control of this game done through the class "Game":

First of all to set a game you need to input height and width of the future map. Also max amount of enemies per room and assign the player that was created before with the constructor.

- When map is set, random amount of room is chosen and filled with random amount of items: Weapons, Poisons, Health Potions and Armors 
- All of these items have random power 
- Also, random amount of room is chosen and filled with enemies with random items (with random power) in their inventories
- Player is assigned to a random room, with also random inventory
- When it started in the main, player has options such as:
Move, Coordinates, PickUp an Item, Print Room, Drop Item, Exit.

If the user will enter "west", "east", "south" and "north", a character will move accordingly.

If it's typed "Coordinates", it will print current coordinates of the character in the map (matrix format)

A character can peek up an item from the current room. But inventory has its limitation (max 7). Also, a character can drop an item.

To finish the game you need to type "Exit"

I will continue improving this game. I want to add fighting system with enemies in the room. Mechanics of farming loots from them. Also, I want to create boss spawning mechanics, which will take the character location and will spawn the boss in the farthest room.
Also, I would like to add simple graphics, at least of the room. It will be printing image of the character, items and enemies. 