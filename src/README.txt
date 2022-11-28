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


## Files
---------------------------------------------------------------------------
Data classes:
    All these classes contain some static data which is being used in the game. I used these classes 
    to hardcode the data required by the game. Most of these classes are self-explanatory.

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

    Monster data class: Contains data about different types of monsters.

        MonsterData.java
        DragonsData.java
        ExoskeletonsData.java
        SpiritsData.java

    GameStaticData.java - Contains information about the different actions and moves we can perform in the game.
                          For ex: Move options - W, A, S, D, Q, I, etc.

ActionState.java - State machine interface to maintain Hero action and Monster action

    HeroActionState.java - Responsible for all possible hero actions. Following are the concrete states of this state machine

        AttackHeroAction.java - Responsible for creating and starting the battle if a monster is nearby
        ChooseHeroAction.java - Responsible for populating all the possible actions hero can take and passing the
                                state to appropriate state on choosing an action
        ChangeItemHeroAction.java - Change Armor or weapon
        MoveHeroAction.java - Responsible for hero's movement in the map
        PotionHeroAction.java - Hero can consume a potion
        RecallHeroAction.java - Action to Recall to the nexus
        TeleportHeroAction.java - Teleports hero to another lane. One of the possible hero action

    MonsterActionState.java - This state machine is responsible for monster's actions. Monster can perform only
                                two actions - Move in tha map and Attack a nearby hero

        AttackMonsterAction - Responsible for attacking a nearby hero
        MoveMonsterAction - Responsible for moving the monster on the map. Monster can move down or to the
                            side with some probability
Game.java - Game interface. Contains setup and start game methods. Every game must implement game interface methods
GameInstruction.java - Responsible for printing out the game description and game instructions before the game start
Rounds.java - Tracking number of rounds in the game. Required for respawning new monsters.

Turn State machine classes:
    
    TurnState.java - Controls the turn of heroes and monsters. Responsible for passing the turn between hero and monster
    and also among themselves.

    Concrete states: Following classes are the concrete states of TurnState interface. These classes contain concrete
    implementation of handle turn method (handleNextTurn).

        HeroesTurn.java - Handles heroes turns. Responsible for passing the turn from H1 to H2 to H3...and so on

        MonstersTurn.java - Handles monsters turns. Responsible for passing the turn from M1 to M2 to M3...and so on

        QuitGame.java - Responsible for quitting the game

Battle.java - Battle object is used to create a battle between Hero and Monster.

Battle state machine:

    BattleState.java - Implemented mini state machine to handle turns of monster and hero. 

    Following classes represent concrete implementation of battle state

        HeroAttack.java
        MonsterAttack.java


Market.java - Implemented market using this class. It contains various weapons, armors, spells, potions etc. All the
                items that hero can buy. Also, implemented market using state machine design pattern

Market state machine:
    
    Implemented market logic using state machine. 
    
    InMarketState.java - Interface containing handle state method. All the concrete states will be an instance of this class.
    BuyingState.java - Concrete market state. Handles the buying logic in the market.
    SellingState.java - Concrete market state. Handles all the selling logic inside market.
    QuitMarket.java - Responsible for getting out of the market.


Item.java - Represent various items used in the game. Contains common property shared between all items. 

ItemInventory.java - Represents list of items

Following classes are subclasses of Item.java class. These class represents specific items in the game.
    
    Spell.java - Contains attribute specific to Spell
    Armor.java - Contains attribute specific to Armor
    Potion.java - Contains attribute specific to Potion
    Weapon.java - Contains attribute specific to Weapon

Following classes represents different types of spells. Mainly these classes vary in affected attribute 

    IceSpell.java - Affects the damage attribute of the monster
    FireSpell.java - Affects the defense attribute of the monster
    LightningSpell.java - Affects the agility attribute of the monster

TileStatic.java - Contains the utils for printing the tile with different colors
Tile.java - Tile is a basic unit on the board. The board is made up of tiles
    
    Following classes represents different types of tiles on the board. Please look at the UML diagram for
    inheritance structure of tiles

        BushTile.java
        CaveTile.java
        CommonTile.java
        InaccessibleTile.java
        KoulouTile.java
        MarketTile.java
        NexusTile.jave

