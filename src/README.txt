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
        MoveHeroAction.java - Responsible for moving in the map
        PotionHeroAction.java - Hero can consume a potion
        RecallHeroAction.java - Action to Recall to the nexus
        TeleportHeroAction.java - Teleport action

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
Piece.java
Cell.java
GameBoard.java


## Notes
---------------------------------------------------------------------------
1. Bonus: Monster can randomly move forward or to the side with some probability.
2. Notes for Grader: All the string inputs are case-insensitive.


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "CS611_Assignment_3_U08897332/src" after unzipping the files
2. Run the following instructions:
javac *.java
java Main


## Input/Output Example
---------------------------------------------------------------------------

