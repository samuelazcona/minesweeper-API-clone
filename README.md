# NOTES FROM SAMUEL AZCONA
- RESTful API for realtime game? really? principle of RESTful is to DONT be stateless this game require to save state i think maybe its best to instead of be RESTful this need to have a Socket or GRPC solution for the communication layer, also use database resource for all moves and actions from the user its not a good option, all this need moves and in game data need to be managed by the UI/APP/WEB and this only need to store the state of the game in the backend to save it or resume letter.

- If wee need to use a databse, use a Relational Databese need a crazy relations of all squares so its best to use a non relational database like mongo to store only the document state of the game, so its more easy to resume from the pause state for example.
- i only complete basics example code in 5 hours, so this its not finish, but its usable you can up the app and try to create new game from swagger UI

# HOW TO DEPLOY
- build with mvn clean package
- java -jar target/minesweeper-0.0.1-SNAPSHOT.jar


# minesweeper-API
API test

We ask that you complete the following challenge to evaluate your development skills. Please use the programming language and framework discussed during your interview to accomplish the following task.

## The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

## Show your work

1.  Create a Public repository ( please dont make a pull request, clone the private repository and create a new plublic one on your profile)
2.  Commit each step of your process so we can follow your thought process.

## What to build
The following is a list of items (prioritized from most important to least important) we wish to see:
* Design and implement  a documented RESTful API for the game (think of a mobile app for your API)
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
* Ability to 'flag' a cell with a question mark or red flag
* Detect when game is over
* Persistence
* Time tracking
* Ability to start a new game and preserve/resume the old ones
* Ability to select the game parameters: number of rows, columns, and mines
* Ability to support multiple users/accounts
 
## Deliverables we expect:
* URL where the game can be accessed and played (use any platform of your preference: heroku.com, aws.amazon.com, etc)
* Code in a public Github repo
* README file with the decisions taken and important notes

## Time Spent
You do not need to fully complete the challenge. We suggest not to spend more than 5 hours total, which can be done over the course of 2 days.  Please make commits as often as possible so we can see the time you spent and please do not make one commit.  We will evaluate the code and time spent.
 
What we want to see is how well you handle yourself given the time you spend on the problem, how you think, and how you prioritize when time is insufficient to solve everything.

Please email your solution as soon as you have completed the challenge or the time is up.