Attack.java - Attack object, abstraction of the hero and monster attack

Factories in the code:

    MonsterFactory.java - Clones monsters from the stored data. Produces random monster given max level of heroes.
    TileFactory.java - Responsible for generating various tiles for the board randomly.
    HeroFactory.java - Used to initialize hero data.


Character.java - Represents a game character
Hero.java - Represents hero in our game. Extends from character class
Monster.java - Represents monster in our game. Extends from character class
Modifiable.java - Interface to modify various attributes of hero and monster
CharacterLevel.java -  Represents xp and level of a character. An abstraction of xp and level.
Gold.java - Represents gold held by the hero


Party.java - Represents group of characters. Used to represent group of heroes or group of monsters as well.
Position.java - Contains x, y coordinates corresponding to the location of our hero on the board.

LevelUpBehaviour.java - Interface for level up behaviour of our hero. Implemented using strategy pattern

Following are the concrete implementation of level up behaviours. Different types of heroes level up according to their type.

    SorcererBehaviour.java - Dexterity and agility increases when hero levels up
    PaladinBehaviour.java - Strength and dexterity increases when hero levels up
    WarriorBehaviour.java - Strength and agility increases when hero levels up


Main.java - Main java class
GameSetup.java - This class is used to set up the game
ValorRPG.java - Legends of valor game class. Contains the board, heroes, monsters and everything required to play the game

HeroAttackOptions.java - Contains list of attack options.     
MarketInventory.java - Contains list of armors, weapons, spells and potions. Used to represent market items as well
                        as hero's backpack
Utility.java - Utility class containing utility functions. Responsible for user input validation, taking inputs using
                scanner, etc

Board.java - Contains the main board, which is made up of tiles, with the functionality of printing the board

Controller.java - Contains the every action related to the movement. Abstraction of movement logic in the game

GameInstruction.java - Contain the instruction for the game

CharacterLocation.java - This class is responsible for linking the player and the board

ValidateMove.java - Validate the movement for the character


## Design Patterns implemented
---------------------------------------------------------------------------
1. Strategy design pattern:
    Hero's level up behaviour is inject in Hero using strategy pattern
    Classes:  
        LevelUpBehaviour.java
        SorcererBehaviour.java
        PaladinBehaviour.java
        WarriorBehaviour.java

2. Factory design pattern:
    A. Tile factory
        TileFactory.java

    B. Monster creation factory
        MonsterFactory.java

    C. Hero factory
        HeroFactory.java

3. State machine design pattern

    A. Turn state machine Interface - TurnState.java
    Concrete states:
        HeroesTurn.java
        MonstersTurn.java
        QuitGame.java

    B. Action state machine Interface - ActionState.java
    Child interface:
        HeroActionState.java
            Concrete states:
                AttackHeroAction.java
                ChooseHeroAction.java
                ChangeItemHeroAction.java
                MoveHeroAction.java
                PotionHeroAction.java
                RecallHeroAction.java
                TeleportHeroAction.java

        MonsterActionState.java
            Concrete states:
                AttackMonsterAction
                MoveMonsterAction

    C. Battle state machine Interface - BattleState.java
    Concrete states:
        HeroTurn.java
        MonsterTurn.java

    D. Market state machine Interface - InMarketState.java
    Classes:
        BuyingState.java
        SellingState.java
        QuitMarket.java

4. Singleton design pattern

    A. Market.java
    B. MonsterData.java
    C. MonsterFactory.java
    D. Rounds.java

## Classes carried over from previous assignments
---------------------------------------------------------------------------
Many classes are carried over from previous assignment. Some are carried over as it is and some are modified a bit
to cater to the needs of new assignment.


## Notes
---------------------------------------------------------------------------
1. Bonus: Monster can randomly move forward or to the side with some probability.
2. Notes for Grader: All the string inputs are case-insensitive.


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "CS611_Assignment_4/src" after unzipping the files
2. Run the following instructions:
javac *.java
java Main


## Input/Output Example
---------------------------------------------------------------------------

