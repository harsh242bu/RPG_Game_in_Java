# CS611 - Assignment 4
## Legends of Valor
---------------------------------------------------------------------------
Team partner 1
    Name: Harsh Khatri
    Email: harsh242@bu.edu
    BU ID: U08897332

Team partner 2
    Name: Yujie Yan
    Email: cdyyj@bu.edu
    BU ID: U13600938


Temp notes:
---------------------------------------------------------------------------
1. Since we already had CellFactoryGenerator, we crerated a new factory to generate specific cell pattern
2. 

Action State -
    ChooseAction
    MoveAction
    



## Files
---------------------------------------------------------------------------
Data classes:
    All these classes contain some static data which is being used in the game. I used these classes 
    to hardcode the data required by the game. Most of these classes are self explanatory.

    Spell data classes: Following classes contains data about different types of spells in the game        

        FireSpellsData.java
        IceSpellsData.java
        LightningSpellsData.java


    Weapon items data class: Contains armors, potions and weapons data.
        
        ArmorsData.java
        WeaponsData.java
        PotionsData.java

    Hero data classes: Contains data for different types of heroes. 

        HeroData.java
        PaladinsData.java
        SorcerersData.java
        WarriorData.java

    Cell data class: Contains information about types of cells defined in the game.

        CellData.java

    Monster data class: Contains data about different types of monsters.

        MonsterData.java
        DragonsData.java
        ExoskeletonsData.java
        SpiritsData.java

    GameMovesData.java - Contains information about the different moves possible in the game. For ex: W, A, S, D, Q, I, etc.


Game State machine classes:
    
    GameState.java - Game state machine interface. It has handle state method. Using state machine pattern to switch 
    between market and turn.

    Concrete states: Following classes are the concrete states of GameState interface. These classes contains concrete 
    implementation of handle state method. 

        MarketState.java
        MoveState.java
        QuitGame.java

Battle.java - Battle object is used to create a battle given the probability of battle.

Battle state machine:

    BattleState.java - Implemented mini state machine to handle turns of monster and hero. 

    Following classes represent concrete implementation of battle state

        HeroTurn.java
        MonsterTurn.java
        QuitBattle.java


Market.java - Implemented market using this class. It contains various weapons, armors, spells, potions etc. All the itmes that hero can buy.

Market state machine:
    
    Implemented market logic using state machine. 
    
    InMarketState.java - Interface containing handle state method. All the concrete states will be an instance of this class.
    BuyingState.java - Concrete market state. Handels the buying logic in the market. 
    SellingState.java - Concrerte market state. Handels all the selling logic inside market. 
    QuitMarket.java - Responsible for getting out of the market.


Item.java - Represent various items used in the game. Contains common property shared between all items. 

ItemInventory.java - Represents list of items

Following classes are sub classes of Item.java class. These class represents specific items in the game.
    
    Spell.java - Contains attribute specific to Spell
    Armor.java - Contains attribute specific to Armor
    Potion.java - Contains attribute specific to Potion
    Weapon.java - Contains attribute specific to Weapon

Following classes represents different types of spells. Mainly these classes vary in affected attribute 

    IceSpell.java
    FireSpell.java
    LightningSpell.java

Cell.java - Cell is a location on the board
    
    Following classes represents different types of cells/locations on the board. 

        BlockedCell.java
        CommonCell.java
        MarketCell.java

Attack.java - Attack object, abstraction of the hero and monster attack

Factories in the code:

    BalancedCellFactory.java - Responsible for producing different types of cell in balanced 20:30:50 ratio.
    MonsterFactory.java - Produces random monster given max level of heroes.
    CellFactoryCreator.java - Creates balanced cell factory. We can extend our code to create a new cell factor which generates cell randomly.
    HeroFactory.java - Used to initialize hero data.


Character.java - Represents a game character
Hero.java - Represents hero in our game. Extends from character class
Monster.java - Represents monster in our game. Extends from character class
Modifiable.java - Interface to modify variuos attributes of hero and monster
CharacterLevel.java -  Represents xp and level of a character. An abstraction of xp and level.
Gold.java - Represents gold held by the hero


Piece.java - Represents a piece placed on the cell on our game board

Following are the types of pieces:

    EmptyPiece.java
    PartyPiece.java

Party.java - represents group of characters. Can be used to represents group of heroes or group of monsters as well. 
Location.java - Contains x, y coordinates corresponding to the location of our hero on the board.

LevelUpBehaviour.java - Interface for level up behaviour of our hero. Implemented using strategy pattern

Following are the concrete implimentation of level up behaviours. Different types of heroes level up according to their type.

    SorcererBehaviour.java
    PaladinBehaviour.java
    WarriorBehaviour.java


Main.java - Main java class
GameBoard.java - Represents board
GameSetup.java - This class is used to setup the game
LegendsRPG.java - Legends and monsters game class

HeroAttackOptions.java - Contains list of attack options.     
MarketInventory.java - Contains list of armors, weapons, spells and potions. Used to represent market items as well as hero backpack
Utility.java - Utility class containing utility functions

Board.java contains the main board with the functionality of printing the board

BushTile.java, CaveTile.java, KoulouTile.java conatins different tiles to enhance the ability for the hero

Controller.java contains the every action related to the movement

GameInstruction.java contain the instruction for the game

CharacterLocation.java link the player and the board

Position.java contains the position object

TileStatic.java contains the utils for printing the tile with different color

ValidateMove.java validate the movement for the character





