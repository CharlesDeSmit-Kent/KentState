#pragma once
// drink class to be used in Coffee Shack lab
// Mikhail Nesterenko
// 11/15/2016

#include <set>
#include <string>

using std::string;

enum class DrinkType { small, medium, large };

////
////////////////// Decorator ////////////////////
////

//component
class Drink {
public:
    Drink(DrinkType type = DrinkType::small, float price = 0) :
        type_(type), price_(price) {}
    virtual float getPrice() const { return price_; }
    virtual std::string getName() const {
        if (type_ == DrinkType::small)
            return "small coffee";
        else if (type_ == DrinkType::medium)
            return "medium coffee";
        else
            return "large coffee";
    }
private:
    float price_;
    DrinkType type_;
};

// Sprinkles decorator
class Sprinkles : public Drink {
public:
    Sprinkles(const Drink* drink) : drink_(drink) {}
    float getPrice() const override { float total = drink_->getPrice(); return total + 0.5; }
    std::string getName() const override {
        std::string name = drink_->getName();
        int i = name.length() - 1;
        while (i != 0 && !isspace(name[i])) --i;
        std::string endOfName = name.substr(i + 1);
        
        if (endOfName == "coffee")
            return (name + " with sprinkles");
        else
            return (name + ", sprinkles");
    }
private:
    const Drink* drink_;
};

// Caramel Decorator
class Caramel : public Drink {
public:
    Caramel(const Drink* drink) : drink_(drink) {}
    float getPrice() const override { float total = drink_->getPrice(); return total + 0.2; }
    std::string getName() const override {
        std::string name = drink_->getName();
        int i = name.length() - 1;
        while (i != 0 && !isspace(name[i])) --i;
        std::string endOfName = name.substr(i + 1);

        if (endOfName == "coffee")
            return (name + " with caramel");
        else
            return (name + ", caramel");
    }
private:
    const Drink* drink_;
};

// Milk Foam decorator
class Foam : public Drink {
public:
    Foam(const Drink* drink) : drink_(drink) {}
    float getPrice() const override { float total = drink_->getPrice(); return total + 0.4; }
    std::string getName() const override {
        std::string name = drink_->getName();
        int i = name.length() - 1;
        while (i != 0 && !isspace(name[i])) --i;
        std::string endOfName = name.substr(i + 1);

        if (endOfName == "coffee")
            return (name + " with milk foam");
        else
            return (name + ", milk foam");
    }
private:
    const Drink* drink_;
};

// Ice decorator
class Ice : public Drink {
public:
    Ice(const Drink* drink) : drink_(drink) {}
    float getPrice() const override { float total = drink_->getPrice(); return total + 0.1; }
    std::string getName() const override {
        std::string name = drink_->getName();
        int i = name.length() - 1;
        while (i != 0 && !isspace(name[i])) --i;
        std::string endOfName = name.substr(i + 1);

        if (endOfName == "coffee")
            return (name + " with ice");
        else
            return (name + ", ice");
    }
private:
    const Drink* drink_;
};

////
/////////////////// Observer ////////////////////
////

// Observer
class Customer {
public:
    Customer(class Barista* s);
    virtual void notify() const = 0;
};

// Subject
class Barista {
public:
    void registerCustomer(Customer* o)
    {
        customers_.insert(o);
    }
    void deregisterCustomer(Customer* o)
    {
        customers_.erase(o);
    }
    void notifyCustomer() const {
        for (auto e : customers_) e->notify();
    }
private:
    std::set <Customer*> customers_;
};

Customer::Customer(Barista* s) {
    s->registerCustomer(this);
}


//Forward declaration of Concrete Barista/Subject 
class ConcreteBarista;

//Concrete Customer/Observer class
class ConcreteCustomer : public Customer {
public:
    ConcreteCustomer(const string&, ConcreteBarista*, Drink*);
    void notify() const override;
private:
    string name_;
    class ConcreteBarista* s_;
    Drink* order_;
};


//Concrete Barista/Subject class
class ConcreteBarista : public Barista {
public:
    ConcreteBarista(const string& name) :
        name_(name) {}
    //Change This
    void changeName(const string& name)
    {
        name_ = name; notifyCustomer();
    }
    const string& getName() const { return name_; }
private:
    string name_;
    std::set <Drink*> drinkOrders_;
};

ConcreteCustomer::ConcreteCustomer
(const string& name, class ConcreteBarista* s, Drink* order) :
    name_(name), s_(s),
    Customer(static_cast<Barista*>(s)), order_(order) {}

void ConcreteCustomer::notify() const {
    cout << "observer " << name_ << " reports "
        << "subject changed name to: "
        << s_->getName()
        << endl;
}