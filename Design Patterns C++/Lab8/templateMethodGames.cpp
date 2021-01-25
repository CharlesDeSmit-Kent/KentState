// Games, Template Method example
// Mikhail Nesterenko
// 2/4/2014
// Modified by Charles DeSmit
// 10/28/2020

#include <ctime>
#include <cstdlib>
#include <iostream>

using std::cout; using std::endl;
using std::string;

// template for any game where players take 
// turns to make moves
// and there is a winner
class Game {
public:
    Game() :playersCount_(0), movesCount_(0), playerWon_(noWinner) {}

    // template method
    void playGame(const int playersCount = 0) {
        playersCount_ = playersCount;
        movesCount_ = 0;

        initializeGame();

        for (int i = 0; !endOfGame(); i = (i + 1) % playersCount_) {
            makeMove(i);
            if (i == playersCount_ - 1)
                ++movesCount_;
        }
        printWinner();
    }

    virtual ~Game() {}

protected:
    // primitive operations
    virtual void initializeGame() = 0;
    virtual void makeMove(int player) = 0;
    virtual void printWinner() = 0;
    virtual bool endOfGame() { return playerWon_ != noWinner; } // this is a hook
                    // returns true if winner is decided
    static const int noWinner = -1;

    int playersCount_;
    int movesCount_;
    int playerWon_;
};

// Monopoly - a concrete game implementing primitive 
// operations for the template method
class Monopoly : public Game {
public:
    // implementing concrete methods
    void initializeGame() {
        playersCount_ = rand() % numPlayers_ + 1; // initialize players
    }

    void makeMove(int player) {
        if (movesCount_ > minMoves_) {
            const int chance = minMoves_ + rand() % (maxMoves_ - minMoves_);
            if (chance < movesCount_) playerWon_ = player;
        }
    }

    void printWinner() {
        cout << "Monopoly, player " << playerWon_ << " won in "
            << movesCount_ << " moves." << endl;
    }

private:
    static const int numPlayers_ = 8; // max number of players
    static const int minMoves_ = 20; // nobody wins before minMoves_
    static const int maxMoves_ = 200; // somebody wins before maxMoves_
};

// Chess - another game implementing
// primitive operations
class Chess : public Game {
public:
    void initializeGame() {
        playersCount_ = numPlayers_; // initalize players
        for (int i = 0; i < numPlayers_; ++i)
            experience_[i] = rand() % maxExperience_ + 1;
    }

    void makeMove(int player) {
        if (movesCount_ > minMoves_) {
            const int chance = (rand() % maxMoves_) / experience_[player];
            if (chance < movesCount_) playerWon_ = player;
        }
    }

    void printWinner() {
        cout << "Chess, player " << playerWon_
            << " with experience " << experience_[playerWon_]
            << " won in " << movesCount_ << " moves over"
            << " player with experience " << experience_[playerWon_ == 0 ? 1 : 0]
            << endl;
    }

private:
    static const int numPlayers_ = 2;
    static const int minMoves_ = 2; // nobody wins before minMoves_
    static const int maxMoves_ = 100; // somebody wins before maxMoves_
    static const int maxExperience_ = 3; // player's experience
                               // the higher, the greater probability of winning
    int experience_[numPlayers_];
};

class Dice : public Game {
public:
    void initializeGame() {
        playersCount_ = 1;
        playerTot_ = 0;
        compTot_ = 0;
        playerDone_ = false;
        compDone_ = false;
    }

    void makeMove(int player) {

        // roll dice
        if (!compDone_)
            rollDice("Computer", compTot_);
        else
            cout << "Computer passed. Highest Score: " << compTot_ << endl;
        if (!playerDone_) 
            rollDice("Player", playerTot_);
        else
            cout << "You passed. Highest Score: " << playerTot_ << endl;

        // Check if player passed and if cpu will pass
        if ((!playerDone_) && ((movesCount_ + 2) <= maxMoves_)){
            cout << "Roll again? [y/n] ";
            std::cin >> pass_;
        }
        if ((pass_ == 'n') || (pass_ == 'N')) playerDone_ = true;
        if (compTot_ > playerTot_) {
            int chance = rand() % maxMoves_;
            if (chance <= movesCount_)
                compDone_ = true;
        }
        // Check if the game is over and who won
        if ((compDone_ && playerDone_) || ((movesCount_+1) == maxMoves_)) {
            if (compTot_ >= playerTot_)
                playerWon_ = 0;
            else
                playerWon_ = 1;
        }
    }

    void printWinner() {
        if (playerWon_ == 0) cout << "You lose";
        if (playerWon_ == 1) cout << "You Win";
    }
private:
    static const int numPlayers_ = 1;
    static const int minMoves_ = 1;
    static const int maxMoves_ = 3;

    int playerTot_;
    int compTot_;
    bool playerDone_;
    bool compDone_;
    char pass_ = 'y';

    //rolls and prints dice rolls, returns the total of all dice rolls
    void rollDice(string playerName, int& playerTotal) {
        int dice[5];
        int total = 0;
        cout << playerName << " rolled: ";
        for (int i = 0; i < 5; i++) {
            dice[i] = rand() % 6 + 1;
            cout << dice[i] << " ";
            total += dice[i];
        }
        // If the current score is greater then the highest score, 
        // sets it as the new highest
        if (total > playerTotal) playerTotal = total;
        cout << "= " << total << ", " << playerName << "'s highest score = " 
            << playerTotal << endl;
    }
};

int main() {
    srand(time(nullptr));

    Game* gp = nullptr;
    /*
    // play chess 10 times
    for (int i = 0; i < 10; ++i) {
        gp = new Chess;
        gp->playGame();
        delete gp;
    }
     

    // play monopoly 5 times
    for (int i = 0; i < 5; ++i) {
        gp = new Monopoly;
        gp->playGame();
        delete gp;
    }
    */
    gp = new Dice;
    gp->playGame();
    delete gp;
}