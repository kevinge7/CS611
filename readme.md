# CS611-Project3
## Legends: Monsters and Heroes
Team: Yuxi Ge  Jingkun Lin  
yuxig5@bu.edu  jkunlin@bu.edu    
U70788037      U91747660 


## Environment
Java 8

## run
make sure use my txt file and put it under the same folder with java file
I make a few changes to txt files and my code will only works on my txt file
I put all the txt files and java files in src folder
Maybe cd to /src folder and then run the following command

javac -Xlint:deprecation Main.java
java Main.java

## how to play this game
After you run the main file. You wil be ask to enter board size and how many hero you want to take with you. Enter some numbers to get the board.
For the board, Green H means hero location. S means stone. It is inaccessible place. M means market. The hero and monster are

## Bonus:
I create color the damage value and some error messages.


## Files
#### Main.java
this is the main file of this project. This main is concise.
#### launch.java
This is the first interface of the game.
#### Armory.java
This file is to define armory properties and extend from item.java
#### ArmoryList.java
This file is to read txt file to load armory information to program.
#### Attack.java
This file is to let hero and monster attack each other.
#### cell.java
This file define each cell in the board.
#### cellFactory.java
This file creates a factory used for generation of different subtypes of cells like Nexus or Bush.
#### board.java
This file is to combine cell into a board. For this project, this file can combine as many cells as needed which depends on users input about map size.
#### Bush.java
This the properties of cell.
#### Cave.java
This the properties of cell.
#### Dodge.java
This file is to define dodge.
#### Dragon.java
This file is to define dragons properties
#### DetectedBouncesAttack.java
This file is to detected which cell hero current in and bring bounce to hero 
#### Exoskeletons.java
This file is to define Exoskeletons properties
#### generatePosition.java
this file is let hero and monster generate their position and pass the value to hero and monster itself. 
#### Herolist.java
This file is to generate hero list from the txt file
#### Heros.java
This file is to initiate hero properties
#### InputValidator.java
This file is to handle all the input and inputException.
####  Inaccessible.java
This file is define the properties of the cell and let hero know this place cannot reach
#### item.java
this is the parent class of all the items in the market
#### Koulou.java
This the properties of cell. 
#### Lane.java
This is a class to record which heroes are in this lane and to tell monsters if it can move.
#### Map.java
This is a class to generate class and let hero make movement.
#### Market.java
This is a class to let hero buy or sell item.
#### MonsterList.java
This class can read Monsters' txt files generate Monster list.
#### Monster.java
This class a parent class of all monsters
#### Paladins.java
This class is extended from Hero.java and define Paladins properties
#### Potions.java
This class is extended from item.java and define potions properties
#### PotionsList.java
This class read potion txt file and store it into potion arraylist
#### potionUsing.java
This class can let hero want to use potion and make attribute.
#### Recall.java
This class implements the recall function. 
#### Sorcerers.java
This class can define Sorcerers properties.
#### Nexus.java
This class is the properties of board. 
#### SpellList.java
This class can read spell txt and generate spell arraylist
#### Spell.java
this class define spell properties
#### Spirits.jav
This class define Spirits properties
#### Teleport.java
This class implements the function of teleporting.
#### ReBorn.java
This class can re-generate Hero and Monster if they are dead. 
#### Warriors.java
This class define Warriors properties
#### WeaponList.java
This class read from weapon file and generate weapon list
#### Weaponry.java
This file define weapon properties.

