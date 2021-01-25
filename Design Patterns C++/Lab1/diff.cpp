#include <iostream>
#include <fstream>
#include <string>

using std::cout;
using std::endl;
using std::string;

int main(int argc, char* argv[]) {
	//for (int i = 0; i < argc; ++i)
		//for (auto e : argv)
		//cout << argv[i] << endl;

	std::ifstream file1, file2;
	bool error, diffLen;
	string line1, line2;
	int counter, maxLoop, lineNum = 0;
	char c1, c2;

	//put the text in 2 strings
	file1.open(argv[1]);
	file2.open(argv[2]);
	while (!file1.eof() && !file2.eof()) {
		// initialize variables at start of each line
		lineNum++;
		counter = 0;
		error = false;
		diffLen = false;
		getline(file1, line1);
		getline(file2, line2);

		//check if the strings aren't the same length,
		//and set maxLoop to the size of the smaller string
		maxLoop = line2.size();
		if (line1.size() != line2.size()) {
			diffLen = true;
			if (line1.size() < line2.size())
				maxLoop = line1.size();
		}

		//check each letter for error
		while (counter < maxLoop && error == false) {
			c1 = line1[counter];
			c2 = line2[counter];
			if (c1 != c2)
				error = true;
			else
				++counter;
		}

		//print lines of theres an error
		if (error || diffLen) {
			cout << argv[1] << ": " << lineNum << ": " << line1 << endl;
			cout << argv[2] << ": " << lineNum << ": " << line2 << endl;
			string spaceString(strlen(argv[1]) + ((lineNum / 10)+1) + 4 + counter, ' ');
			cout << spaceString << "^" << endl << endl;
		}
	}

}