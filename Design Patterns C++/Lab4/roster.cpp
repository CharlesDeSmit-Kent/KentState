// vector and list algorithms
// Mikhail Nesterenko
// 9/23/2014

#include <fstream>
#include <iostream>
#include <vector>
#include <list>
#include <string>
#include <cstdlib>

#include <stdlib.h> //For VS debugging only

using std::ifstream;
using std::string; using std::getline;
using std::list; using std::vector;
using std::cout; using std::endl;
using std::move; using std::next;

// reading a list from a fileName
void readRoster(list<list<string>>& roster, string fileName, string className);

// printing a list out
void printRoster(const list<list<string>>& roster);

//comparing names
bool sameName(const list<string>& first, const list<string>& second) {
	bool flag = false;
	if (first.begin() == second.begin())
		if (next(first.begin()) == next(second.begin()))
			flag = true;
	return flag;
}

int main(int argc, char* argv[]) {

	if (argc <= 1) {
		cout << "usage: " << argv[0]
			<< " list of courses, dropouts last"
			<< endl; exit(1);
	}

	// vector of courses of students
	vector <list<list<string>>> courseStudents;

	//reading in class rosters
	for (int i = 1; i < argc - 1; ++i) {
		list <list<string>> roster;
		string file = argv[i];
		string className = file.substr(0, 3);
		readRoster(roster, argv[i], className);
		cout << "\n\n" << argv[i] << "\n";
		printRoster(roster);
		courseStudents.push_back(move(roster));
	}

	// reading in dropouts
	list <list<string>> dropouts;
	string name = "dropouts";
	readRoster(dropouts, argv[argc - 1], name);
	cout << "\n\n dropouts \n"; printRoster(dropouts);

	// master list of students
	list <list<string>> allStudents;

	for (auto& lst : courseStudents)
		allStudents.splice(allStudents.end(), lst);

	cout << "\n\n all students unsorted \n";
	printRoster(allStudents);

	// sorting master list
	allStudents.sort();
	cout << "\n\n all students sorted \n";
	printRoster(allStudents);

	// eliminating duplicates
	allStudents.unique();
	cout << "\n\n all students, duplicates removed \n";
	printRoster(allStudents);

	// removing individual dropouts
	for (const auto& str : dropouts)
		allStudents.remove(str);

	cout << "\n\n all students, dropouts removed \n";
	printRoster(allStudents);
	system("pause");
}

// reading in a file of names into a list of strings
void readRoster(list <list<string>>& roster, string fileName, string className) {
	ifstream course(fileName);
	string first, last;
	while (course >> first >> last) {
		list<string> student;
		student.push_back(first + " ");
		student.push_back(last + ":");
		student.push_back(" " + className);
		roster.push_back(move(student));
	}
	course.close();
}

// printing a list out
void printRoster(const list <list<string>>& roster) {
	for (const auto& str : roster) {
		for (const auto& stri : str)
			cout << stri;
		cout << endl;
	}
}