Legends of Valor is played in an 8x8 grid of spaces. The grid is divided in three lanes, each
separated by a column of impassible spaces. Each lane has a width of two spaces. Each space
can hold up to one monster and up to one hero. A space cannot hold two monsters or two
heroes.

The first two columns are the first (top) lane. The third column is a wall between the first and
the second lane. The fourth and the fifth columns are the second (middle) lane. The sixth
column is another wall. The seventh and eighth columns are the third (bottom) lane. The first
and the last row will represent a Nexus. The first row (at the top of the screen) is the monsters’
Nexus while the last row (at the bottom of the screen) is the heroes’ Nexus. See the layout
below:

                                        Blue is nexus. Can buy items and refill mana and HP.

                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.



There are some features for the game:
1. Monster will randomly move forward or to the side with some probability.
2. Tile have different functionality and can enhance different hero attributes.
The game will start in 3 seconds, enjoy!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

3




2




1





Select your party from the list of Heroes below. (Max: 3 Heroes allowed)
Warriors - Favored on Strength and Agility
No. Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
1.	H         Four_Arms        100       100       700       500       600       1354      1(7/10)
2.	H         Diamond_Head     100       600       700       800       500       2500      1(8/10)
3.	H         Cannon_Bolt      100       300       900       500       750       2546      1(6/10)
4.	H         Heat_Blast       100       200       750       650       700       2500      1(7/10)
5.	H         Shock_Rock       100       400       800       400       700       2500      1(7/10)

Sorcerers - Favored on Agility and Dexterity
No. Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
6.	H         Grey_Matter      100       1300      750       450       500       2500      1(9/10)
7.	H         Over_Flow        100       900       800       500       650       2500      1(5/10)
8.	H         Rathy            100       800       800       800       800       2500      1(8/10)
9.	H         Stink_Fly        100       900       800       700       400       2500      1(7/10)
10.	H         Upgrade          100       800       850       400       600       2500      1(6/10)

Paladins - Favored on Dexterity and Strength
No. Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
11.	H         Wild_Vine        100       300       750       650       700       2500      1(7/10)
12.	H         XLR8             100       300       750       700       700       2500      1(7/10)
13.	H         Crystal_Fist     100       250       650       600       350       2500      1(4/10)
14.	H         Boot_Leg         100       100       600       500       400       2500      1(5/10)
15.	H         Wrecking_Bolt    100       500       500       500       500       2500      1(5/10)

Enter Hero numbers(max 3) separated by space. For ex: 1 5 7
1 3 7

You have chosen the following heroes:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       500       600       1354      1(7/10)
H2        Cannon_Bolt      100       300       900       500       750       2546      1(6/10)
H3        Over_Flow        100       900       800       500       650       2500      1(5/10)


Game Board
      M1          M2          M3        Blue is nexus. Can buy items and refill mana and HP.

                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.
H1          H2          H3

H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       500       600       1354      1(7/10)

You have arrived at the Market!!
Want to go inside ?? (Y/n): n

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
      M1          M2          M3        Blue is nexus. Can buy items and refill mana and HP.

                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1                                      Green is bush. Can increase the dexterity for hero.
            H2          H3

H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       500       750       2546      1(6/10)

You have arrived at the Market!!
Want to go inside ?? (Y/n): n

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
      M1          M2          M3        Blue is nexus. Can buy items and refill mana and HP.

                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1          H2                          Green is bush. Can increase the dexterity for hero.
                        H3

H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        100       900       800       500       650       2500      1(5/10)

You have arrived at the Market!!
Want to go inside ?? (Y/n): n

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

M1 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1


Game Board
      M1          M2          M3        Blue is nexus. Can buy items and refill mana and HP.

                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1          H2          H3              Green is bush. Can increase the dexterity for hero.



M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
                  M2          M3        Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1          H2          H3              Green is bush. Can increase the dexterity for hero.



M3 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M3             Juggernaut          100            35             350            35             1


Game Board
              M2              M3        Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1          H2          H3              Green is bush. Can increase the dexterity for hero.


1 game rounds complete


Game Board
              M2          M3            Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