## Input/Output Example
### Please do not use readme file preview. Just read the code directly
### Formatting really hard. Thanks a lot.
Welcome to Legends of Valor!
Please select your first hero:(Answer by number)
1
Warriors Name: Gaerdal_Ironhand Warriors Strength: 700 Warriors money: 1354Warriors level: 7
2
Warriors Name: Sehanine_Monnbow Warriors Strength: 700 Warriors money: 2500Warriors level: 8
3
Warriors Name: Muamman_Duathall Warriors Strength: 900 Warriors money: 2546Warriors level: 6
4
Warriors Name: Flandal_Steelskin Warriors Strength: 750 Warriors money: 2500Warriors level: 7
5
Warriors Name: Undefeated_Yoj Warriors Strength: 800 Warriors money: 2500Warriors level: 7
6
Warriors Name: Eunoia_Cyn Warriors Strength: 700 Warriors money: 2500Warriors level: 6
7
Sorcerers Name: Rillifane_Rallathil Sorcerers Mana: 1300Sorcerers Strength: 750
8
Sorcerers Name: Segojan_Earthcaller Sorcerers Mana: 900Sorcerers Strength: 800
9
Sorcerers Name: Reign_Havoc Sorcerers Mana: 800Sorcerers Strength: 800
10
Sorcerers Name: Reverie_Ashels Sorcerers Mana: 900Sorcerers Strength: 800
11
Sorcerers Name: Kalabar Sorcerers Mana: 800Sorcerers Strength: 850
12
Sorcerers Name: Skye_Soar Sorcerers Mana: 1000Sorcerers Strength: 700
13
Paladins Name: Parzival Paladins Mana: 300Paladins Strength: 750
14
Paladins Name: Sehanine_Moonbow Paladins Mana: 300Paladins Strength: 750
15
Paladins Name: Skoraeus_Stonebones Paladins Mana: 250Paladins Strength: 650
16
Paladins Name: Garl_Glittergold Paladins Mana: 100Paladins Strength: 600
17
Paladins Name: Amaryllis_Astra Paladins Mana: 500Paladins Strength: 500
18
Paladins Name: Caliber_Heist Paladins Mana: 400Paladins Strength: 400
Input: 2
Please select your Second hero:(Answer by number)
1
Warriors Name: Gaerdal_Ironhand Warriors Strength: 700 Warriors money: 1354Warriors level: 7
2
Warriors Name: Sehanine_Monnbow Warriors Strength: 700 Warriors money: 2500Warriors level: 8
3
Warriors Name: Muamman_Duathall Warriors Strength: 900 Warriors money: 2546Warriors level: 6
4
Warriors Name: Flandal_Steelskin Warriors Strength: 750 Warriors money: 2500Warriors level: 7
5
Warriors Name: Undefeated_Yoj Warriors Strength: 800 Warriors money: 2500Warriors level: 7
6
Warriors Name: Eunoia_Cyn Warriors Strength: 700 Warriors money: 2500Warriors level: 6
7
Sorcerers Name: Rillifane_Rallathil Sorcerers Mana: 1300Sorcerers Strength: 750
8
Sorcerers Name: Segojan_Earthcaller Sorcerers Mana: 900Sorcerers Strength: 800
9
Sorcerers Name: Reign_Havoc Sorcerers Mana: 800Sorcerers Strength: 800
10
Sorcerers Name: Reverie_Ashels Sorcerers Mana: 900Sorcerers Strength: 800
11
Sorcerers Name: Kalabar Sorcerers Mana: 800Sorcerers Strength: 850
12
Sorcerers Name: Skye_Soar Sorcerers Mana: 1000Sorcerers Strength: 700
13
Paladins Name: Parzival Paladins Mana: 300Paladins Strength: 750
14
Paladins Name: Sehanine_Moonbow Paladins Mana: 300Paladins Strength: 750
15
Paladins Name: Skoraeus_Stonebones Paladins Mana: 250Paladins Strength: 650
16
Paladins Name: Garl_Glittergold Paladins Mana: 100Paladins Strength: 600
17
Paladins Name: Amaryllis_Astra Paladins Mana: 500Paladins Strength: 500
18
Paladins Name: Caliber_Heist Paladins Mana: 400Paladins Strength: 400
Input: 3
~  
~  
~  
Here is the board!
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|    M1 |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  | H1    |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H1
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 7
Monster Col: 0
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|    M1 |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  | H1    |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H2
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 7
Monster Col: 3
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |    M3 |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|    M1 |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  | H1    |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H3
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 7
Monster Col: 7
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|    M1 |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  | H1    |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H1
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 6
Monster Col: 0
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|    M1 |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  | H1    |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H2
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 6
Monster Col: 3
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |    M3 |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|    M1 |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |       |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  | H1    |  | X X X |  | H2    |  |       |  | X X X |  |       |  |       |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  | H3    |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H3
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 6
Monster Col: 7
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|    M1 |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  | H1    |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H1
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 5
Monster Col: 0
Input: w
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|    M1 |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  | H1    |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Monster is in hero attack range. Do you want to attack?
1. Yes
2. No (Answer by number)
   Input:    1
   What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input:
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite made 45 damage to Hero Sehanine_Monnbow
What kind of attack you want to make?(Answer by number)
1. Weapon Attack
2. Spell Attack
3. Potion

Input: 1
Hero Sehanine_Monnbow made 140 damage to Monster BlueEyesWhite
Monster BlueEyesWhite died!
Hero Win!

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |    M1 |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  | H1    |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

Please select a movement for H2
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• T/t: teleport
• R/r: recall to Nexus
• Q/q: quit game
• I/i: show information
Monster row: 5
Monster Col: 3
Input: r
Hero current in the market spot!
Do you want hero enter the market?
1. Yes  2. No (Answer by number)
   Input:   2
~   
~   
~  
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  | H1 M1 |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N

B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  K - K - K  I - I - I  P - P - P  C - C - C  I - I - I  K - K - K  B - B - B

C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K
|       |  |       |  | X X X |  |    M2 |  |       |  | X X X |  |       |  |    M3 |
C - C - C  P - P - P  I - I - I  P - P - P  B - B - B  I - I - I  K - K - K  K - K - K

C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  C - C - C  I - I - I  B - B - B  B - B - B  I - I - I  P - P - P  B - B - B

C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
C - C - C  K - K - K  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  C - C - C

K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
|       |  |       |  | X X X |  | H2    |  |       |  | X X X |  |       |  | H3    |
K - K - K  C - C - C  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B

B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
B - B - B  C - C - C  I - I - I  B - B - B  C - C - C  I - I - I  P - P - P  C - C - C

N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
|       |  |       |  | X X X |  |       |  |       |  | X X X |  |       |  |       |
N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Hero Win!
Game end!