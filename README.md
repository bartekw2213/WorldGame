## Short Introduction :door:

**WorldGame** is a project created for my OOP classes. It's created in a pure Java :coffee: with a little bit of Swing library and is a turn-based :game_die: game. 

Every time we run the program for the first time we start with:

- a **player** :boy: ​placed on the board
-  a few **animals** :smiley_cat: (like wolfes, sheeps, turtles etc.) 
- and also several **plants** :herb: ​(like guarana, grass etc.) 

In every round each of animals move, interact with each other (breed or fight), while plants are trying to spread their seeds across the board. Each animal and plant species has their own **power**, **initiative** indicating when it can move and **unique behavior**.

<br/>
<br/>
<br/>

## Game Explanation :book:

### What if two organisms collide with each other? :boom:

If both of them are animal and each one of them is the same type then they reproduce :baby_chick:. Otherwise they fight :anger: and the organism with more power points kill another organism :skull:.

<br/>

### What are control buttons? :musical_keyboard:

- :arrow_left: Move player to the left
- :arrow_right: Move player to the right
- :arrow_up: Move player up
- :arrow_down: Move player down
- :abc: **Click S** to activate player's special power
- :pencil2: Click on free board position to select and add new organism

<br/>

### What is the order of movement? :running:

Each organism including player has it's own initiative point. Organism with more initiative points moves before other ones with less initiative points.

<br/>

### How can I know what happened in each round? :information_source:

Below the game board is space that contains logs :memo: about events from previous round - e.g "Wolf killed Player" or "New Wolf on the board"

<br/>

### Can I save my game and load it later? :floppy_disk:

Of course you can! :smile:

<br/>

### How does the player super power work? :star:

After pressing S on the keyboard, player activates his super power - he burns :fire: every organism that's near him. Super power lasts 5 rounds and user can't use it until 5 rounds will pass.

<br/>
<br/>
<br/>

##  Unique behavior of every organism :exclamation:

### Player and Animals

|    Name     | Power | Initiative |                 Action performed every round                 |               Action performed after collision               |
| :---------: | :---: | :--------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|    Human    |   5   |     4      |                    Reacts to key presses                     |        Normal fight (unless super power is turned on)        |
|    Wolf     |   9   |     5      |                   Move on random position                    |                         Normal fight                         |
|    Sheep    |   4   |     4      |                   Move on random position                    |                         Normal fight                         |
|     Fox     |   3   |     7      | Fox will never move on position occupied by stronger organism |                         Normal fight                         |
|   Turtle    |   2   |     1      |     There is 75% chance that turtle won't move in round      | Animals with less power points than 5 can't fight turtle - they need to go back on previous position |
|  Antelope   |   4   |     4      |           Antelope's range of movement is 2 fields           |    Has 50% chance to escape the fight with other organism    |
| Cyber-sheep |  11   |     4      | Cyber-sheep move towards Borsch if there is any on the board | Can eat Borsch (other animals die after contact with Borsch) |

### Plants

|  Name   | Power | Initiative |          Action performed every round          |               Action performed after collision               |
| :-----: | :---: | :--------: | :--------------------------------------------: | :----------------------------------------------------------: |
|  Grass  |   0   |     0      |           Tries to spread it's seeds           |                  Is eaten by another animal                  |
| Sonchus |   0   |     0      | Has 3 chances to spread it's seeds every round |                  Is eaten by another animal                  |
| Guarana |   0   |     0      |           Tries to spread it's seeds           |   Animal that eats Guarana gets 3 additional power points    |
| Berries |  99   |     0      |           Tries to spread it's seeds           |           Animals that eats it - dies immediately            |
| Borsch  |  10   |     0      |           Kills every nearby animals           | Animals that eats it - dies immediately (except Cyber-Sheep) |

<br/>
<br/>
<br/>

## Screenshots :camera:

![Game Screenshot](https://i.ibb.co/x1zvCt2/Zrzut-ekranu-z-2021-06-17-18-00-07.png)

![Game Screenshot](https://i.ibb.co/yVFMfFF/Zrzut-ekranu-z-2021-06-17-18-00-14.png)

![Game Screenshot](https://i.ibb.co/FB4vvGG/Zrzut-ekranu-z-2021-06-17-18-01-35.png)

![Game Screenshot](https://i.ibb.co/zngGDh4/Zrzut-ekranu-z-2021-06-17-18-01-51.png)

