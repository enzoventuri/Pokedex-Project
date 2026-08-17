# POKÉDEX API

### This project focuses on <i>Double Programming</i>, which emphasizes on two people working on the same computer to try and learn the most amount of information as possible

### It works like such:

* The Driver: Controls the keyboard and mouse. The Driver focuses on the mechanics of writing code—syntax, formatting, implementation details, and immediate logic.
* The Navigator: Observes the Driver in real time. The Navigator focuses on the bigger picture—evaluating design patterns, catching edge cases, thinking through test cases, and planning the next steps.

# POKÉDEX - API

## Create the API (alongisde its HTTP methods)
* GET  - - /v1/pokedex - - List all Pokemons
* GET  - - /v1/pokedex/{id} - - Search Pokemon by ID
* POST - -  /v1/pokedex - - Register a new Pokemon
* PUT  - - /v1/pokedex/{id} - - Update all Pokemon data
* DELETE  - - /v1/pokedex/{id} - - Delete Pokemon by ID
* GET  - - /v1/pokedex?nome=pikachu - - List Pokemon by name
* PATCH - - /v1/pokedex/{id}/nivel - - Upgrade Pokemon by iD
* PATCH - -  /v1/pokedex/{id}/curar - - Heal Pokemon by ID
* PUT - -  /v1/pokedex/{id}/evoluir - - Evolves the Pokemon by ID
* PATCH - - /v1/pokedex/{id}/move - - Moves the selected Pokemon
* PATCH - - /v1/pokedex/{id}/faint - - Faints the Pokemon
* PATCH - - /v1/pokedex/{id}/dodge - - Makes the Pokemon dodge
* PATCH - - /v1/pokedex/{id}/flee - - Makes the Pokemon flee from battle
* PATCH - - /v1/pokedex/{id}/attack - - Makes the Pokemon take damage

## Pokemon Stats:

* ID : int
* Name : String
* Number : int
* Nickname : String
* Type : Enum
* Type2 : Enum
* Health : double
* Attack : double
* Speed : int
* Defense : double
* Classification : String

## Pokemon Methods:

* Movement
* Faint
* Dodge
* Evolve
* Level up
* Flee
* Attack

## Arena Attributes:

* ID : int,
* Name : String,
* Trainer : Enum,
* Type : Enum,
* Leader : Enum,
* Pokemons : List

## Game Methods:

* Move
* Capture
* Battle
* Buy Item
* Team
* Heal

## Example of a response:
{ \
"name": "Pikachu", \
"type": "ELECTRICITY", \
"type2": "FIRE","
"health": 100.0, \
"attack": 20.0, \
"speed": 10, \
"defense": 15.0, \
"classification": "PIKACHU - ELECTRIC MOUSE", \
"id": 1 \
}