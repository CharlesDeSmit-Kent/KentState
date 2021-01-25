// Reads a text file word by word and prints a list of words used
// Charles DeSmit
// 9/16/2020

#include <iostream>
#include <string>
#include <fstream>
#include <cctype>
#include "WordList.h" // class definitions

using std::cout; using std::endl; using std::string;

int main(int argc, char* argv[]) {

	std::ifstream wordFile;
    WordList theList;
    string word;
	wordFile.open(argv[1]);
    while (wordFile >> word) {
        for (auto c : word)
            if (ispunct(c) && c != '\'' && c != '-') // includes ' and - in words, ignores other puntuation
                word.erase(word.find_first_of(c));
        theList.addWord(word);
    }
    theList.print();
    std::cin.get();
}