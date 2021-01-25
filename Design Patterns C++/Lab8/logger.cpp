//A simple program that shows the Singleton Logger in use
//Charles DeSmit
// 10/28/2020

#include <iostream>
#include <fstream>
#include <cstdlib>

using std::cout; using std::cin;
using std::string; using std::endl;

class Logger {
public:
	static Logger& instance() {
		static Logger L;
		return L;
	}
	// Prints which function was called to log.txt file
	void report(const string& func) { 
		fout_ << "Funtion " << func << " called" << endl;
	}
	// Close file on deletion
	~Logger() {
		fout_.close();
	}
private:
	// Open file on cration
	Logger() { fout_.open("log.txt", std::fstream::out | std::fstream::app); }
	Logger(const Logger&) {}
	Logger operator=(const Logger&) {}

	std::ofstream fout_;
};
// returns product of 2 ints
int multi(int x, int y) {
	Logger::instance().report("multi");
	return (x * y);
}
// prints result
void print(int x) {
	Logger::instance().report("print");
	cout << "The result is: " << x << endl;
}
int main() {
	int x, y, z = 0;
	cout << "Enter a number: ";
	cin >> x;
	cout << "Enter another number: ";
	cin >> y;
	//result is 5*(x*y)
	for (int i = 0; i < 5; i++) {
		z += multi(x, y);
	}
	print(z);
}
