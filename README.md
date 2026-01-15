# Hytale Plugin Study Template

This repository serves as a practical study material for learning how to develop plugins and custom content for Hytale servers. It provides a foundational structure to explore the Java API and the game's data-driven content system.

## 🚀 Purpose
The goal of this project is to demonstrate:
- **Plugin Lifecycle:** Understanding how a `JavaPlugin` is initialized and managed.
- **Event Handling:** Learning how to register and respond to server-side events (e.g., player connections).
- **Custom Content:** Experimenting with the creation of new blocks, items, and textures using JSON definitions and the Hytale resource system.
- **Project Structure:** Familiarizing with the standard directory layout for Hytale development.

## 📂 Project Structure
- `src/main/java`: Contains the Java source code for the plugin logic and event listeners.
- `src/main/resources/Common`: Stores shared assets like block models (`.blockymodel`), textures, and UI icons.
- `src/main/resources/Server`: Contains server-side data definitions, such as item behaviors in JSON and localization files.
- `src/main/resources/manifest.json`: The essential metadata file for identifying the plugin.

## 🛠️ Getting Started
1. **Clone the repository:** A useful starting point for your own experiments.
2. **Explore the Code:** Check `ExamplePlugin.java` to see how the setup process works.
3. **Modify Content:** Try editing `newBlock.json` or adding new textures to see how the game handles custom data.
4. **Build:** Use the provided Gradle wrapper (`./gradlew build`) to compile your changes.

## 📖 Learning Notes
- **Events:** The `ExampleEvent` class is a great place to practice handling different game triggers.
- **JSON Definitions:** Notice how the `Server/Item/Items` directory links visual assets to in-game properties like stacking and categories.
- **Localization:** Check `en-US/Items.lang` to see how human-readable names are mapped to internal IDs.