H1          H2          H3              Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       550       600       1354      1(7/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
              M2          M3            Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1
            H2          H3              Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       550       750       2546      1(6/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
              M2          M3            Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1          H2
                        H3              Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        100       900       800       500       715       2500      1(5/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

M1 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1


Game Board
              M2          M3            Blue is nexus. Can buy items and refill mana and HP.
      M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1          H2          H3
                                        Green is bush. Can increase the dexterity for hero.



M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
              M2          M3            Blue is nexus. Can buy items and refill mana and HP.
  M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1          H2          H3
                                        Green is bush. Can increase the dexterity for hero.


Cannot go through the wall

M3 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M3             Juggernaut          100            35             350            35             1


Game Board
                  M2      M3            Blue is nexus. Can buy items and refill mana and HP.
  M1
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1          H2          H3
                                        Green is bush. Can increase the dexterity for hero.


2 game rounds complete


Game Board
                  M2                    Blue is nexus. Can buy items and refill mana and HP.
  M1                      M3
                                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.
H1          H2          H3
                                        Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       500       600       1354      1(7/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
                  M2                    Blue is nexus. Can buy items and refill mana and HP.
  M1                      M3
                                        Gray is cave. Can increase the agility for hero.

H1                                      Red is koulou. Can increase the strength for hero.
            H2          H3
                                        Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       500       825       2546      1(6/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
                  M2                    Blue is nexus. Can buy items and refill mana and HP.
  M1                      M3
                                        Gray is cave. Can increase the agility for hero.

H1          H2                          Red is koulou. Can increase the strength for hero.
                        H3
                                        Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        100       900       880       500       650       2500      1(5/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

M1 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1


Game Board
                  M2                    Blue is nexus. Can buy items and refill mana and HP.
  M1                      M3
                                        Gray is cave. Can increase the agility for hero.

H1          H2          H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.



M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
                  M2                    Blue is nexus. Can buy items and refill mana and HP.
                          M3
  M1                                    Gray is cave. Can increase the agility for hero.

H1          H2          H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.



M3 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M3             Juggernaut          100            35             350            35             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2      M3
  M1                                    Gray is cave. Can increase the agility for hero.

H1          H2          H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


3 game rounds complete


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2
  M1                      M3            Gray is cave. Can increase the agility for hero.

H1          H2          H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       500       600       1354      1(7/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2
  M1                      M3            Gray is cave. Can increase the agility for hero.
H1
            H2          H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       550       750       2546      1(6/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2
  M1                      M3            Gray is cave. Can increase the agility for hero.
H1          H2
                        H3              Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        100       900       880       500       650       2500      1(5/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

M1 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2
  M1                      M3            Gray is cave. Can increase the agility for hero.
H1          H2          H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


You are fighting against the following:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        100       100       700       500       660       1354      1(7/10)

Juggernaut attacked  for 35 damage !

M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                  M2
  M1                      M3            Gray is cave. Can increase the agility for hero.
H1          H2          H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.



M3 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M3             Juggernaut          100            35             350            35             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1          H2          H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


You are fighting against the following:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        100       900       800       550       650       2500      1(5/10)

Juggernaut attacked  for 35 damage !
4 game rounds complete


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1          H2          H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        65        100       700       500       660       1354      1(7/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 3
You are fighting against the following:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1

Choose one of the actions:
1: Attack using Bare_Hands weapon
2: Check out heroes info
1
Four_Arms attacked using Bare_Hands for 132 damage !
M1 monster (Juggernaut) dodged the attack

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1          H2          H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       500       750       2546      1(6/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 5
Which lane you want to teleport to:
1
Which side you want to teleport to B for back N for next to another hero:
n

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        65        900       800       550       650       2500      1(5/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 3
You are fighting against the following:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M3             Juggernaut          100            35             350            35             1

Choose one of the actions:
1: Attack using Bare_Hands weapon
2: Check out heroes info
1
Over_Flow attacked using Bare_Hands for 147 damage !

M1 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


You are fighting against the following:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        65        100       700       500       660       1354      1(7/10)

Juggernaut attacked  for 35 damage !

M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1              M2      M3            Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.




Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1          M2          M3            Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


M3 monster is dead!
5 game rounds complete


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1          M2                        Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        30        100       700       500       660       1854      1(9/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 3
You are fighting against the following:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          100            35             350            35             1

Choose one of the actions:
1: Attack using Bare_Hands weapon
2: Check out heroes info
1
Four_Arms attacked using Bare_Hands for 132 damage !

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1          M2                        Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       550       750       3046      1(8/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 3
You are fighting against the following:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M1             Juggernaut          -164           35             350            35             1

Choose one of the actions:
1: Attack using Bare_Hands weapon
2: Check out heroes info
1
Cannon_Bolt attacked using Bare_Hands for 162 damage !

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1          M2                        Gray is cave. Can increase the agility for hero.
H1  H2                  H3
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        65        900       800       550       650       3000      1(7/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

  M1          M2        H3              Gray is cave. Can increase the agility for hero.
H1  H2
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


M1 monster is dead!
Hero H1 leveled up !!
6 game rounds complete


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

              M2        H3              Gray is cave. Can increase the agility for hero.
H1  H2
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        30        100       700       500       660       2354      2(11/20)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

H1            M2        H3              Gray is cave. Can increase the agility for hero.
    H2
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.


H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       550       750       3546      1(10/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 5
Which lane you want to teleport to:
2
Which side you want to teleport to B for back N for next to another hero:
b
Wrong Teleport action!! Choose again:


Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 5
Which lane you want to teleport to:
2
Which side you want to teleport to B for back N for next to another hero:
b
Wrong Teleport action!! Choose again:


Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 6

Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.

H1            M2        H3              Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.
            H2

H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        65        900       880       500       650       3500      1(9/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

M2 turn now:
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M2             Dormamu             100            35             200            10             1


Game Board
                                        Blue is nexus. Can buy items and refill mana and HP.
                        H3
H1            M2                        Gray is cave. Can increase the agility for hero.

                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.
            H2

Caution!! New monsters spawned in the Game.
Tag            Name                HP             Damage         Defense        Dodge Chance   Level
M4             Sabertooth          200            55             500            20             2
M5             Sabertooth          200            55             500            20             2
M6             Sabertooth          200            55             500            20             2

7 game rounds complete


Game Board
      M4          M5          M6        Blue is nexus. Can buy items and refill mana and HP.
                        H3
H1                                      Gray is cave. Can increase the agility for hero.
              M2
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.
            H2

H1 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H1        Four_Arms        30        100       700       550       600       2354      2(11/20)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
      M4          M5          M6        Blue is nexus. Can buy items and refill mana and HP.
H1                      H3
                                        Gray is cave. Can increase the agility for hero.
              M2
                                        Red is koulou. Can increase the strength for hero.

                                        Green is bush. Can increase the dexterity for hero.
            H2

H2 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H2        Cannon_Bolt      100       300       900       500       750       3546      1(10/10)

You have arrived at the Market!!
Want to go inside ?? (Y/n): n

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
      M4          M5          M6        Blue is nexus. Can buy items and refill mana and HP.
H1                      H3
                                        Gray is cave. Can increase the agility for hero.
              M2
                                        Red is koulou. Can increase the strength for hero.

            H2                          Green is bush. Can increase the dexterity for hero.


H3 your turn now:
Tag       Name             HP        Mana      Strength  Agility   Dexterity Money     Level
H3        Over_Flow        65        900       800       550       650       3500      1(9/10)

Choose from one of the following actions:
1. Choose a weapon or armor
2. Use a potion
3. Attack a Monster using weapon or spell (if nearby)
4. Move in the map
5. Teleport to another lane
6. Recall to base nexus
7. Stay at the same tile (Skip a turn)
8. Quit game

Enter a number: 4
Enter your move from the following:
W - To go up
A - To go left
S - To go down
D - To go right
I - To show info
Q - To quit the game
w

Game Board
      M4          M5    H3    M6        Blue is nexus. Can buy items and refill mana and HP.
H1
                                        Gray is cave. Can increase the agility for hero.
              M2
                                        Red is koulou. Can increase the strength for hero.

            H2                          Green is bush. Can increase the dexterity for hero.


Heroes won the game. Congratulations!!

