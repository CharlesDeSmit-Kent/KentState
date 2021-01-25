// sorting oranges
// converting vectors to multimaps
// Mikhail Nesterenko
//
// Modified by Charles DeSmit
// 10/21/2020


#include <iostream>
#include <ctime>
#include <cstdlib>
#include <vector>
#include <deque>
#include <string>
#include <map>

using std::cin; using std::cout; using std::endl;
using std::string;
using std::vector;
using std::multimap;

enum class Variety { orange, pear, apple }; 
vector<string> colors = { "red", "green", "yellow" };

int main() {
    srand(time(nullptr));
    multimap<Variety, string> fruit;

    int random = rand() % 100 + 1;
    for (int f = 0; f != random; ++f) 
        fruit.insert(make_pair
        (static_cast<Variety>(rand() % 3), colors[rand() % 3]));

    cout << "Colors of the oranges: ";
    for (auto f = fruit.lower_bound(Variety::orange); 
        f != fruit.upper_bound(Variety::orange); ++f)
        cout << f->second << ", ";
    cout << endl;
}