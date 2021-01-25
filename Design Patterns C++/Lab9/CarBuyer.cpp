// needed for lab
// Mikhail Nesterenko
// 3/14/2016
// Modified by Charles Desmit
// 11/4/2020
#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <array>
#include "CarFactory.hpp"

using std::vector;
using std::cout; using std::endl;

class CarLot {
public:
    CarLot();
    Car* nextCar(int carNum); // returns car at the index given
    int lotSize() const; // returns the size of car lot array (10)
    // Car* testDriveCar() { return car4sale_; }

    // if a car is bought, requests a new one
    Car* buyCar(int carNum) {
        Car* bought = car4sale_[carNum];
        car4sale_[carNum] =
            factories_[rand() % factories_.size()]->requestCar();
        return bought;
    }
    

private:    
    Car* car4sale_[10]; // 10 cars for sale at the lot
    vector<CarFactory*> factories_;
    
};


CarLot::CarLot() {
    // creates 2 Ford factories and 2 Toyota factories 
    factories_.push_back(new FordFactory());
    factories_.push_back(new ToyotaFactory());
    factories_.push_back (new FordFactory());
    factories_.push_back(new ToyotaFactory());

    // gets the first car for sale
    for(int i = 0; i < lotSize(); ++i)
        car4sale_[i] = factories_[rand() % factories_.size()]->requestCar();
}

Car* CarLot::nextCar(int carNum){
    return car4sale_[carNum];
}

int CarLot::lotSize() const{
    return 10;
}

CarLot* carLotPtr = nullptr; // global pointer instantiation

// test-drives a car
// buys it if Toyota and randomly selected model
void toyotaLover(int id, std::string model) {
    if (carLotPtr == nullptr)
        carLotPtr = new CarLot();
    int testCar = 0; // The number of the current car in the lot (0-9)
    bool carFound = false; 

    cout << "Buyer " << id << " wants a Toyota " << model << endl;
    while (testCar < carLotPtr->lotSize() && !carFound) {
        Car* toBuy = carLotPtr->nextCar(testCar);
        if (toBuy->getMake() == "Toyota" && toBuy->getModel() == model) {
            carFound = true;
            cout << "They found the car! Buying car number " << testCar << endl << endl;
            carLotPtr->buyCar(testCar);
        }
        ++testCar;
    }
    if (!carFound)
        cout << "The car isn't in this lot. I'm leaving!" << endl << endl;
}

// test-drives a car
// buys it if Ford and randomly selected model
void fordLover(int id, std::string model) {
    if (carLotPtr == nullptr)
        carLotPtr = new CarLot();
    int testCar = 0; //number of current car in the lot (0-9)
    bool carFound = false;

    cout << "Buyer " << id << " wants a Ford " << model << endl;
    while (testCar < carLotPtr->lotSize() && !carFound) {
        Car* toBuy = carLotPtr->nextCar(testCar);
        if (toBuy->getMake() == "Ford" && toBuy->getModel() == model) {
            carFound = true;
            cout << "They found the car! Buying car number " << testCar << endl << endl;
            carLotPtr->buyCar(testCar);
        }
        ++testCar;
    }
    if (!carFound)
        cout << "The car isn't in this lot. I'm leaving!" << endl << endl;
}



int main() {
    srand(time(nullptr));
    static const std::array<std::string, 4>
        fordModels = { "Focus", "Mustang", "Explorer", "F-150" };
    static const std::array<std::string, 5>
        toyotaModels = { "Corolla", "Camry", "Prius", "4Runner", "Yaris" };

    const int numBuyers = 10;
    for (int i = 0; i < numBuyers; ++i)
        if (rand() % 2 == 0)
            toyotaLover(i, toyotaModels[rand() % toyotaModels.size()]);
        else
            fordLover(i, fordModels[rand() % fordModels.size()]);

}