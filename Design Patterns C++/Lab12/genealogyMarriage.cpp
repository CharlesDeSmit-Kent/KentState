// traversing genealogical tree using Composite and Visitors
// Mikhail Nesterenko
// 10/28/2015

#include <iostream>
#include <string>
#include <vector>

using std::cout; using std::cin; using std::endl;
using std::string;
using std::vector;

class Person { // component
public:
    Person(string firstName, Person* spouse, Person* father, Person* mother) :
        firstName_(firstName), spouse_(spouse), father_(father), mother_(mother) {}
    string  getFirstName() { return firstName_; }
    Person* getSpouse() { return spouse_; }
    void    setSpouse(Person* spouse) { spouse_ = spouse; }
    Person* getFather() { return father_; }
    Person* getMother() { return mother_; }

    virtual string getFullName() = 0;
    virtual void accept(class PersonVisitor*) = 0;
    virtual ~Person() {}
private:
    const string firstName_;
    Person* spouse_;
    Person* father_;
    Person* mother_;
};

// leaf
// man has a last name 
class Man : public Person {
public:
    Man(string lastName, string firstName, Person* spouse,
        Person* father, Person* mother) :
        lastName_(lastName),
        Person(firstName, spouse, father, mother) {}
    const string getLastName() { return lastName_; }
    string getFullName() override { return getFirstName() + " " + getLastName(); }
    void accept(class PersonVisitor* visitor) override;
private:
    const string lastName_;
};

// composite
// woman has a list of children
class Woman : public Person {
public:
    Woman(vector<Person*> children,
        string firstName,
        Person* spouse,
        Person* father, Person* mother) :
        children_(children),
        Person(firstName, spouse, father, mother) {}
    const vector<Person*>& getChildren() {
        return children_;
    }
    void setChildren(const vector<Person*>& children) {
        children_ = children;
    }
    string getFullName() override {
        if (getSpouse() != nullptr) {
            return getFirstName() + " " + static_cast<Man*>(getSpouse())->getLastName();
        }
        else if (getFather() != nullptr) {
            return getFirstName() + " " + static_cast<Man*>(getFather())->getLastName();
        }
        else {
            return getFirstName() + " No-Last-Name";
        }
    }
    void accept(class PersonVisitor* visitor) override;

private:
    vector<Person*> children_;
};

// abstract visitor
class PersonVisitor {
public:
    virtual void visit(Man*) = 0;
    virtual void visit(Woman*) = 0;
    virtual ~PersonVisitor() {}
};

// composite methods that define traversal
void Man::accept(PersonVisitor* visitor){
    visitor->visit(this);
}

void Woman::accept(PersonVisitor* visitor) {
    // children traversal through mother only
    // father's children are not traversed so as not 
    // to traverse them twice: for mother and father

    visitor->visit(this);
    // traversing descendants
    for (auto child : children_) {
        child->accept(visitor);
        if (child->getSpouse() != nullptr) {
            child->getSpouse()->accept(visitor);
        }
    }
}

// concrete visitors
// the last name for a man is stored in object
// the last name a woman is determined by her 
// spouse if she is married
// or by her father if she is not
class NamePrinter : public PersonVisitor {
public:
    void visit(Man* m) override {
        cout << m->getFirstName() << " "
            << m->getLastName() << endl;
    }
    void visit(Woman* w) override {
        cout << w->getFirstName() << " ";
        if (w->getSpouse() != nullptr)
            cout << static_cast<Man*>(w->getSpouse())->getLastName();
        else if (w->getFather() != nullptr)
            cout << static_cast<Man*>(w->getFather())->getLastName();
        else
            cout << "Doe";
        cout << endl;
    }
};

class ChildrenPrinter : public PersonVisitor {
public:
    void visit(Man* m) override {
        cout << m->getFirstName() << ": ";
        Woman* spouse = static_cast<Woman*>
            (m->getSpouse());
        if (spouse != nullptr)
            printNames(spouse->getChildren());
        cout << endl;
    }
    void visit(Woman* w) override {
        cout << w->getFirstName() << ": ";
        printNames(w->getChildren());
        cout << endl;
    }
private:
    void printNames(const vector<Person*>& children) {
        for (const auto c : children)
            cout << c->getFirstName() << ", ";
    }
};

class MadienPrinter : public PersonVisitor {
public:
    void visit(Man* m) override {
        /*cout << m->getFirstName() << " " 
        << m->getLastName() << endl;*/
    }
    void visit(Woman* w) override {
        cout << w->getFirstName() << " ";
        if (w->getFather() != nullptr) {
            cout << static_cast<Man*>(w->getFather())->getLastName();
        }
        else {
            cout << "Doe";
        }
        cout << endl;
    }
};


class MarriageCheck : public PersonVisitor {
public:
    MarriageCheck(std::string thing1, std::string thing2)
        :thing1_(thing1), thing2_(thing2) {}

