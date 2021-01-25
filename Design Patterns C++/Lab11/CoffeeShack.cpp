#include "drink.h"
#include <iostream>

using std::cout; using std::endl;
using std::cin; using std::string;

int main() {
	cout << "Welcome to Coffee Shack! Can I get you a [l]arge, [m]edium, or [s]mall coffee? ";
	char size; cin >> size;
	Drink* order;
	if (size == 's')
		order = new Drink(DrinkType::small, 1.00);
	else if (size == 'm')
		order = new Drink(DrinkType::medium, 2.00);
	else
		order = new Drink(DrinkType::large, 3.00);
	char topping = 'q';
	while (topping != 'n') {
		cout << "Would you like to add [s]prinkles, [c]aramel, milk [f]oam, [i]ce, [n]ot? ";
		cin >> topping;
		if (topping == 's')
			order = new Sprinkles(order);
		else if (topping == 'c')
			order = new Caramel(order);
		else if (topping == 'f')
			order = new Foam(order);
		else if (topping == 'i')
			order = new Ice(order);
	}
	cout << "Can I get your name? ";
	string name; cin >> name;
	cout.precision(2);
	cout << endl << name << ", your " << order->getName() <<
		" is ready. It will be $" << std::fixed << order->getPrice() << ", please.";


}