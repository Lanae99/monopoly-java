# monopoly-java
Java implementation of Monopoly board game with Swing GUI - High school project (2023)

## Features

- **Complete Game Board**: All 40 spaces including properties, stations, utilities, and special tiles
- **4-Player Support**: Multiplayer gameplay for up to 4 players
- **Property Management**: Buy, own, and build houses/hotels on properties
- **Chance & Community Chest**: Full implementation of Probabilità (Chance) and Imprevisti (Community Chest) cards
- **Rent System**: Dynamic rent calculation based on property development level
- **Special Tiles**: 
  - GO (Via) - Collect 200$ when passing
  - Jail (Prigione) - Stay for up to 3 turns
  - Parking, Taxes, and Utilities
- **Building System**: Progressive house and hotel construction on properties
- **Player Elimination**: Bankruptcy handling when players run out of money
- **Visual Feedback**: Color-coded properties and player positions

## Technologies Used

- **Java**: Core game logic and implementation
- **Swing**: GUI framework for interface
- **GridBagLayout**: Advanced layout management for the game board
- **Object-Oriented Design**: Modular architecture with separate classes for cells, players, and game logic

## Project Structure

```
com.mycompany.monopoly/
├── MONOPOLY.java        # Main game controller and event handling
├── Cella.java            # Cell/tile class representing board spaces
├── Giocatore.java        # Player class managing player state and actions
└── Probabilità.java      # Probability/Chance card handler
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any Java IDE (NetBeans, IntelliJ IDEA, Eclipse) or command line

### Running the Game

1. Clone the repository:
```bash
git clone https://github.com/Lanae99/monopoly-java.git
cd monopoly-java
```

2. Compile the project:
```bash
javac -d bin src/com/mycompany/monopoly/*.java
```

3. Run the game:
```bash
java -cp bin com.mycompany.monopoly.MONOPOLY
```

Or simply open the project in your IDE and run `MONOPOLY.java`

## Gameplay

1. **Starting the Game**: The game launches with all 4 players starting at GO
2. **Taking Turns**: Click "Gioca giocatore" button to roll dice and move
3. **Buying Properties**: When landing on an available property, choose to buy or pass
4. **Building Houses**: Land on your own property to purchase houses (max 4) or a hotel
5. **Paying Rent**: Landing on opponents' properties triggers automatic rent payment
6. **Special Cards**: Landing on Probabilità or Imprevisti spaces draws random cards
7. **Winning**: Last player remaining after others go bankrupt wins

## Game Rules Implemented

- Players start with 1500$ each
- Passing GO awards 200$
- Dice roll range: 2-12
- Properties can be developed with up to 4 houses, then 1 hotel
- Rent increases with each house built
- Station rent depends on total stations owned (1-4)
- Utility rent is 4x or 10x dice roll based on ownership
- Jail: Stay for 3 turns maximum
- Bankruptcy: Players with negative balance are eliminated

## Key Classes

### MONOPOLY (Main Game Controller)
- Manages game state and turn progression
- Handles all player actions and events
- Controls dice rolls and card draws
- Processes property transactions

### Cella (Board Cell)
- Represents individual board spaces
- Stores property information (price, rent, color group)
- Manages visual representation
- Tracks ownership and building status

### Giocatore (Player)
- Maintains player state (money, position, properties)
- Handles purchase decisions via UI prompts
- Tracks owned properties and jail status

## Design Patterns Used

- **MVC Pattern**: Separation of game logic, UI, and data
- **Observer Pattern**: ActionListener implementation for event handling
- **Factory Pattern**: Dynamic cell creation with multiple constructors

## Assets & Legal Notice

This project was created for **educational purposes only** as part of a programming portfolio.

All visual assets used in this project are:
- Custom-created using Java Swing components
- Simple color-coded representations
- Icon placeholders from standard resources

**Legal Disclaimer**: This is NOT affiliated with or endorsed by Hasbro, Inc. Monopoly® is a registered trademark of Hasbro, Inc. This implementation is a non-commercial educational project demonstrating object-oriented programming concepts in Java.

## Project Context

This project was developed during my **fourth year of high school** (2023) as a school assignment to demonstrate Object-Oriented Programming concepts and GUI development skills in Java.

While the codebase uses Italian variable names and comments (reflecting the academic context), the project showcases:
- Understanding of complex game logic implementation
- Ability to manage state across multiple interacting components
- GUI design with Swing framework
- Event-driven programming patterns

## Technical Skills Demonstrated

- **Object-Oriented Design**: Multiple classes with clear responsibilities and inheritance
- **Event Handling**: Comprehensive ActionListener implementation for user interactions
- **GUI Development**: Complex GridBagLayout management for dynamic board positioning
- **Game State Management**: Turn-based logic, player elimination, property ownership tracking
- **Data Structures**: ArrayList usage for dynamic property collections
- **Conditional Logic**: Extensive rule implementation for different game scenarios

## Reflections & Learning Outcomes

Building this Monopoly implementation taught me valuable lessons about:
- Managing complexity in larger codebases
- Debugging interactions between multiple components
- Planning class architecture before implementation
- Balancing functionality with code maintainability

If I were to rebuild this project today, I would refactor with English naming conventions, implement the Model-View-Controller pattern more strictly, and add unit tests for game logic validation.

## Author

Developed as a high school computer science project (2023). Now maintained as part of my programming portfolio while pursuing my Computer Science degree.

## License

This project is released under the MIT License for educational purposes only. The Monopoly game concept and trademark are property of Hasbro, Inc.