    // Man marries X
    void visit(Man* m) override {
        if (m->getFullName() != thing1_ && m->getFullName() != thing2_) return;

        //spouse
        if ((m->getFullName() == thing1_ || m->getFullName() == thing2_) && m->getSpouse() != nullptr) {
            marry_able_ = false;
            return;
        }

        //siblings
        if (m->getFullName() == thing1_ && m->getMother() != nullptr) {
            for (auto s : static_cast<Woman*>(m->getMother())->getChildren()) {
                if (s->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }

        }
        else if (m->getFullName() == thing2_ && m->getMother() != nullptr) {
            for (auto s : static_cast<Woman*>(m->getMother())->getChildren()) {
                if (s->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }

        }

        //aunt/uncle
        if (m->getFullName() == thing1_ && m->getMother() != nullptr && m->getMother()->getMother() != nullptr) {
            for (auto a : static_cast<Woman*>(m->getMother()->getMother())->getChildren()) {
                if (a->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }
        }
        else if (m->getFullName() == thing1_ && m->getFather() != nullptr && m->getFather()->getMother() != nullptr) {
            for (auto u : static_cast<Woman*>(m->getFather()->getMother())->getChildren()) {
                if (u->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }
        }

        if (m->getFullName() == thing2_ && m->getMother() != nullptr && m->getMother()->getMother() != nullptr) {
            for (auto a : static_cast<Woman*>(m->getMother()->getMother())->getChildren()) {
                if (a->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }
        }
        else if (m->getFullName() == thing2_ && m->getFather() != nullptr && m->getFather()->getMother() != nullptr) {
            for (auto u : static_cast<Woman*>(m->getFather()->getMother())->getChildren()) {
                if (u->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }
        }

    }

    //Woman marries X
    void visit(Woman* w) override {
        //spouse
        if ((w->getFullName() == thing1_ || w->getFullName() == thing2_) && w->getSpouse() != nullptr) {
            marry_able_ = false;
            return;
        }

        //children
        if (w->getFullName() == thing1_) {
            for (auto c : w->getChildren()) {
                if (c->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }

        }
        else if (w->getFullName() == thing2_) {
            for (auto c : w->getChildren()) {
                if (c->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }
        }

        //siblings
        if (w->getFullName() == thing1_ && w->getMother() != nullptr) {
            for (auto s : static_cast<Woman*>(w->getMother())->getChildren()) {
                if (s->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }

        }
        else if (w->getFullName() == thing2_ && w->getMother() != nullptr) {
            for (auto s : static_cast<Woman*>(w->getMother())->getChildren()) {
                if (s->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }

        }

        //aunt/uncle
        if (w->getFullName() == thing1_ && w->getMother() != nullptr && w->getMother()->getMother() != nullptr) {
            for (auto a : static_cast<Woman*>(w->getMother()->getMother())->getChildren()) {
                if (a->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }
        }
        else if (w->getFullName() == thing1_ && w->getFather() != nullptr && w->getFather()->getMother() != nullptr) {
            for (auto u : static_cast<Woman*>(w->getFather()->getMother())->getChildren()) {
                if (u->getFullName() == thing2_) {
                    marry_able_ = false;
                    return;
                }
            }
        }

        if (w->getFullName() == thing2_ && w->getMother() != nullptr && w->getMother()->getMother() != nullptr) {
            for (auto a : static_cast<Woman*>(w->getMother()->getMother())->getChildren()) {
                if (a->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }
        }
        else if (w->getFullName() == thing2_ && w->getFather() != nullptr && w->getFather()->getMother() != nullptr) {
            for (auto u : static_cast<Woman*>(w->getFather()->getMother())->getChildren()) {
                if (u->getFullName() == thing1_) {
                    marry_able_ = false;
                    return;
                }
            }
        }

    }

    bool get_marry() { return marry_able_; }

private:

    bool marry_able_ = true;
    std::string thing1_;
    std::string thing2_;

};

// demonstrating the operation
int main() {

    // setting up the genealogical tree      
    // the tree is as follows
    //    
    //
    //      James Smith     <--spouse-->   Mary 
    //	                                  |
    //	                                  ---------------------------------
    //	                                  |              |                |
    //	                                  |              |                |
    //	   William Johnson <--spouse-> Patricia     Robert Smith        Linda
    //	                                  |
    //	                                  -------------------
    //	                                  |                 |
    //                                     |                 |
    //	   Jennifer     <--spouse-->   Michael Johnson   Barbara
    //	       |
    //	     children
    //	       |
    //        |
    //	     Susan


       // first generation
    Man* js = new Man("Smith", "James", nullptr, nullptr, nullptr);
    Woman* ms = new Woman({}, "Mary", nullptr, nullptr, nullptr);
    ms->setSpouse(js); js->setSpouse(ms);

    // second generation
    Woman* ps = new Woman({}, "Patricia", nullptr, js, ms);
    Man* wj = new Man("Johnson", "William", nullptr, nullptr, nullptr);
    ps->setSpouse(wj); wj->setSpouse(ps);

    vector<Person*> marysKids = { ps,
                        new Man("Smith", "Robert", nullptr, js, ms),
                        new Woman({}, "Linda", nullptr, js, ms) };
    ms->setChildren(marysKids);

    // third generation
    Man* mj = new Man("Johnson", "Michael", nullptr, wj, ps);
    vector<Person*> patsKids = { mj, new Woman({}, "Barbara", nullptr, wj, ps) };
    ps->setChildren(patsKids);

    Woman* jj = new Woman({}, "Jennifer", nullptr, nullptr, nullptr);
    vector<Person*> jensKids = { new Woman({}, "Susan", nullptr, mj ,jj) };

    jj->setSpouse(mj); mj->setSpouse(jj);
    jj->setChildren(jensKids);

    // Asking for marriage advice
    string first, second, choose;

    do {
        // get the candidates 
        cout << "Enter first candidate: ";
        std::getline(cin, first);
        cout << '\n';
        cout << "Enter second candidate: ";
        std::getline(cin, second);
        cout << "\n\n";

        // check compatibility 
        bool marry_able = true;
        MarriageCheck* check = new MarriageCheck(first, second);
        if (first == second) { marry_able = false; }
        ms->accept(check);
        marry_able = check->get_marry();

        // print the results
        if (marry_able) { cout << "They can marry.\n\n"; }
        else { cout << "They can not marry.\n\n"; }
        cout << "Marry again? (Y/N)\n";
        std::getline(cin, choose);
        cout << "\n\n";
    } while (choose == "y" || choose == "Y");
}