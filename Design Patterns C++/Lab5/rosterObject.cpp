// vector and list algorithms with objects in containers
// Mikhail Nesterenko
//Edited and Map implementation by Charles DeSmit
// 10/07/2020
#include <fstream>
#include <iostream>
#include <vector>
#include <list>
#include <string>
#include <cstdlib>
#include <map>
#include <utility>

using std::ifstream;
using std::string; using std::getline;
using std::list; using std::vector;
using std::cout; using std::endl;
using std::move; using std::map;

class Student {
public:
	Student(string firstName, string lastName) :
		firstName_(firstName), lastName_(lastName) {}

	// move constructor, not really needed, generated automatically
	Student(Student && org) :
		firstName_(move(org.firstName_)),
		lastName_(move(org.lastName_))
	{}

	// force generation of default copy constructor
	Student(const Student & org) = default;

	//prints "FirstName LastName"
	string print() const { return firstName_ + ' ' + lastName_; }
	//prints "LastName FirstName"
	string printReverse() const { return lastName_+ ' ' + firstName_; }


	// needed for unique() and for remove()
	friend bool operator== (Student left, Student right) {
		return left.lastName_ == right.lastName_ &&
			left.firstName_ == right.firstName_;
	}

	// needed for sort()
	friend bool operator< (Student left, Student right) {
		return left.lastName_ < right.lastName_ ||
			(left.lastName_ == right.lastName_ &&
				left.firstName_ < right.firstName_);
	}
private:
	string firstName_;
	string lastName_;
};




// reading a list from a fileName
void readRoster(list<Student>& roster, string fileName);
// printing a list out
void printRoster(const list<Student>& roster);
// print a map of students
void printMap(map<Student, list<string>>& roster);

int main(int argc, char* argv[]) {

	if (argc <= 1) {
		cout << "usage: " << argv[0]
			<< " list of courses, dropouts last" << endl; exit(1);
	}

	// vector of courses of students
	vector <list<Student>> courseStudents;

	for (int i = 1; i < argc - 1; ++i) {
		list<Student> roster;
		readRoster(roster, argv[i]);
		//cout << "\n\n" << argv[i] << "\n"; printRoster(roster);
		courseStudents.push_back(move(roster));
	}


	// reading in dropouts
	list<Student> dropouts;
	readRoster(dropouts, argv[argc - 1]);
	//cout << "\n\n dropouts \n"; printRoster(dropouts);

	//
	//List implementation
	//

	/*
	list<Student> allStudents;  // master list of students

	for (auto& lst : courseStudents)
		allStudents.splice(allStudents.end(), lst);

	cout << "\n\n all students unsorted \n";
	printRoster(allStudents);

	allStudents.sort(); // sorting master list
	cout << "\n\n all students sorted \n"; printRoster(allStudents);

	allStudents.unique(); // eliminating duplicates
	cout << "\n\n all students, duplicates removed \n"; printRoster(allStudents);

	for (const auto& str : dropouts)  // removing individual dropouts
		allStudents.remove(str);
	cout << "\n\n all students, dropouts removed \n"; printRoster(allStudents);
	*/

	//
	//Map implementation
	//
	
	//creating map of students
	//if student name is already in map, adds the class to their list 
	//else, adds new student pair to map
	map<Student, list<string>> allStudentsInClasses;
	int i = 1;
	for (auto& lst : courseStudents) {
		string filename(argv[i]);
		string csClass = filename.substr(0, 3);
		for (auto& stu : lst) {
			auto it = allStudentsInClasses.find(stu);
			if (it != allStudentsInClasses.end())
				it->second.push_back(csClass);
			else {
				/*auto ret =*/
				allStudentsInClasses.insert(std::make_pair(stu, list<string> {csClass}));
			}
		}
		++i;
	}
	//removes dropouts from map
	for (const auto& str : dropouts)
		allStudentsInClasses.erase(str);

	//print roster; Last name, then first name, then list of enrolled classes
	cout << "\n\nAll Students \nlast name, first name: courses enrolled \n"; 
	printMap(allStudentsInClasses);
	std::cin.get();
}


void readRoster(list<Student>& roster, string fileName) {
	ifstream course(fileName);
	string first, last;
	while (course >> first >> last)
		roster.push_back(Student(first, last));
	course.close();
}

// printing a list out
void printRoster(const list<Student>& roster) {
	for (const auto& student : roster)
		cout << student.print() << endl;
}

// printing a map out
void printMap(map<Student, list<string>>& roster) {
	for (const auto& stu : roster) {
		cout << stu.first.printReverse() << ": ";
		for (const auto& csClass : stu.second)
			cout << csClass << " ";
		cout << endl;
	}
}