## Design Patterns implemented
---------------------------------------------------------------------------
1. Strategy pattern:
    Hero's level up behaviour is inject in Hero using strategy pattern
    Classes:  
        LevelUpBehaviour.java
        SorcererBehaviour.java
        PaladinBehaviour.java
        WarriorBehaviour.java

2. Factory pattern:
    A. Cell factory
    Classes:
        CellFactoryCreator.java
        BalancedCellFactory.java

    B. Monster creation factory
        MonsterFactory.java

3. State machine pattern
    A. Game state machine
    Classes:
        GameState.java
        MarketState.java
        MoveState.java
        QuitGame.java

    B. Battle state machine
    Classes:
        BattleState.java
        HeroTurn.java
        MonsterTurn.java
        QuitBattle.java

    C. Market state machine
    Classes:
        InMarketState.java
        BuyingState.java
        SellingState.java
        QuitMarket.java


## Classes carried over from previous assignments
---------------------------------------------------------------------------
Piece.java
Cell.java
GameBoard.java


## Notes
---------------------------------------------------------------------------
1. Bonus: You can choose team of multiple heores (max 3 heroes) to fight in the game. Each hero attack one monster.
            Multiple heroes fight multiple monsters.
2. Notes for Grader: All the string inputs are case insensitive. 


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "CS611_Assignment_3_U08897332/src" after unzipping the files
2. Run the following instructions:
javac *.java
java Main


## Input/Output Example
---------------------------------------------------------------------------

Your party moved to location: X = 0, Y = 0

Select your party from the list of Heroes below. (Max: 1 Heroes allowed)
Warriors - Favored on Strength and Agility
Name            Mana    Strength    Agility Dexterity   Starting money  Starting experience
1. Four_Arms    100 700 500 600 1354    7   
2. Diamond_Head 600 700 800 500 2500    8   
3. Cannon_Bolt  300 900 500 750 2546    6   
4. Heat_Blast   200 750 650 700 2500    7   
5. Shock_Rock   400 800 400 700 2500    7   

Sorcerers - Favored on Agility and Dexterity
Name            Mana    Strength    Agility Dexterity   Starting money  Starting experience
6. Grey_Matter  1300    750 450 500 2500    9   
7. Over_Flow    900 800 500 650 2500    5   
8. Rath 800 800 800 800 2500    8   
9. Stink_Fly    900 800 700 400 2500    7   
10. Upgrade 800 850 400 600 2500    6   

Paladins - Favored on Dexterity and Strength
Name            Mana    Strength    Agility Dexterity   Starting money  Starting experience
11. Wild_Vine   300 750 650 700 2500    7   
12. XLR8    300 750 700 700 2500    7   
13. Crystal_Fist    250 650 600 350 2500    4   
14. Boot_Leg    100 600 500 400 2500    5   
15. Wrecking_Bolt   500 500 500 500 2500    5   

Enter Hero numbers(max 1) separated by space. For ex: 1 5 7
5
Your party is spawned at location: X = 0, Y = 0

You have chosen the following heroes:
Name            Mana    Strength    Agility Dexterity   Starting money  Starting experience
Shock_Rock  400 800 400 700 2500    7   
+-----+-----+-----+-----+-----+-----+-----+-----+
|  X  |  B  |  B  |     |  M  |     |  M  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  B  |     |  M  |  B  |  M  |  B  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  M  |     |  M  |     |     |  B  |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  B  |     |  B  |  M  |  B  |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |     |     |  M  |     |     |  M  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  B  |  M  |     |  B  |  B  |     |  B  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |     |     |     |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  B  |     |     |  M  |  B  |     |     |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
Enter your move from the following:
w - To go up
a - To go left
s - To go down
d - To go right
i - To show info
q - To quit the game
s
Your party moved to location: X = 1, Y = 0
Monsters have arrived!!
You are fighting against the following monsters:
Name            Level   Damage  Defense Dodge chance
Juggernaut  1   35  350 35  

Hero turn now ---
Choose one of the actions:
1. Attack using Bare_Hands weapon
6. Check out heroes info
1
Shock_Rock attacked using Bare_Hands for 180 damage !

Monster turn now ---
Name            Level   Damage  Defense Dodge chance
Juggernaut  1   35  301 35  
Juggernaut attacked  for 35 damage !

Hero turn now ---
Choose one of the actions:
1. Attack using Bare_Hands weapon
6. Check out heroes info
1
Shock_Rock attacked using Bare_Hands for 180 damage !
Juggernaut dodged the attack

Monster turn now ---
Name            Level   Damage  Defense Dodge chance
Juggernaut  1   35  301 35  
Juggernaut attacked  for 35 damage !
Shock_Rock dodged the attack

Hero turn now ---
Choose one of the actions:
1. Attack using Bare_Hands weapon
6. Check out heroes info
1
Shock_Rock attacked using Bare_Hands for 180 damage !
Juggernaut dodged the attack

Monster turn now ---
Name            Level   Damage  Defense Dodge chance
Juggernaut  1   35  301 35  
Juggernaut attacked  for 35 damage !

Hero turn now ---
Choose one of the actions:
1. Attack using Bare_Hands weapon
6. Check out heroes info
1
Shock_Rock attacked using Bare_Hands for 180 damage !
Juggernaut dodged the attack

Monster turn now ---
Name            Level   Damage  Defense Dodge chance
Juggernaut  1   35  301 35  
Juggernaut attacked  for 35 damage !
Quitting the battle ---
All heroes died. Quitting game now...
Game Over!! Thank you for playing

Process finished with exit code 0
